package day06;

public class Practice_class { 

}


class Person { 
	int age; // 초기화값이 없는 변수는 생성자에서 초기화 할 예정이다.
	String name; //private 안주면, 데이터보호 없는 인스턴스변수다.. -> 외부에서 할당 가능해진다.
	
	public Person (int age, String name) {
		this.age = age;
		this.name = name;
	}
}

class Person2 {
	private int age; // 초기화 안했다면, 생성자에서 초기화 할 예정이다.
	private String name; // private을 준 인스턴스변수는 외부에서 접근이 안되므로, public 메서드(getter/setter)로 접근할 것이다.
	
	public Person2(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	// public [반환타입]으로 시작하는 갖다쓸수있는 [메서드] --> private한 변수에 접근하도록 도와준다.
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	// void도 [반환타입]으로서 [메서드]임을 인지한다.

	public void  setName(String name) {
		//**필요시**
		//-> **setter는 들어온 파라미터 검사 + [[[호출된 객체의 변경가능 검사]]]후 변경을 결정할 수 있게 된다.**
		this.name = name;
	}
	
}

class Singleton {
	//1. 생성자에 private을 걸어 1) 외부직접 생성 불가(메소드 간접생성은 가능할듯) & 2) class내부에서만 객체 생성가능.
	//2. class내부에서 private static으로 외부 직접모씆만 간접적으로 쓸 수 있는 & 메모리1순위로 쓸수있게 객체 생성을 해버린다.
	private static Singleton s = new Singleton();
	
	private Singleton() {}
	
	//3. 외부에서 편하게 유틸처럼 <이미 생성된 객체1개>는 편하게 쓸 수 있게 한다.
	public static Singleton getInstance() {
		return s;
	}
}

class AccessModifier {
	public static void main(String[] args) {
		Person p = new Person(20, "감자바");
		p.age = 30; // private이 아닌 변수는 외부에서 할당가능해진다.
		
		System.out.println(p.age);
		
		Person2 p2 = new Person2(20, "조재성");
//		System.out.println(p2.age); // 에러남. private은  객체.변수든 객체.메서드()든 접근 못함.
		System.out.println(p2.getAge()); // private 변ㅅ누는 public 반환타입의 메서드를 통해 값만 받아볼 수있다.
//		p2.name = "경"; // 에러남. private은 접근도 할당도 안됨.
		p2.setName("경");
		System.out.println(p2.getName()); // 
		
		
	}
	
}
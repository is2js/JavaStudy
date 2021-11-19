package day06;

public class 인터페이스심화정리 {

}



//* 1. 같은 카테고리(interface) 속 하위 [(구현체) 객체 중 택1 반환] 매니져: 인터페이스 참조변수의 다형성을 이용하여, 구현체(자식들)객체 중 택1 매니져 만들기 
//* 1-1. 카테고리를 interface로 정의하기, 하위 객체들이 반드시 가져야하는 공통 기능 = 추상메소드의 선언부만 정의해주기
//-> Paseable 하위 객체들은 [공통 기능]으로 parse를 가져야하며, [구체적인 것은  각자가 구현]할 수 있다.
interface Parseable {
	// 1-2. 인터페이스의 추상메소드는 접근지시자 없으면 public asbstract 생략
	void parse(String fileName);
}

//* 1-2. 하위 구현체(자식)들의 class는 상위 카테고리 interface를 구현하도록 class를 정의한다. 이 대 공통기능은
//Override 후 각자 구현한다.
class XMLParser implements Parseable {
	// my) 인스턴스메소드 정의는 public로 vs 유틸메소드는 public static 로 시작하자. 내부처리용 private.
	@Override
	public void parse(String fileName) {
		System.out.println(fileName + "-XML parsing");
	}

}

class HTMLParser implements Parseable {
	@Override
	public void parse(String fileName) {
		System.out.println(fileName + "-HTML parsing");
	}

}

//* 1-3. 유틸메소드용 (no public) Manager class 및 유텔메소드가 <조건에 따라> [카테고리 interface]를
//반환하도록 선언부 작성하여 -> 다형성으로 구현체(자식) 객체 택1 반환하도록 하기
class ParseManager {
	// 유틸메소드로 [구현체 객체 1개 택1 후]반환하도록 해준다. -> public static [return interface]
	// get메소드(조건) --> 추후 매니져.get하위객체1개( 조건 )
	// * interface는 기본설계도로서 객체생성x -> 반환자리에 있다면, 자식 구현체들 객체 받아서 반환되는 것이라 생각.
	public static Parseable getParse(String type) {
		if (type.equals("XML")) {
			// * parameter에 의해, 원하는 Interface구현체 1개 객체를 직접 생성해서 반환함.
			return new XMLParser();
		}
		return new HTMLParser();

	}

}

//* 2. 클래스 자손들중 일부자식들만의 기능을 구현하고 싶을 때,
//Character
/// \ \
//(zzangu) [doraemon][HarryPotter] -> 도라에몽과 해리포터만 마법쓸수있게
//* 2-1. 고민사항
//1) 마법메소드를 해당자식들 [각자 직접 구현] -> 중복 -> X
//2) 마법메소드를 [상위class에 적으면] -> 짱구 같이 [해당사항 없는 자식들이 강제 상속] -> X
//* 3) 인터페이스로 [일부만 가질수 있는 기능의 추상메소드들 생성] -> <공통기능을 가지도록 강제할 수 있는 일반interface기능>
//* [ 인터페이스 (각자구현X 공통구현용) 구현 public Class(1개의 파일) 추가생성] -> 나중에 공구객체.공통기능메소드();
//호출로 사용될 예정임. -> <코드중복을 막으려고 추상메소드를 공통구현하는 class를 만듦> -> < 해당자식들은 공구class
//객체사용만 함. >
//* [ 기능가질 일부자식들은 Interface 상속 & 내부에서는 public 공구class의 객체 생성 ->
//* [ Interface 추상메소드를 @override하지만, 내부구현은 공구class객체.공통기능메소드()로 사용만]
//Character Magical(public I)--->MagicalImpl(public C)
/// \ \ / \
//(zzangu) [doraemon][HarryPotter]---> new MagicalImpl.공구메소드();로 override

//* 2-2. 부분 카테고리 interface를 생성한다. 원래는 public interface여야하지만, 파일 1:1이라서 일단 생략.
interface Magical {
	// 추상메소드는 보통 public abstract를 생략하고 작성하나보다.
	void teleport();

	void fly();
}

//* 2-3. 공통구현메소드를 뿜뿜해줄 공통구현Class로 부분카테고리 interface를 상속하여 공통구현한다. public class인데
//1:1이라 생략
class MagicalImpl implements Magical {
	// * 인터페이스를 구현해놓고, 나중에 이 공구class의 객체를 통해, 공통(인트턴스)메소드로서 사용할 수 있게 할 것이다.
	@Override
	public void teleport() {
		System.out.println("순간이동");
	}

	@Override
	public void fly() {
		System.out.println("난다");
	}

}

class Character {
	String name;
	int age;

	public Character(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

//* 2-5. 공구class를 부분카테고리 자식들이 [new카테고리]상속 & 내부에서 [공구class객체로 추상메소드 override구현]
//하도록 하면 된다.
class Doraemon extends Character implements Magical {

	// * 2-6. 공구class의 객체를 이용하면, 부분카테고리 자식들이 각자 코드 작성안하고 재활용할 수 있다.
	// * 특이한 점은, 공구class는 상속이나 구현에 관계안되고 객체.메소드()로서 코드중복만 줄여준다.
	MagicalImpl m = new MagicalImpl();

	// 부모가 기본생성자가 아니면, 따로 super(,)를 활용해서 생성자 초기화 해줘야한다.
	public Doraemon(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void teleport() {
		m.teleport();
	}

	@Override
	public void fly() {
		m.fly();
	}

}

//* 3. 다중상속한 클래스를 만들고 싶을 때: 클래스와 달리 다중 상속이 가능하다.
//* -> 2개 이상의 class를 상속하고 싶을 때 -> 1개는 [class상속] + 1개는 [interface로 생성 ->
//구현후 내부에서 객체]로 사용
//* 3-1. class를 Interface로 상속하는 방법
//* 1) class의 메소드들만, 구현부를 삭제하고 Interface로 생성 ex> VCR -> IVCR
//* 2) 해당 interface를 implements하고 & 구현은 내부에서 [원본class-VCR객체를 생성해서 구현]
//** [인터페이스를 implements후 -> 이미 공통구현된 Class를 객체를 생성하여 <메소드 구현부 구현>에 사용]하는 것은
//** 2. 부분카테고리생성(I생성 -> 공구Class생성 -> I 구현후 공구Class객체로 메소드구현) 과
//** 3. 다중상속(추가상속받고 싶은 Class를 공구Class라 생각 -> 메소드로만 I생성 ->
//**** I 구현후 추가상속Class(공구Class)로 메소드구현 )이 동일하다.

//* 3-2. 실제 예제용, 2개의 부모클래스 기본 제공.
//ex> TV와 VCR 두 개의 클래스가 있고, TVCR 클래스를 새로 정의하여 앞의 두 클래스를 상속받고 싶다.
//1) 기본 클래스 2개
class Tv {
	protected boolean power;
	protected int channel;
	protected int volume;

	public void power() {
		power = !power;
	}

	public void channelUp() {
		channel++;
	}

	public void channelDown() {
		channel--;
	}

	public void volumeUp() {
		channel++;
	}

	public void volumeDown() {
		channel--;
	}
}

class VCR {
	protected int counter;

	public void play() {
		System.out.println("play");
	}

	public void stop() {
		System.out.println("stop");
	}

	public void reset() {
		this.counter = 0;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int c) {
		counter = c;
	}
}

//* 3-3. TV는 Class로서 상속 -> VCR은 인터페이스를 통한 상속으로 결정했다고 가정하자. -> interface로 만든다.
//* 1) 일단 2번째 상속하고 싶은 클래스를 내부공구메소드를 구현한 [공구Class]로 보며 ->
//* [메소드들만 뽑아서 Interface를 만든다.]
interface IVCR {
	public void play();

	public void stop();

	public void reset();

	public int getCounter();

	public void setCounter(int c);
}

//* 3-4. [class상속 & interface구현]후->2번째Class를 공구class로보고 내부 객체 생성후 메소드overide
class TVCR implements IVCR {
	// 2번째 class가 마치 부분카테고리Interface용 -> 공구Class가 되어버렸다.
	VCR vcr = new VCR();

	@Override
	public void play() {
		vcr.play();
	}

	@Override
	public void stop() {
		vcr.stop();
	}

	@Override
	public void reset() {
		vcr.reset();
	}

	@Override
	public int getCounter() {
		return vcr.getCounter();
	}

	@Override
	public void setCounter(int c) {
		vcr.setCounter(c);
	}

}

//* 4. 강한결합 -> 느슨한결합으로 변경
//* 4-1. 강한결합: A클래스의 [A메소드의 파라미터에( B b객체)를 ]로 받아, [A메소드 내부에서 b.인스턴스메소드()]사용
//* 강한결합 조건1) A를 작성하기 위해서 B가 반드시 존재해야한다.
//* 강한결합 조건2) B의 methodB()의 선언부가 변경되면, 이를 사용하는 A쪽의 코드도 변경되어야 한다.
//*** my) 메소드의 파라미터에는 객체 + 메소드 구현부에는 객체.메소드()를 호출하며, 객체의 인스턴스메소드()를 호출하므로, B메소드
//*** 선언부가 바뀌면, A호출 코드도 바뀌어야함.
//* my) B객체를 받아 B메소드를 쓰게 되면, (B메소드 구현부는 달라져도 호출시 알아서 작동하지만,)
//* my) -> **B의선언부**가 달라지면 A의 코드 자체(B메소드 호출코드)가 달라져야한다.
//고쳐야한다>
//class A {

//public void methodA(B b) {
//b.methodB();
//}
//}

//class B {

//public void methodB() {
//System.out.println("methodB()");
//}
//}

//* 4-2. 느슨한결합: 강한결합의 A<-> B클래스 사이를 interface를 통해 느슨하게하여 A<->C클래스도 잘 연결되게
//* my) 메서드 추상화로 인터페이스를 만들고, 그 인터페이스를 파라미터로 -> 다형성에 의해 I)구현타클래스도!!연결
//* 1) 객체를 파라미터로 받고, 객체.인스턴스메소드()를 호출하여 메소드구현에 도움을 주는 classB를 interface화
//* 2) A에서는 파라미터로 객체B가 아닌 [classB로 만든 인터페이스] 를 받음. -> B는 다시 구현되어야함.
//** 이 떄, B의 추상화 interface는 다른클래스 C, D 등 구현체의 부모가 될 수 있으며, 구현체라면 A 파라미터가능
//A <-------------> Interface[ from B but 다시구현후 B, C, D... 구현class들을 다 연결시켜줌]
//* 3) B의 메소드를 추상화해서 만든 Interface지만, 새로운 클래스도 implements I를 통해, 그 메소드를 구현가능.
//* 4) B든 C든 어떠한 클래스의 객체도 받을 수 있다.

//* 4-3. Aclass 내부에서 호출되는 강한결합 Bclass에 대해, B메소드들 추상화로 인터페이스를 만든다.
interface I {
	// B메소드를 추상화하여 만들었음. -> 나중에 B는 다시 이걸 implements해서 B를 구현해야됨. 그래야 A파라미터 I)에 드갈수있음.
	void methodB();
}

//* 4-4. Bclass는 다시 I를 구현한 구현체(자식)class로 정의한다.(공구class는 아님.. 이 객체가 다시 쓰이진 않고,
//이 class와 비슷한 I구현 타 class들이 자리를 대신할 것임)

class B implements I {
	public void methodB() {
		System.out.println("methodFromB in B class");
	}
}

//* 4-5. A에서는 직접적인 class B대신, B를 추상화 시킨 Interface를 파라미로 + I.추상메서드()로 호출되게 한다.
class A {
	public void methodA(I i) {
		i.methodB();
	}
}

//* 4-6. B클래스를 대신할 C클래스를 생성한다면, I를 구현 및 메소드를 그대로 구현해서, A가 호출되는데 불편함이 없게한다.
class C implements I {
	public void methodB() {
		System.out.println("methodBFromB in C class~!");
	}
}

class Interface2 {
	public static void main(String[] args) {

		// * 1-4. Manager클래스의 유틸메소드를 이용해서 원하는 구현체자식들 중 1개를 반환받는데, [참조변수를 Interface 타입]으로
		// 받는다!!
		Parseable parser = ParseManager.getParse("XML");
		// -> 공동기능이자 각자 구현된 기능메소드를 활용하면 된다.
		parser.parse("asdfasf");

		// * 3-5. 1개는class, 1개는 interface생성후 공구class로 공구객체->override시 사용 하여 만든 2개 class
		// 다중상속 test
		TVCR tvcr = new TVCR();
		System.out.println(tvcr.getCounter()); // from TV class
		tvcr.play(); // from VCR class

		// * 4-7. A는 내부에서 I로 객체를 받고, I를 구현한 객체(다형성).인스턴스메소드()로 호출되는 내부 메소드로직이 있어서
		// * A의 메소드에는, I를 구현한 어느 클래스든 들어올 수 있다.(A와 I의 느슨결합)
		A a = new A();
		a.methodA(new B());
		a.methodA(new C());
	}
}

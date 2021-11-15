package day04;

public class Practice1_ClassTest {

	public static void main(String[] args) {
//		 1. 만약 class를 이용하지 않고, 1개 시간당 시,분,초를 관리해야한다면?
//		int hour;
//		int minute;
//		float second;

		// 시간이 여러개라면? -> 순서를 맞춰서 배열로 여러개를만들어 각 index마다 1개의 시간으로 간주한다.
		int num = 3;
		int[] hour = new int[num];
		int[] minute = new int[num];
		float[] second = new float[num];

	}
}


//* [사용자정의타입]인 class를 이용하면, 다른종류(int, float.. )의 데이터도 묶어서 저장할 수 있다. like 구조체
//class Time {
//	int hour;
//	int minute;
//	float second;
//}

//* class를 이용하면, 제약조건을 서관 함수로서 처리할 수 있다.
//- 제약조건 -> 외부 [직접 변수 변경 불가]로 (setter)함수를 통해서 -> 변수들은 밖에서 접근불가하게 private화 시키기.
//-> 외부에서 클래스 및 함수는 써야하니 함수는 public으로 만들기
//
//public class Time {  // -> public class는 다른데서도 쓸 수 있도록,  .java파일과 1:1매칭되어야한다!!!!!!!!!!
class Time {
	private int hour;
	private int minute;
	private float second;

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public float getSecond() {
		return second;
	}

	public void setHour(int h) {
		// 제약조건 검사하고, 외부인자 통과하면 넣어주기
		if (!(0 <= h && h <= 24))
			return;
		hour = h; // 멤버변수 대입시 this는 안들어간다?? 생성자에서만 온리 this사용함?!
	}

	public void setMinute(int m) {
		if (!(0 <= m && m <= 59))
			return;
		minute = m;
	}

	public void setSecond(float s) {
		if (!(0.0f <= s && s <= 59.99f))
			return;
		second = s; // 멤버변수 대입시 this는 안들어간다?? 생성자에서만 온리 this사용함?!
	}

}

	

	

	
	
	
	

// **static안붙은 객체생성후 쓰는 [인스턴스변수]**의 경우만, 생성자를 이용한 final멤버변수의 초기화도 가능하다. (어디서 final은.. 생성과 동시에 초기화해줘야한다고 햇는데..)
class Card { 
	final int NUMBER; // ****static안붙은 변수는, 바로 못쓴다 객체. 생성해서 쓴다.
	final String KIND;
	static int width = 100; // 객체마다 다른값 가질 거아니면, static으로 선언
	static int height = 250;

	// 생성자는... 클래스명(초기화할 값을 받는 인수)만.. 있으면 된다.
	// this는?
	// 생성자에서 상수를 초기화해주면, 에러가 없어진다.
	Card(String kind, int num) {
		this.KIND = kind;
		this.NUMBER= num;
	}
	
	// 생성자가 아무것도 안받을때도 있다.. 그것도 정의해줘야.. 없이 생성이 된된다?
	Card() {
		// 아무것도 안받으면, this( , )형태로--> 인자있는 생성자를 호출하도록 직접 걸어준다..
		this("HEART", 1);
	}
	
	public String toString() {
		return KIND + " " + NUMBER;
	}
	
	
}


class FinalCardTest {
	public static void main(String[] args) {
		Card c = new Card("HEART", 10); // 객체 생성시, 생성자를 통해 값이 -> 상수로 저장된다.
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c);
		
	}
}



// 객체 생성 실습
class Target {
	String str; // static없으면 인스턴스변수 -> 객체 생성후 사용
	int num; // ****멤버변수를 초기화 안해주면, 객체마다 int형이면 0 등의 기본값이 미리 들어가있다.
	
	void up() { ++num; } //static없으면 인스턴스메소드 -> 객체 생성후 사용 -> 객체마다 적용. num은 객체의 num이 올라간다!
	void donw() { --num; }
}

class App {
	public static void main(String[] args) {
		Target tg = new Target(); //    Target클래스 타입의 참조변수 tg를 선언했다. 연산자 new에 의해 Target클래스의 인스턴스가 메모리의 빈 공간에 생성되는데, new를 사용하기 전 tg만 선언되었을 때는 인스턴스가 생성되지 않았기 때문에 아무것도 할 수 없다.		
		// 멤버변수는 각 자료형에 해당하는 기본값으로 초기화 된다.
		System.out.println(tg.num);


		tg.num = 7;
		tg.up();
		System.out.println(tg.num);
	}
}



// 생성자 실습 -> 생성자가 아예 없을 때만, 기본ㅅ성자가 제공되고, 만약, 매개변수를 받는 생성자를 생성했다면, 기본생성자는 제공되지 않는다. 따로 정의해야한다.

// 클래스 구현 순서: 필드 -> 생성자 -> 메소드
class Date1 {
	int value; 
	/*생성자가 아예 없을 때 기본 메서드 Date1() { }가 제공된다. */
}

class Date2 {
	int value;
	
	Date2(int x) {
		value = x;
	} // 생성자를 1개 이상 입력하는 순간, 기본 생성자는 제공 안된다.
}

//Date1 d1 = new Date1(); //기본 생성자로 생성하기
//Date2 d2 = new Date2(); //파라미터를 받는 생성자는 있지만, 기본생성자 제공받아보기  -> 에러남  -> The constructor Date2() is undefined

// 테스트용으로 no public class(파일없는 클래스)로 Main을 만들어서 >  main함수를 넣어 테스트하자.
class TestMain {
	public static void main(String[] args) {


	}
}
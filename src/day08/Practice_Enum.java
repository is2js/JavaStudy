package day08;

public class Practice_Enum {
	public static void main(String[] args) {
		System.out.println(Card.CLOVER);
		System.out.println(Card.ACE);
		System.out.println(Card.CLOVER == Card.ACE);
		//3. 상수와 다르게 클래스.Enum명.상수로 접근한다. -> 이 때, Enum명이 타입이다.
		System.out.println(Card.Kind.CLOVER);
		System.out.println(Card.Value.ACE);
//		System.out.println(Card.Kind.CLOVER == Card.Value.ACE); //에러
		
	}

}

class Card {
	// 1. 상수
	static final int CLOVER = 0;
	static final int HEART = 1;
	static final int DIAMOND = 2;
	static final int SPADE = 3;
	
	static final int ACE = 0;
	static final int TWO = 1;
	static final int THREE = 2;
	
	// 2. 상수를 class내에서 Enum으로 변환?  바로 Enum을 생성해도 되지만, 상수-> Enum으로 전환한 듯.
	// enum Class처럼Enum명 { 배열처럼, 상수, 나열}
	enum Kind { CLOVER, HEART,  DIAMOND, SPADE }
	enum Value { ACE, TWO,  THREE }
	
}

enum Jusik{
	// 3. enum의 중괄호속 상수에 ()괄호로 값 부여시 -> 부여되는 값의 종류에 따라 생성자를 만들라고 에러가 뜬다.
	// -> 맨마지막에 ;세미콜론도 찍어줘야하네..
	// -> The constructor Jusik(int, double) is undefined
	SAMSUNG(85600, -1.27),
    APPLE(158450, 0.17),
    TESLA(977313, -1.74),
    AMD(104817, -3.48),
    INTEL(61102, -0.91);

	//5. 값을 받아줄 변수 선언 (코드보면 private final로서,, 인스턴스 상수로 만드네..
	private final int  i;
	private final double d;
	
	Jusik(int i, double d) {
		//4. 생성자를 생성했지만, 넘어오는 파라미터에 대해, 값을 받아줄 변수도 필요하다...
		this.i = i;
		this.d = d;
	}
	
	//6. private해서 외부에서도 갖다스려면, getter를 만들어준다.
	public int getI() {
		return i;
	}
	public double getD() {
		return d;
	}
}


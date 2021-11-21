package day08;

public class Enum {

	//1. enum이란?  자바 데이터 타입 중 참조타입의 한 종류
	// 상수를 편리하게 선언하기 위한 것으로 여러 상수를 정의할 때 사용하면 유리.  JDK1.5부터 새롭게 추가되었다. 
	// 자바의 열거형은 **열거형이 가지는 값**만 관리하는 것이 아니라 **타입까지 관리**하기 때문에 논리적인 오류를 줄일 수 있다.
	// **-> 자바의 열거형은 타입에 안전한 열거형(typesafe enum)이라서 실제 값이 같아도 타입이 다르면 컴파일 에러가 발생한다. 값 뿐만 아니라 타입까지 체크하기 때문에 타입에 안전하다고 한다.**
	// -> 실습.
//	if(Card.CLOVER == Card.TWO)             // true이지만 false이어야 의미상 맞음
//    if(Card.Kind.CLOVER == Card.Value.TWO)  // 컴파일 에러. 값은 같지만 타입이 다름
	
	//2. 열거형의 정의
	// **1) 기존상수 -> enum열거형으로 묶어주기 **
//	   기본적으로 상수명은 대문자로 작성하고, 여러 단어일 경우 언더바로 이어주는 것이 관례이다.
	
	//enum 열거형이름 { 상수명1, 상수명2, ... }
	
	//enum JuSik { SAMSUNG, APPLE, TESLA, AMD, ... }

//	 public enum 열거형이름 {
//    상수명1,
//    상수명2,
//     ...
//    상수명N;
//}
	
//    public enum Week {
//        MONDAY,
//        TUESDAY,
//        WEDNESDAY,
//        THURSDAY,
//        FRIDAY,
//        SATURDAY,
//        SUNDAY;
//    }

	// **2) 열거형 상수에 괄호를 붙여서 값을 부여할 수 있다. 값을 부여하는 경우, 이에 해당하는 생성자도 함께 정의해줘야 한다.**
	// -> 통일돈 type으로 값을 주어야됨. + 부여되는 값의 type에 따라 생성자도 만들어줘야함.
	// -> **my)  괄호 -> 생성자 -> 생성자담을 private 변수들 -> 그 변수를 꺼내줄 getter들까지 -> 최종으로는 enum객체.getter()로 하나씩 꺼내야한다.**
	// -> 실습
//
//    public enum JuSik {
//        SAMSUNG(85600, -1.27),
//        APPLE(158450, 0.17),
//        TESLA(977313, -1.74),
//        AMD(104817, -3.48),
//        INTEL(61102, -0.91);
//
//        private final double closingPrice;
//        private final double fluctuationRate;
//
//        JuSik(double closingPrice, double fluctuationRate) {
//            this.closingPrice = closingPrice;
//            this.fluctuationRate = fluctuationRate;
//        }
//
//        public double getCP() {
//            return closingPrice;
//        }
//        public double getFR() {
//            return fluctuationRate;
//        }
//    }
	
	// 3. enum사용
	// 1) public enum 2개의 참조변수 선언 -> 필요할때 객체 생성해서 초기화 ->
	// 2) 입력받기-> enum기본 static메서드 Enum.vauleOf(String);으로  String 인자를 기준으로 enum의 인스턴스를 가져온다.
	//   -> 등록되지 않은 enum의 상수(String)을 입력하는 경우 java.lang.IllegalArgumentException이 발생
	// -> 해당 enum객체를 생성한 상태에서, getter를 이용하면, 상수속 괄호값을 가져올 수 있다.
	// -> 실습.
	
	//4.  enum이 제공하는 메소드
	// : toString()과 name()은 사실 같은 역할을 하는데 둘의 차이는 Override가 가능한가 불가능한가의 차이이다. 이는 final 메소드에 의해 발생하는 차이이다.
	// name( ) : 	열거형 상수의 이름을 문자열로 반환한다.
	// ordinal( ): 	열거형 상수가 정의된 순서(0부터 시작)를 정수로 반환한다.
	// toString( ): 열거형 상수의 이름을 문자열로 반환한다.
	// compareTo( ): 정렬의 기준을 위한 메서드로 비교 대상보다 순서가 빠르면 -1, 같으면 0, 느리면 1을 반환한다.
	// **valueOf(enumType, name): 지정된 열거형에서 name과 일치하는 열거형 상수를 반환한다.**
	// getDeclaringClass( ): 열거형의 Class 객체를 반환한다.
	// values( ): 열거형의 모든 상수를 배열에 담아 반환한다. 
	
//	public final String name()
//	public final int ordinal()
//	public String toString()
//	public final boolean equals(Object obj)
//	public final int hashCode()
//	public int compareTo(E obj)
//	public static <T extends Enum> T valueOf(Class enumType,String name)
//	public final Class <E> getDeclaringClass() // enum 객체의 타입 반환
//	public final Object clone() throws CloneNotSupportedException
//	protected final void finalize()
	
	
	//5. java.lang.Enum : 모든 열거 타입은 컴파일 시 java.lang.Enum 클래스를 상속받는다. 따라서 단일 상속만 허용되는 자바이기 때문에 enum은 별도의 상속을 받을 수 없다.
	// - java.lang.Enum 클래스도 최고조상인 Object클래스를 상속받는데, 대부분은 final이어서 Override할 수 없지만 toString 메소드는 final이 아니어서 사용할 수 있다.
	
	
	//6. EnumSet:   EnumSet은 Set 인터페이스를 기반으로 열거형 타입으로 지정해놓은 요소들을 보다 빠르게 배열처럼 다룰수 있는 기능을 제공한다.
	// -> EnumSet은 모든 메소드가 static 키워드를 사용하여 정의되어 있기 때문에 별도의 객체 생성없이 사용할 수 있다고 하는데 사실은 객체를 생성할 수 없는 것이다. API 문서를 보면 알 수 있듯이 이 클래스는 abstract 키워드를 사용한 추상 클래스이기 때문이다.
//allOf(Class elementType): 지정한 Type의 모든 원소를 포함하는 EnumSet을 만든다.
//clone(): 이 집합의 복사본을 반환한다.
//complementOf(EnumSet s): 지정한 EnumSet에 포함되지 않은 원소만 갖는 동일한 Type의 EnumSet을 만든다.
//copyOf(Collection c): 지정한 Collection에서 초기화된 EnumSet을 만든다.
//copyOf(EnumSet s): 지정한 EnumSet과 동일한 Type을 가진 EnumSet을 만든다. 이 때, 처음과 동일한 원소(원소가 있는 경우)를 포함한다.
//noneOf(Class elementType):지정한 Type을 가지는 빈 EnumSet을 만든다.
//of(E e), of(E first, E… rest), of(E e1, E e2): 지정한 원소(또는 원소들)를 포함하는 EnumSet을 만든다.
//range(E from, E to): 지정된 두 원소 사이에 있는 모든 원소를 포함하는 EnumSet을 만든다. 
	
//	package me.gracenam.study.week11;
//
//	import java.util.EnumSet;
//
//	public class EnumSetEx {
//	    public static void main(String[] args) {
//	        EnumSet<Champ> enumSet = EnumSet.allOf(Champ.class);
//
//	        System.out.println("> 전부 출력");
//	        System.out.println(enumSet);
//	        System.out.println();
//
//	        EnumSet<Champ> fureAd = EnumSet.of(Champ.VAYNE, Champ.CAITLYN);
//
//	        System.out.println("> 특정 원소만 출력(퓨어AD)");
//	        System.out.println(fureAd);
//	        System.out.println();
//
//	        System.out.println("> 퓨어AD를 제외하고 출력");
//	        System.out.println(EnumSet.complementOf(fureAd));
//	        System.out.println();
//
//	        System.out.println("> 범위 출력(초창기 원딜)");
//	        System.out.println(EnumSet.range(Champ.MISSFORTUNE, Champ.VAYNE));
//	        System.out.println();
//	    }
//	}
//
//	enum Champ {
//	    MISSFORTUNE, ASH, CAITLYN, VAYNE, KAISA, SENNA
//	}
	
	
	
}

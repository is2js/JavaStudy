package day08;

public class Practice_Enum_Coffee {

	public static void main(String[] args) {
		
		// 2. 열거형 상수 가져오는 3가지 방법 -> 열거형을 Type으로 하는 참조변수에 3가지로 뽑아올 수 있음.
		// 1) class 스태틱 공용변수로서 뽑아오기
		Coffee c1 = Coffee.AMERICANO;
		// 2) enum.valueOf("상수명")으로  -> Sting으로 형변환을 이용한 enum뽑아오기
		Coffee c2 = Coffee.valueOf("AMERICANO"); 
		// 3) Enum.valueOf( 이넘.클래스, "상수명"); 으로 -> String + class객체? 이용하기
//		Coffee c3 = Enum.valueOf(Coffee.class, "AMERICANO"); 
		
		// 3. 출력해보기
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
//		System.out.println("c3 = " + c3);
		
		System.out.println("c1 == c2 ? " + (c1 == c2));
		System.out.println("c1.equals(c2) ? " + (c1.equals(c2)));
		System.out.println("c1.compareTo(c2) ? " + (c1.compareTo(c2)));
		
		// 4. Enum.values();의 상수들을 배열로 반환함. -> 향상된 for문으로 배열 다 뽑아보기
		// -> 각 enum 상수들은 .name() , .ordinal()의 내부메소드가 있다.
		Coffee[] cArr = Coffee.values();
		for (Coffee c : cArr) {
			System.out.printf("%s = %d \n", c.name(), c.ordinal());
		}
	}
}


// 1. 열거형 : 서관상수들의 카테고리화 및 Type으로 지정
// - 줄바꿈안하면 세미콜론필요없음. 
// - 괄호에 값 안넣으면 생성자 필요없음. -> 한줄로 표현 가능
enum Coffee { AMERICANO, LATTE, MOCHA, CAPPUCCINO }



package day03;

import java.util.Scanner;

public class Practice1_이름붙은반복문 {
	public static void main(String[] args) {
//		// 이름붙은 반복문 실습;
//		int menu = 0;
//		int num = 0;
//
//		Scanner sc = new Scanner(System.in);
//
//		outer: while (true) {
//			// 선택시마다 반복해서 보기를 준다.
//			System.out.println("(1) square");
//			System.out.println("(2) sqaure root");
//			System.out.println("(3) log");
//			System.out.println("(0) exit");
//			System.out.println("원하는 계산(1~3)을 선택하세요. >");
//
//			String str = sc.nextLine();
//			menu = Integer.parseInt(str);
//
//			// 1. 종료부터 필터링
//			if (menu == 0) {
//				System.out.println("프로그램을 종료합니다.");
//				break; // 가장 바깥 무한반복문을 종료해서 프로그램이 종료되게 함.
//				// 2. (종료가 아닐 때) 범위검사로 필터링 -> 다시 처음부터 시작 -> continue ( 무한반복에서의 건너뛰기는 다시시작이다! )
//			} else if (!(1 <= menu && menu <= 3)) {
//				System.out.println("잘못된 입력입니다. 다시 입력해주세요");
//				continue;
//			}
//
//			// 3. 1~3으로 정상범위의 입력이 들어왔을 때, -> 내부에서 무한반복 다시 시작
//			// - 내부에서도 입력을 계속 받아야하므로 반복문이 돌아간다. 이 때, [계산종료가 아닌 전체종료]시 break -> 전체 break가
//			// 되도록, -> 바깥반복문의 이름을ㅇ ㅣ용한 break -> break outer;를 사용한다.
//			for (;;) {
//				System.out.println("계산할 값을 입력하세요. (계산 종료: 0, 전체 종료: 99) >");
//				str = sc.nextLine(); // my) 문자열, 숫자를 받아줄 변수를 계속 반복해서 쓴다. scanner변수를 반복해서 쓰듯이..?
//				num = Integer.parseInt(str);
//				// 4. 값을 입력받았으면 종료필터링 부터
//				if (num == 0)
//					break;
//				if (num == 99) {
//					System.out.println("시스템을 종료합니다.");
//					break outer; // 이름붙은 바깥 반복문을 종료한다. (핵심)
//				}
//				
//				// 5. switch로 선택한 값에 따라 계산함.
//				switch (menu) {
//					case 1:
//						System.out.println("result = " + (num * num));
//						break;
//					case 2:
//						System.out.println("result = " + Math.sqrt(num));
//						break;
//					case 3:
//						System.out.println("result = " + Math.log(num));
//						break;
//						
//				} // for(;;)로 계산할 값 입력하라고 무한반복뜸.
//
//			}
		
//		// flag 대신 break -> while문 실습
//		int num;
//		int sum = 0;
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("합계를 구할 숫자를 입력하세요( 0입력시 종료)");
//		
//		while (true) {
//			System.out.printf(">>");
//			num = scanner.nextInt();
//			if (num == 0) break;
//			sum += num;
//			
//		}
//		System.out.println("총 합계 : " + sum);
		
		
//		//continue 실습
//		for (int i = 1; i <= 10; i++) {
//			// 1부터 들어온다면 2의 배수 감별사 -> 2의 배수만 건너띄기
//			if (i % 2 == 0) continue;
//			System.out.println(i);
//		}

	}
}

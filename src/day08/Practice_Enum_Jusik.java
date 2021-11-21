package day08;

import java.util.Scanner;

public class Practice_Enum_Jusik {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1. enum 참조변수를 하나씩 만들어놓고, 있다가 초기화
		System.out.println("====== HTS START ======");
		System.out.println("거래소를 선택하세요.");
		System.out.println("1. KRX / 2. NASDAQ ");
		int selectNumber = Integer.parseInt(sc.nextLine());
		Krx krx;
		Nasdaq nasdaq;
		
		if (selectNumber == 1) {
			System.out.println("원하시는 회사를 선택해주세요. SAMSUNG, NAVER, KAKAO");
			String cooperate = sc.nextLine();
			// 2. String -> Enum명.static메소드인 valueOf 로 실제 enum값을 가져온다.
			krx = Krx.valueOf(cooperate);
			// 3. enum객체. getter()로 상수의괄호의 값을 가져온다.
			System.out.println("종가(달러) = " + krx.getCP()); 
			System.out.println("전일대비 변동(%) = " + krx.getFR()); 
		} else {
			System.out.println("원하시는 회사를 선택해주세요. APPLE, TESLA, AMD, INTEL");
			String cooperate = sc.nextLine();
			nasdaq = Nasdaq.valueOf(cooperate);
			System.out.println("종가(달러) = " + nasdaq.getCP()); 
			System.out.println("전일대비 변동(%) = " + nasdaq.getFR()); 
		}
		
		
		System.out.println("종료돠었습니다.");
		sc.close();
		
		
		
	}

}



enum Krx {
    SAMSUNG(85600, -1.27),
    NAVER(355500, 4.10),
    KAKAO(461500, -0.75);

    private final double closingPrice;
    private final double fluctuationRate;

    Krx(double closingPrice, double fluctuationRate) {
        this.closingPrice = closingPrice;
        this.fluctuationRate = fluctuationRate;
    }

    public double getCP() {
        return closingPrice;
    }
    public double getFR() {
        return fluctuationRate;
    }
}

enum Nasdaq {
    APPLE(142.06, -0.77),
    TESLA(864.16, -2.14),
    AMD(88.84, -6.20),
    INTEL(53.59, -2.93);

    private final double closingPrice;
    private final double fluctuationRate;

    Nasdaq(double closingPrice, double fluctuationRate) {
        this.closingPrice = closingPrice;
        this.fluctuationRate = fluctuationRate;
    }

    public double getCP() {
        return closingPrice;
    }
    public double getFR() {
        return fluctuationRate;
    }
}
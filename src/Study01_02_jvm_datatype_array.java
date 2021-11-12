
public class Study01_02_jvm_datatype_array {

	public static void main(String[] args) {
		
		// 1. JVM
		// class(바이트코드, 0or1, 가상환경용 이진표현) in 프로젝트 or in .jar --[1)클래스 로더]--> JVM's RuntimeDataArea  --[2)실행 엔진(JITor인터프리터)]--> 바이너리코드(0or1) -> CPU
		// [3)GC] : 사용하지 않는 오브젝트, 메모리 정리  /  [4) RuntimDataArea]: OS에서 할당받은 JVM의 메모리 공간
//		클래스 로더:  컴파일러가 내부에 만든 .class(바이트 코드)를 런타임 데이터 공간에 “적재”한다.
//		런타임 데이터 공간: OS로부터 메모리를 할당받은 공간으로 스택, 힙, 메소드, 네이티브 메소드, PC 레지스터가 있다.
//		GC: 메모리를 정리하는 역할이다.
//		실행 엔진: 인터프리터 방식 또는 JIT 컴파일러를 이용하여 데이터 영역에 배치된 바이트 코드를 실행한다.
		
		// 2. 자바 컴파일 및 실행과정
//		컴파일)
//		1. 소스 파일 생성한다. (Hello.java)
//		2. 자바 컴파일러(javac.exe)를 사용하여 컴파일한다. $ javac Hello.java
//		3. 컴파일이 정상적으로 완료되면 클래스 파일 생성된다. (Hello.class)
//		실행)
//		1. 프로그램의 실행에 필요한 클래스(*.class파일)을 로드한다.
//		2. 클래스파일을 검사한다.(파일형식, 악성코드 체크)
//		3. 지정된 클래스(Hello)에서 main(String[] args)을 호출한다.
		
//		JDK: JDK는 Java Development Kit으로 자바 프로그래밍 시 필요한 컴파일러 등을 포함한다. JDK는 JRE를 포함하며, 개발을 위해 필요한 도구(java, javac 등)를 포함한다.
//		JRE: JRE는 Java Runtime Enviroment로 컴파일된 자바 프로그램을 실행시킬 수 있는 자바 환경을 말한다. JRE는 JVM의 실행환경을 구현했다고 볼 수 있으며, JVM이 자바 프로그램을 동작시킬 때 필요한 라이브러리 파일들과 기타 파일들을 가지고 있다.
		
		// 3. 변수와 타입
		// 상수: 변수선언시 앞에 final + 변수명 대문자로 준다.
		// 리터널: [상수]== [변하지 않는 저장공간]을 의미하게 되어, [현실속 변하지 않는 값 자체] == "리터널"로 부른다.
		int octNum = 010; // 8진수는 0을 앞에 붙인다.
		int hexNum = 0x10;
		int binNum = 0b10;
		long longNum = 100L; // 정수는 int가 기본임.  L을 붙혀줘야 long type 리터럴으로 구분
		
		long big = 100_000_000_000L; //21억이상은 int면 에러나기 때문에 L로 long type 리터럴을 넣어줘야 에러안난다? (L을 안붙이면 int라서 에러남)
		
		
		float pi = 3.14f; // 실수는 double이 기본임. f를 붙혀줘야 float type 리터럴으로 구분
		System.out.println(pi);
//		float pi = 3.14; // f리터럴이 없다면 double이 기본인데, float에 할당 못함!! 에러!!
		// my) long타입 정수이거나 float타입 실수를 할당할 때는, 리터럴값에 접미사를 꼭 달아주자.
		long l = 123;   // OK. int보다 long 타입의 범위가 더 넓다.
		double d = 3.14f;   // OK. float 보다 double 타입의 범위가 더 넓다.
		
//		int i = 0x123456789;    //  ERROR. int 타입의 범위를 넘는 값 저장.
//		float f = 3.14;         //  ERROR. float 타입보다 double 타입의 범위가 넓다.
		
//		문자 리터럴과 문자열 리터럴
//		'A'와 같이 작은 따옴표로 문자 하나를 감싼 것을 문자 리터럴 이라고 한다. 두 문자 이상은 큰 따옴표로 감싸야 하며 문자열 리터럴이라고 한다.
		// - 문자열이 하나도 없으면 문자가 아닌 문자열 리터럴로 취급하니, 반드시 1개문자만 문자 리터럴(공백이라도 있어야함)
		String str = "";    // OK
//		char ch = '';   // ERROR. ''안에 반드시 하나의 문자 필요
		char ch = ' ';  // OK. 공백문자(blank)로 변수 ch 초기화
		
		
		
		
		// 4. 변수선언과 초기화
		// static 메서드 ex> main 안에서는, 외부 변수 중 static 달린 변수만 사용가능하다.
		
		//변수종류 3가지
		// 멤버변수1 : static 붙은 클래스 변수(= 모든 인스턴스 공유변수)
		// 멤버변수2 : static 안붙은 인스턴스 변수
		// 지역변수 : 메서드내부에서 선언된 변수
		
		//멤버변수의 초기화는 지역변수와 달리 여러 가지 방법이 있다.
		//1. 명시적 초기화(explicit initialization)
		//2.생성자 (constructor)
		//3. 초기화 블럭 (initialization block)
		//	인스턴스 초기화 블럭 :  인스턴스변수를 초기화 하는데 사용
		//	클래스 초기화 블럭 : static클래스변수를 초기화 하는데 사용
//		class InitBlock {
//			  static {
//			    // 클래스 초기화 블럭 : 클래스가 메모리에 처음 로딩 될 때, 한 번만 수행된다.
//			  }
//			  {
//			    // 인스턴스 초기화 블럭 : 인스턴스가 생성될 때 마다 실행된다. + 생성자 보다 인스턴스 초기화 블럭이 먼저! 수행된다.
				// 인스턴스 변수의 초기화는 주로 생성자를 사용한다. 단 모든 생성자에서 <+ 인수없는 생성자로 생성시에도> 공통으로 수행해야 할 코드(ex> 인스턴스 생성시마다 count++; number = count;)가 있을 때, 인스턴스 초기화 블럭을 사용한다.
//			  }
//			}
		
		//클래스변수의 초기화 순서 기본값 -> 명시적초기화 -> 클래스 초기화 블럭
		//인스턴스변수의 초기화 순서 기본값 -> 명시적초기화 -> 인스턴스 초기화 블럭 -> 생성자
		//클래스변수는 항상 인스턴스변수보다 먼저 생성되고 초기화된다.
		
		// 5. 타입 변환과 추론
		double dd = 99.9;
		int score = (int) dd; // 큰 것을 작은데에다 넣는 것을 강제 형변환이다.
		
		
		
		// 자바에서는 일반 변수에 대해 타입 추론을 지원하지 않기 때문에 자바에서의 타입 추론은 제네릭과 람다에 대한 타입 추론을 뜻한다.
		// Java 10에서 var 키워드가 추가되었는데, 이 키워드는 선언과 동시에 초기화가 필수적으로 요구된다. + 지역변수로만 사용가능함.
		// <> 다이아몬드 연산자에서 사용 불가 / null 불가  / 배열에서 사용불가
		// var message = "Hello"
		
//		var n; // 초기화 되지 않음.
//		var emptyList = null; // null로 초기화해도 동작하지 않음
//		public var = hello; // 지역변수가 아닌경우 사용 불가능
//		var arr = {1, 2, 3}; // 배열일 경우에도 타입이 명시적으로 필요
//		var arrayList = new ArrayList<>(); // <> 연산자 안에 타입 명시적으로 작성 필요
//		주의할 점으로는 타입이 드러나지 않는 경우에는 다른 개발자들의 코드 가독성을 헤칠 수 있다는점,
//		파이프 라인이 긴 스트림에서 사용할 때는 예상 결과와 다를 수 있다는 점을 주의하자.
		
		
		//6. 배열
		//배열생성은 new type[길이], new type[row길이][col길이]
		//배열은 생성과 동시에 자동적으로 자신의 타입에 해당하는 기본값으로 초기화되므로 따로 초기화하지 않아도 되지만, 원하는 값을 저장할 수도 있다.
		//-> 갯수를 안주고 직접 기본값로 초기화도 가능하네..
		int[] score2 = new int[5];
		int[] score3 = new int[] { 50, 60, 70, 80, 90};
		System.out.println(score2[1]); // 빈 배열은 0이 들어가있다.
		System.out.println(score3[1]); // dict처럼 배열의 값을 직접 지정도 가능하네.
		int[] score4 = { 50, 60, 70, 80, 90 }; //new int[] 를 생략해서 기본값만으로도 배열을 생성할 수 있다.
		System.out.println(score4[1]);
		
		// 2차원 배열도 기본값을 넣어주고 선언 가능하다. 이중 중괄호
		int[][] score5 = new int[3][4];
		int[][] arr = {
				{1,2,3},
				{4,5,6}
		};
		System.out.println(arr[0][0]);// java는 행만 출력은 안된다. (참조 주소값뜸)
		
		
		// 7. unsigned
		//Java 8부터는 정수형 리터럴 중간에 구분자 ‘_‘를 넣을 수 있게 되어서 큰 숫자를 편하게 읽을 수 있게 되었다.
//		 int unsigned = 2_100_000_000;
//		 System.out.println(unsigned + 100_000_000); // 21억을 int는 출력못하고 오버플로우		
		 // java8부터 추가된 parseUnsignedInt
//		parseUnsignedInt만으로는 출력이 되지 않고 들어 있는 값을 unsigned 값으로 하겠다는 toUnsignedString을 사용해서 출력해야한다.
//		따라서 22억처럼 큰 값을 사용할 때는 Unsigned를 사용하기 보다는 BigInteger 또는 long을 쓰는 편이 좋다.
//		 int unsigned = Integer.parseUnsignedInt("2200000000");
//		 System.out.println(Integer.toUnsignedString(unsigned));

	}
}

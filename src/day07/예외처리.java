package day07;

public class 예외처리 {
	
	// 1. try-catch문: 하나의 try블럭 다음에는 여러 종류의 예외를 처리할 수 있도록 하나 이상의 catch블럭이 올 수 있으며, 이 중 발생한 예외의 종류와 일치하는 단 한 개의 catch블럭만 수행
	// -> catch블럭의 괄호 내에 선언된 변수는 catch블럭 내에서만 유효하기 때문에 위의 모든 catch블럭에 참조변수 e 하나 만을 사용해도 된다.
	// -> 그러나 catch블럭 내에 또 하나의 try-catch문이 포함된 경우, 같은 이름의 참조변수를 사용해서는 안 된다. 각 catch블럭에 선언된 두 참조변수의 영역이 서로 겹치므로 다른 이름을 사용해야만 서로 구별되기 때문
//    try {
//        try { } catch (Exception e) { } 
//    } catch (Exception e) {
//        try { } catch (Exception e) { } // 에러. 변수 e가 중복.
//    } // try-catch 끝
	
	//1) try블럭 내에서 예외가 발생한 경우, 발생한 예외와 일치하는 catch블럭이 있는지 확인한다.
	//2) 일치하는 catch블럭을 찾게 되면, 그 catch블럭 내의 문장들을 수행하고 전체 try-catch문을 빠져나가서 그 다음 문장을 계속해서 수행한다. 만일 일치하는 catch블럭을 찾지 못하면, 예외는 처리되지 못한다.
	//-> try블럭에서 예외가 발생하면, 예외가 발생한 위치 이후에 있는 try블럭의 문장들은 수행되지 않으므로, try블럭에 포함시킬 코드의 범위를 잘 선택
	
	
	
	//2. catch블럭: 괄호( )와 블럭{ } 두 부분으로 나눠져 있는데, 괄호 내에는 처리하고자 하는 예외와 같은 타입의 참조변수 하나를 선언해야한다.
	//예외가 발생하면, 발생한 예외에 해당하는 클래스의 **인스턴스**가 만들어진다. 예를 들어 ArithmeticException이 발생했다면 ArithmeticException인스턴스가 생성된다. 
	// 예외가 발생한 문장이 try블럭에 포함되어 있다면, 이 예외를 처리할 수 있는 catch블럭이 있는지 찾게된다.
	//첫 번째 catch블럭부터 차례로 내려가면서 catch블럭의 괄호 내에 선언된 참조변수의 종류와 생성된 예외클래스의 인스턴스에 instanceof연산자를 이용해서 검사하게 되는데, 검사결과가 true인 catch블럭을 만날 때까지 검사는 계속된다
	//+  모든 예외 클래스는 Exception클래스의 자손이므로, catch블럭의 괄호에 Exception클래스 타입의 참조변수를 선언해 놓으면 어떤 종류의 예외가 발생하더라도 이 catch블럭에 의해서 처리된다.
	
	// try블럭에서 ArithmeticException이 발생하였으므로 catch블럭을 하나씩 차례로 검사하게 되는데, 첫 번째 검사에서 일치하는 catch블럭을 찾았기 때문에 두 번째 catch블럭은 검사하지 않았다. 만일 ArithmeticException이 아닌 다른 종류의 에러가 발생한 경우에는 두 번째 catch블럭인 Exception클래스 타입의 참조변수를 선언한 곳에서 처리되었을 것이다.
	// * catch 특정예외 -> catch Exception 예외:  **먼저 해당예외가 발생하면 밑에 예외는 해당하더라도 처리 안하고 나간다.**


	//3. printStackTrace()와 getMessage():    예외가 발생했을 때 생성되는 예외 클래스의 인스턴스에는 발생한 예외에 대한 정보가 담겨져 있으며, getMessage()와 printStackTrace()를 통해서 이 정보들을 얻을 수 있다.
	//printStackTrace(): 예외 발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
	//getMessage(): 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.

	
	//4. 멀티 catch블럭: JDK 1.7부터 여러 catch블럭을 |기호를 이용해서, 하나의 catch블럭으로 합칠 수 있게 되었다. 이러한 형태를 ‘멀티 catch블럭’이라 한다. 
	//    이 때 사용되는 |기호는 논리 연산자가 아니라 기호이며, 연결할 수 있는 예외 클래스의 개수에는 제한이 없다.
//    try {
//        ...
//    } catch (ExceptionA | ExceptionB e) {
//        e.printStackTrace();
//    }
	
	//만일 멀티 catch 블럭의 기호로 연결된 예외 클래스가 조상과 자손의 관계에 있다면 컴파일 에러가 발생한다.
	//두 예외 클래스가 조상과 자손의 관계라면, 조상클래스만 써주는 것과 똑같기 때문에 불필요한 코드를 제거하라는 의미에서 에러가 발생한다.


	
	//5. throw e:  키워드 throw를 사용해서 예외를 고의로 발생시킬 수 있다.
	// 1) 연산자 new를 이용해 발생시키려는 예외 클래스의 객체를 만든다.
	// 	- Exception e = new Exception(“예외 발생”);
	// 2) 키워드 throw를 이용해서 예외를 발생시킨다.
	// 	- throw e;
	// -> Exception인스턴스를 생성할 때, 생성자에 String을 넣어주면 메시지로 저장된다. 이 메시지는 getMessage()를 이용해서 얻을 수 있다.
//	class App {
//	    public static void main(String[] args) {
//	        try {
//	            Exception e = new Exception("예외 발생");
//	            throw e;
//	        } catch (Exception e) {
//	            System.out.println("에러 메시지 : " + e.getMessage());
//	            e.printStackTrace();
//	        }
//	        System.out.println("프로그램 정상 종료");
//	    }
//	}
	
	// 5-1.throws : 메소드에 예외를 선언하려면, 메소드 선언부에 키워드 throws를 사용해서 메소드 내에서 발생할 수 있는	예외를 적어주면 된다. 예외가 여러개라면 쉼표로 구분한다. 
	// 메서드에 예외선언 for **사용할 사람에게 선언부에서 미리 알려주기**
	//예외를 처리하는 방법 중에는 예외를 메서드에 선언하는 방법이 있다.
	//메서드에 예외를 선언하려면 메서드 선언부에 키워드 [[throws를 사용해서 메서드 내에서 발생할 수 있는 예외를 적어주기]]만 하면 된다. 그리고 여러 개일 경우에는 쉼표로 구분한다.
//   void method() throws Exception1, Exception2, ... , ExceptionN {
//        // 메서드의 내용
//    }
	
	//-> **메서드의 선언부에 예외를 선언함으로써 메서드를 사용하려는 사람이 메서드의 선언부를 보았을 때, 이 메서드를 사용하기 위해서는 어떠한 예외들이 처리되어야 하는지 쉽게 알 수 있다.
	//->메서드에 예외를 선언할 때 일반적으로 RuntimeException클래스들은 적지 않는다. throws에 선언한다고 해서 문제가 되지는 않지만, 보통 반드시 처리되어야 하는 예외들만 선언한다
	//->예외를 메서드의 throws에 명시하는 것은 **예외를 처리하는 것이 아니라, [[ 자신을 호출한 메서드에게 예외를 전달하여 예외처리를 떠맡기는 것]] 이다.**
	// ->예외를 전달받은 메서드는 자신을 호출하는 또다른 메서드에게 전달할 수 있으며, 이런 식으로 계속 호출스택에 있는 메서드들을 따라 전달되다가 마지막에 main메서드에서도 예외가 처리되지 않으면, main메서드가 종료되면서 프로그램 전체가 종료된다.
	// -> **   결국 예외는 처리되는 것이 아닌 단순히 전달만 되는 것이므로 결국 어느 한 곳에서는 try-catch문으로 처리를 해주어야 한다**
	
	
	//6.finally블럭
	//finally블럭은 try-catch문과 함께 예외 발생여부에 상관없이 실행되어야할 코드를 포함시킬 목적으로 사용된다. try-catch문의 끝에 선택적으로 덧붙여 사용할 수 있으며, try-catch-finally의 순서로 구성된다.
//
//	    try {
//	        // 예외가 발생할 가능성이 있는 문장
//	    } catch (Exception e) {
//	        // 예외처리를 위한 문장
//	    } finally {
//	        // 예외 발생 여부에 관계없이 항상 실행되어야 할 문장
//	        // try-catch문의 마지막에 위치해야 한다.
//	    }
//
	//->예외가 발생하면 ‘try → catch → finally’순으로 실행되고, 예외가 발생하지 않은 경우에는 ‘try → finally’
	
	//7. 자동 자원 반환 - try-with-resources문: finally에 입출력.close()를 넣어줬는데, 예외발생가능이라서 또 내부에 try /catch가 발생 -> finally 예외발생시 try 속 close()가 씹힘되는 문제점
	//->  **괄호 안에 객체를 생성하는 문장을 넣으면, 이 객체는 따로 close()를 호출하지 않아도 try블럭을 벗어나는 순간 자동적으로 close()가 호출된다. 이 후 catch블럭 또는 finally블럭이 수행**
//	try (FileInputStream fis = new FileInputStream("score.dat");
//	         DataInputStream dis = new DataInputStream(fis)) {
//	        while(true) {
//	            score = dis.readInt();
//	              ...
//	        }   
//	    } catch (EOFException e) {
//	        System.out.println(" ... ");
//	    } catch (IOException ie) {
//	        ie.printStackTrace();
//	    }
	
	//8. Exception과 Error의 차이는?  자바에서는 실행 시(runtime) 발생할 수 있는 프로그램 오류를 에러(Error)와 예외(Exception), 두 가지로 구분한다.
	//1) 에러 Error : 메모리 부족(OutOfMemoryError)이나 스택오버플로우(StackOverflowError)와 같은 발생하게 되면 복구할 수 없는 심각한 수준의 오류를 뜻한다. 
	//     시스템에 비정상적인 상황이 생겼을 때 발생하므로 System level의 문제이다.
	//2) 예외 Exception: 	예외는 개발자가 작성한 로직 내에서 발생한 오류를 뜻한다. 따라서 발생하더라도 개발자가 이에 대한 적절한 코드를 미리 작성해 놓음으로써 프로그램의 비정상적인 종료와 같은 오류를 방지할 수 있다.
	//     에러(error) 프로그램 코드에 의해서 수습될 수 없는 심각한 오류. 예외(exception) 프로그램 코드에 의해서 수습될 수 있는 상대적으로 미약한 오류
	
	
	//9. RuntimeException과 RE가 아닌 것의 차이는?
	//1) Exception클래스와 그 자손들 -> RE아닌 것. checked Exception
//		: 외부의 영향으로 발생하는 것들로, 프로그램 사용자들의 동작에 의해서 발생하는 경우가 많다.
//		존재하지 않는 파일의 이름을 입력했다던가(FileNotFoundException)
//		실수로 클래스의 이름을 잘못 적었다던가(ClassNotFoundException)
//		입력한 데이터 형식이 잘못된(DataFormatException)
	//2) RuntimeException클래스와 그 자손들 -> RE. Unchecked Exception
//		: 주로 프로그래머의 실수에 의해서 발생될 수 있는 예외들로 자바의 프로그래밍 요소들과 관계가 깊다.
//		배열의 범위를 벗어난다던가(ArrayIndexOutOfBoundsException)
//		값이 null인 참조변수의 멤버를 호출하려 했다던가(NullPointerException)
//		클래스 간의 형변환을 잘못했다던가(ClassCastException)
//		정수를 0으로 나누려고(ArithmeticException)
//      ->	명시적인 처리를 강제하지 않고, 실행되는 시점(Runtime)에 확인
//		-> Checked Exception이 발생할 가능성이 있는 메소드라면 반드시 try ~ catch로 감싸거나 throw로 던져서 처리해야 한다.
//		-> 반면에 Unchecked Exception은 명시적인 예외처리를 하지 않아도 된다. 대부분의 예외가 부주의로 발생하고, 예측하지 못했던 상황의 예외가 아니기 때문에 굳이 로직으로 처리 할 필요가 없도록 만들어져 있다.


	//10. 기본적으로 제공하는 RuntimeException들
//	Arithmetic exception
//	산술 연산에서 예외 조건이 발생했을 때 발생합니다.
//	ArrayIndexOutOfBounds Exception
//	잘못된 인덱스로 Array에 액세스했을 때 발생합니다. 인덱스가 음수이거나 배열 크기보다 크거나 같을 때 입니다.
//	ClassNotFoundException
//	정의한 클래스를 찾을 수 없을 때 발생하는 예외입니다.
//	FileNotFoundException
//	이 예외는 파일에 액세스할 수 없거나 열리지 않을 때 발생합니다
//	IOException
//	입출력 작업이 실패하거나 중단될 때 발생합니다
//	InterruptedException
//	Thread가 waiting, sleeping 또는 어떤 처리를 하고 있을 때 interrupt가 되면 발생하는 예외입니다.
//	NoSuchMethodException
//	찾을 수 없는 메서드에 액세스할 때 이 예외가 발생합니다
//	NullPointerException
//	이 예외는 null 객체의 멤버를 참조할 때 발생합니다.
//	NumberFormatException
//	메서드가 문자열을 숫자 형식으로 변환할 수 없는 경우 이 예외가 발생합니다
//	StringIndexOutOfBoundsException
//	문자열에 엑세스 하는 인덱스가 문자열보다 큰 경우거나 음수일 때 발생하는 예외입니다
	
	//11. 예외처리 전략
	
	//1) 예외 복구 :정상 상태로 돌려놓는 방법으로 어떤 예외로 발생하였을 때 다른 작업 흐름으로 자연스럽게 유도해주는 것이다. 가장 대표적으로 try-catch-finally
	//-> (예외 처리되어 다른 작업 흐름으로 이어짐)
	
	//2) 예외처리 회피: 자신이 직접 예외처리하지 않고 호출하는 메소드로 전파시키는 방법이다.
	//-> throws 문으로 예외를 회피하는 방법과 catch 블럭으로 일단 예외를 잡은 후에 로그를 남기고 다시 throw 하는 방법
	
	//3) 예외 전환: 발생한 예외를 그대로 넘기지 않고 더 적절한 예외로 전환하여 던지는 특징
	//-> 예외를 전환할 때는 기존 예외를 담아서 중첩 예외로 만드는 것이 좋다.
//	
//catch (SQLException e) {
//    throw new DuplicateUserIdException(e);
//}
	



	
	
	

}
	
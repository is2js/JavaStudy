package day05;

public class 상속 {
	
	// 1. 상속: 적은 양의 코드로 새로운 클래스를 작성할 수 있고 코드를 공통적으로 관리할 수 있기 때문에 코드의 추가 및 변경이 매우 용이
	//상속계층도(class hierarchy): child -> parent 부모쪽으로 화살표를 가리킴 ex> 준서?
	//자손 클래스는 조상 클래스의 [모든 멤버를 상속]받기 때문에 [조상 클래스에 멤버변수가 추가되면 자손 클래스에 자동적으로 멤버변수가 추가]된 것과 같은 효과를 얻는다.
	//my) 부모에 공통 속성or기능을 추가하면 -> 자식 일괄적용되나보다.
	//my) 개별기능은 자식에서 추가 -> 부모에 영향x
	//**생성자와 초기화 블럭(변수와 메서드 사이에있던..)은 상속되지 않는다. 멤버(변수, 메서드)만 상속된다.**
	//-> 위의 Parent 클래스에 age라는 변수를 멤버변수로 추가하면, 자손 클래스는 조상의 멤버를 모두 상속받기 때문에 Child 클래스는 자동으로 age라는 멤버변수를 갖게된다.
	// -> 대로 자손 클래스인 Child에 play() 메소드를 추가하자. 이때, Child 클래스에 새로운 코드가 추가되어도 조상인 Parent 클래스는 아무런 영향도 받지 않는다.
	
	// 2. 클래스 간의 관계 - 포함(composite) :  상속이외에도 클래스를 재사용하는 방법 -> 한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언
	// - circle이 x,y,r가질 것을... 이미생성된  point 클래스를 이용해서 p.x, p.y, r을 인스턴스변수로 가지게 할 수있다.
	// -> 하나의 거대한 클래스를 작성하는 것보다 간결하고 손쉽게 클래스를 작성할 수 있다.
//    class Circle {
//        Point c = new Point(); // 타  클래스의 객체(참조변수)를 멤버변수(인스턴스변수)로 선언해서 사용
//        int r;
//    }
	
	// 3. 단일 상속(single inheritance) ->  자바에서는 단일 상속만을 허용
	// - 다중상속: 클래스간의 관계가 복잡해지고 서로 다른 클래스로부터 상속받은 멤버의 이름이 같은 경우 구별할 수 있는 방법이 없다는 단점
	
	// 4. super 키워드: 조상 클래스로부터 상속받은 멤버를 참조하는데 사용되는 참조변수 super.(부모클래스에있던 멤버변수) 로 사용
	// my)구별용이다. 원래 내꺼 [this.변수] vs 생성자통해 들어오는 [매개변수]. 이름같을 때 처럼
	// cf) this는 생성자이외에 인스턴스변수나 인스턴스메서드 앞에 언제든지 붙일 수 있다.
	// my) [super.부모한테 받은 변수] vs [자식이 새롭게 정의한 변수] 이름이 같을 때
	//** static 메소드(클래스메소드)는 인스턴스와 관련이 없다. ->  따라서 this와 마찬가지로 super 역시 static메소드에서는 사용할 수 없고 인스턴스 메소드에서만 사용할 수 있다.**
	
	
//	class Parent {
//        int x = 10;
//    }
//
//    class Child extends Parent {
//
//        void method() {
//            System.out.println("x = " + x); // this가 생략된 인스턴스변수 x from Parent
//            System.out.println("this.x = " + this.x); // 인스턴스변수 x from Parent
//            System.out.println("super.x = " + super.x); // ****결과는 x, this.x, super.x 모두 같은 변수를 의미하므로 모두 10이 출력된다.
//        }
//    }
	
	
//	class Parent {
//        int x = 10;
//    }
//
//    class Child extends Parent {
//		  int x = 20;
//
//        void method() {
//            System.out.println("x = " + x); // this가 생략된 인스턴스변수 x -> 20
//            System.out.println("this.x = " + this.x); // 인스턴스변수 x -> 20 
//            System.out.println("super.x = " + super.x); // 부모꺼 x -> 10 -> **겹치면, x: 자식정의변수(멤버변수) >>> 부모상속변수**
//        }
//    }
	
	
	// super.메서드(): 조상 클래스의 메서드를 자손 클래스에서 오버라이딩시  super.부모메서드()를 호출해서 return값 활용하여 새롭게 메소드 정의할 경우에 super를 사용
//    class Point3D extends Point {
//        int z;
//
//        String getLocation() {
//            return super.getLocation() + ", z : " + z; // 부모메서드 오버라이딩한 뒤 추가 정의
//        }
//    }
	
	// 5. super() : 부모class의 생성자 호출  cf) this(): 생성자내부에서 타생성자 부를 때! 첫줄에 입력!
	// 자손 클래스의 인스턴스를 생성하면, 자손의 멤버와 조상의 멤버가 모두 합쳐진 하나의 인스턴스가 생성된다. 그래서 자손 클래스의 인스턴스가 조상 클래스의 멤버들을 사용할 수 있는 것인데, 이 때 조상 클래스 멤버의 초기화 작업이 수행되어야 하기 때문에 자손 클래스의 생성자에서 조상 클래스의 생성자가 호출되어야 한다.
	// my) ->[상속시 필수!] 자식이 부모 변수 쓰기전에 초기화해야하니까, 자식 자기변수 초기화이전에 부모꺼도 초기화해야지!!
	// -> 모든 클래스의 첫 줄에 반드시 자신의 다른 생성자 또는 조상의 생성자를 호출해야 한다. 그렇지 않으면, 컴파일러가 생성자 첫 줄에 'super();' 를 자동적으로 추가
	// -> 생성자의 첫 줄에서 조상클래스의 생성자를 호출해야하는 이유는 자손 클래스의 멤버가 조상 클래스의 멤버를 사용할 수도 있으므로 조상의 멤버들이 먼저 초기화되어 있어야 하기 때문이다.
	// -> Object 클래스를 제외한 모든 클래스의 생성자는 첫 줄에 반드시 자신의 다른 생성자 또는 조상의 생성자를 호출해야 한다. 
	// -> **그렇지 않다면 컴파일러는 생성자의 첫 줄에 super();를 자동적으로 추가**한다.
	// cf) this(): 여러생성자 중, 생성자내부에서 타생성자 부를 때 클래스명() 대신 this()로 호출해야함. 같은class내(여러개 생성자 존재가능) 타생성자

	
	// 6. 오버라이딩: 상속받은 메서드의 내용을 변경하는 것 -> 상속받은 메서드를 그대로 사용하기도 하지만, 자손 클래스 자신에 맞게 변경해야하는 경우가 많다. 이럴 때 조상의 메서드를 오버라이딩
	// 6-1. 오버라이딩 조건: 오버라이딩은 메서드의 내용만을 새로 작성하는 것이므로 메서드의 [[[[ 선언부는 조상의 것과 완전히 일치 ]]]]
	// 	자손 클래스에서 오버라이딩하는 메서드는 조상 클래스의 메서드와
		//이름이 같아야 한다.
		//매개변수가 같아야 한다.
		//반환타입이 같아야 한다.
	//  단 접근 제어자(access modifier)와 예외(exception)는 제한된 조건 하에서만 다르게 변경할 수 있다.
	// -> 오버라이딩은 선언부가 서로 일치해야 한다. 다만 [[ 접근 제어자와 예외 ]]
		//1. 접근 제어자는 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다. ->  [자식메소드의 접근제어자는 크거나 같게]
		// - 만일 조상 클래스에 정의된 메서드의 접근 제어자가 protected라면, 이를 오버라이딩하는 자손 클래스의 메서드는 접근 제어자가 protected나 public이어야 한다. [대부분의 경우 같은 범위의 접근 제어자]를 사용한다.
		//2. 조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다. -> [예외수는 작거나 같게]
		// - 아래의 코드는 자손 클래스의 메서드에 선언된 예외의 개수가 조상 클래스의 메소드에 선언된 예외의 개수보다 적으므로 바르게 오버라이딩 되었다.
//    class Parent {
//        void parentMethod() throws IOException, SQLException {
//            ...
//        }
//    }
//
//    class Child extends Parent {
//        void parentMethod() throws IOException {
	
//	 class Child extends Parent {
//	        void parentMethod() throws Exception {
//	            ...
	//-> 위와 같이 오버라이딩을 하면 조상클래스에 정의된 메서드보다 적은 개수의 예외를 선언한 것처럼 보이지만 Exception은 모든 예외의 최고 조상이므로 가장 많은 개수의 예외를 던질 수 있도록 선언한 것이다. 따라서 잘못된 오버라이딩이 된다.
	
	//3. 인스턴스 메소드를 static메소드로 또는 그 반대로 변경할 수 없다.
	
	// 조상 클래스의 메서드를 자손 클래스에서 오버라이딩할 때
	//1) 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
	//2) 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.
	//3) 인스턴스메서드를 static메서드로 또는 그 반대로 변경할 수 없다. ->  static에서 static은 가능하다.
	
	
	//7. 오버로딩
	//오버로딩(overloading) 기존에 없는 새로운 메서드를 정의하는 것(new)
	//오버라이딩(overriding) 상속받은 메서드의 내용을 변경하는 것(change, modify)
	//->** 파라미터를 추가해서 정의한다면? 선언부가 달라지는 것이니 == 새로운함수다 == 오버로딩이다!!**
	
//    class Parent {
//        void parentMethod() { }
//    }
//
//    class Child extends Parent {
//        void parentMethod() { }         // 오버라이딩
//        void parentMethod(int i) { }    // 오버로딩
//
//        void childMethod() { }
//        void childMethod(int i) { }     // 오버로딩
//    }
	
	//8. 다이나믹 메서드 디스패치 (Dynamic Method Dispatch)
	//8-1. 다형성(polymorphism): 다형성이란 여러가지 형태를 가질 수 있는 능력을 의미하며, 
	//  ->   구체적으로 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조할 수 있도록 한 것
	//   my) 부모 참조변수에다가 = new 자식인스턴스들 을 넣을 수 있다. -> 이점은?
	//  ->  자식 인스턴스 이지만 참조변수의 타입에 따라(부모가 참조변수면) 사용할 수 있는	멤버의 개수가 (작아진다)달라진다.
	//8-2. **부모(멤버 소)도 자식(멤버 다) 참조변수에 넣을 순 있으나 (형변환) 명시해줘야한다. -> 다운캐스팅 -> 멤버가 많은 아랫자식으로 캐스팅**
	// -> 실제 형변환은 안일어난다?
	
//    class Parent {
//        String strP;
//        int intP;
//
//        void methodP() { }
//    }
//
//    class Child extends Parent {
//        String strC;
//
//        void methodC() { }        
//    }
	
//    Parent p = new Parent();
//    Child c = new Child();
	// 지금까지: 생성된 인스턴스를 다루기 위해서는 인스턴스의 타입과 일치하는 타입의 참조변수만을 사용했다. 
	// -> 이처럼 인스턴스의 타입과 참조변수의 타입이 일치하는 것이 보통이지만, 서로 상속관계에 있을 경우 
	//    다음과 같이 조상클래스 타입의 참조변수로 자손클래스의 인스턴스를 참조하도록 하는 것도 가능하다.
	
//    Parent p = new Child();
	
	//  그렇다면 인스턴스를 같은 타입의 참조변수로 참조하는 것과 조상타입의 참조변수로 참조하는 것은 어떤 차이가 있을까?
//    Parent p = new Child(); // 자식을 부모 참조변수에  -----> 자식 변수 중 부모랑 일치하는 변수(메소드)만 챙기게 된다.
//    Child c = new Child(); // 자식을 자식 자신의  참조변수에 -> 자식 변수 다 챙김.
	// -> **둘 다 같은 타입의 인스턴스지만 참조변수의 타입에 따라 [사용할 수 있는 멤버의 개수가 달라지는 것]이다.**
	
	
//	**변수중복 -> 참조변수의 타입에 따라(다형성으로 부모참조변수에  들어갈 수 있으니) 사용 / 메소드 중복 -> new 인스턴스 것을 사용**
//	조상 클래스와 자손 클래스에 중복으로 정의된 멤버변수인 경우 참조변수의 타입에 맞는 멤버변수가 사용된다.
//	메소드의 경우는 항상 실제 인스턴스의 메소드가 호출된다.
	
//	class Parent {
//	    int x = 100;
//  class Child extends Parent {
//      int x = 200;
	
//    Parent p = new Child();
//    Child c = new Child();
//    System.out.println("p.x="+p.x); // p.x = 100 -> 변수는 인스턴스보다는 참조변수의 타입에 따라 그것을 먼저 사용
//    p.method(); // Child Method -> 메소드는 new 인스턴스의 것을 사용.
//    System.out.println("c.x="+c.x);
//    c.method();
	
	//매개변수의 다형성
	//  public static String valueOf(Object obj) {
	// -> Object 클래스는 모든 클래스의 조상이므로 이 메소드의 매개변수로 어떤 타입의 인스턴스도 가능하다.
	
	
	
	//8-2. 메소드 디스패치: 어떤 메소드를 호출할지 결정하여 실행시키는 과정을 말한다. 이 과정은 static(정적)과 dynamic(동적)이 있다.
	//1) Static Dispatch: 컴파일 시점에서, 컴파일러가 특정 메소드를 호출할 것이라고 명확하게 알고있는 경우
	
	//2) Dynamic Dispatch: 정적 디스패치와 반대로 컴파일러가 어떤 메소드를 호출하는지 모르는 경우이다. 동적 디스패치는 호출할 메서드를 런타임 시점에서 결정한다.
//	public class DynamicDispatch {
//	    static abstract class Service {
//	        abstract void run();
//	    }
//	    static class MyService1 extends Service {
//	        @Override
//	        void run() {
//	            System.out.println("run1");
//	        }
//	    }
//	    static class MyService2 extends Service {
//	        @Override
//	        void run() {
//	            System.out.println("run2");
//	        }
//	    }
//	    public static void main(String[] args) {
//	        List<Service> svc = Arrays.asList(new MyService1(), new MyService2());
//	        svc.forEach(Service::run);
//	    }
//	}
	// -> Service 타입을 받는 리스트에 MyService1 클래스와 MyService2 클래스를 넣었다. 그리고 forEach를 돌면서 run 메소드를 호출하고 있다.
//	이 때, 컴파일러는 run()이 호출 될때 Service의 run()과 MyService1의 run()과 MyService2의 run() 중 어느 메소드를 호출할 지 아직 모른다.
	// -> 이는 런타임 시점에 객체의 receiver parameter (this)를 통해 각 객체의 this.run()을 호출하게 된다. 
	// 즉, 컴파일 시점에 컴파일러가 어떤 메소드를 호출해야할 지 모르며 런타임 시점에 알 수 있는 것을 동적 메소드 디스패치(Dynamic Method Dispatch) 라고 한다.
	
	
	//9. 추상클래스: 미완성 설계도라고 할 수 있다. 클래스가 미완성이라는 뜻은 멤버의 개수에 관계된 것이 아니라, 단지 미완성메서드(추상메서드)를 포함
	// -> 미완성 설계도 -> 인스턴스 생성 불가.
	//-> 추상클래스: 클래스내 추상메서드가 존재 ->초상메소드 : 구현부 미작성 선언부만 
	// - 추상클래스로 인스턴스는 생성할 수 없다. 추상클래스는 상속을 통해서 자손클래스에 의해서만 완성
	// - 자체로는 클래스로서의 역할을 못하지만, 새로운 클래스를 작성하는데 바탕이 되는 조상클래스로서 중요한 의미
	// - 추상클래스는 추상메서드를 포함하고 있다는 것을 제외하고 일반 클래스와 동일하므로, [생성자]가 있고, [멤버변수]와 [메서드]도 가질 수 있다.
	
	// **공통부분을 조상 단순class로 작성할 수도 있지만, 추상클래스에서는 추상메서드의 구현부를 비워두고 ->
	//    자식class에서 [반드시 @overriding후 구현해줘야하는 강제성] 때문에 추상클래스로 조상을뽑는다.**
	
	// 실습->
	
	//10.final
	// 1) 변수앞에서 상수 -> 주로 static final로  객체없이 뽑아쓰는 상수가 된다.(static없으면 객체 생성해서 상수를 뽑아쓴다?)
	// 2) final 메서드 -> 오버라이딩(내가 위에있떤 함수 변경 or 자식이 부모꺼 변경)금지
	// 3) final class -> 상속 금지 class
//	  final class FinalTest {             // 조상이 될 수 없는 클래스
//	        final int MAX_SIZE = 10;        // 값을 변경할 수 없는 멤버변수(상수)
//
//	        final void getMaxSize() {       // 오버라이딩할 수 없는 메서드(변경불가)
//	            final int LV = MAX_SIZE;    // 값을 변경할 수 없는 지역변수(상수)
//	            return MAX_SIZE;
//	        }
//	    }
	
	// 10-1. 생성자를 이용한 final 상수 좀있다 초기화
	// ->    final이 붙은 변수는 상수이므로 일반적으로 선언과 동시에 초기화를 동시에 하지만, 인스턴스변수의 경우 생성자에서 초기화 되도록 할 수 있다
	// -> **상수를 생성자 매개변수에 넘겨받은 값으로 정해줄 때는,  변수 생성후 생성자에서 초기화하면서 할당해줘도 된단.**
	// --> **인스턴스마다 다른 상수를 가질수있게 하기 위함이다.**
//	   class Card {
//	        final int NUMBER;                // 상수지만 선언과 함께 초기화 하지 않고
//	        final String KIND;               // 생성자에서 단 한번만 초기화할 수 있다.
//	        static int width = 100;
//	        static int height = 250;
//
//	        // 매개 변수로 넘겨받은 값으로 상수들을 이 때 초기화한다.
//	        Card(String kind, int num) {
//	            KIND = kind;
//	            NUMBER = num;
//	        }

	//11. Object: 클래스를 정의하면 코드를 컴파일 할 때 컴파일러에서 자동적으로 extends Object를 추가하여 상속받도록 한다.
	// ->    자바의 모든 클래스들은 Object 클래스의 멤버들을 상속받기 때문에 Object 클래스에 정의된 멤버(변수나 메소드, but Object는 멤버변수는 없고 메서드만 11개)들을 사용할 수 있다.
	// ->    toString(), equals()와 같은 메서드를 따로 정의하지 않고 사용할 수 있었던 이유는 이 메서드들이 Object클래스에 정의된 것들이기 때문
	
	//11-1. equals: default로는 값만 비교한다.
	// -> **객체의 특정 필드(id)가 같은지**로 오버라이딩 하려면 
	// ---> 1) 같은 인스턴스인지 if instance of  -> 2) return this.특정필드 == ((형변환)o.)특정필드;  아니면 return
//	@Override
//    public boolean equals(Object o) {
//        if(o instanceof Person)
//            return id == ((Person)o).id;
//        else
//            return false;
//    }
	
	//11-2. hashCode: 인스턴스의 같고 다름을 판단하려면 equals 메소드 뿐만 아니라 hashCode메소드도 적절히 오버라이딩 해야한다.
	// - hashCode():  default String은 Stirng 클래스 문자열의 내용이 같으면, 동일한 해시코드를 반환하도록 hashCode 메소드가 오버라이딩 되어 있기 때문에, str1, str2가 동일한 값을 얻는다.
	// - System.identityHashCode() : 의 경우 Object처럼 객체의 주소값으로 해시코드를 생성하기 때문에	모든 객체에 대해 항상 다른 해시코드 값을 반환할 것을 보장한다.
	
	//11-3. toString(): 그냥 출력시 Class@16진수해쉬코드로 나오는 객체들을 [인스턴스변수를 이용하여 문자열 정보로 return]학 ㅣ위해 정의하는 메소드
//	class Tv {
//		  String manufacturer;
//		  ...
//		  public String toString() {
//		    return "제조사:" + manufacturer;
//		  }
//		}
	
	//12. getClass(): 객체로 해당class가 아닌, 해당class정보가 담긴 [Class객체]를 만드는 방법..
	// - Class객체를 얻는 3가지 방법
//	Class cObj = new Card().getClass(); // 생성된 객체로 읻기
//	Class cObj = Card.class;            // 클래스 리터럴(*.class)로 얻기
//	Class cObj = Class.forName("Card)   //  클래스 이름으로 얻기
	// Class 객체를 이용하면 클래스에 정의된 멤버의 이름이나 개수 등, 클래스에 대한 모든 정보를 얻을 수 있기 때문에 Class 객체를 통해서 객체를 생성하고 메서드를 호출하는 등 동적인 코드를 작성
	
	
	




	


	
	
	
	
}

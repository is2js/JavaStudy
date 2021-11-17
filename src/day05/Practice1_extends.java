package day05;

public class Practice1_extends {

}

class Point {
	int x = 10;
	int y = 20;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
				
	}
}

class Point3D  extends Point {
	int z = 30;
	
	//3. 기본 생성자를 타생성자 호출하게 하여 -> new Point3D(); 처럼 값없이 객체 생성해도, default로 무조건 값이 들어가게 한다.
	Point3D() {
		this(100, 200, 300);
	}
	
	// 1. 매개변수를 받는 생성자부터 정의함.
	Point3D(int x, int y, int z) {
		//2. 상속한 놈이면 반드시 부모에서 받는 변수들을 먼저 초기화(정의안하면 자동으로 컴파일러가 추가한다고 하긴함)
		super(x, y); // 부모 생성자 호출하여 부모에게 받을 변수 초기화됨
		this.z = z; // 부모에서 받은 것은 부모에서 초기화하고 끝낸다. 나는 나한테 정의된 것만 초기화해주면 된다.
		
	}
}



// 추상클래스 실습.
// 추상클래스 Player를 상속받아 CDPlayer에서 추상메소드 2개를 구현한다.
// 사실 Player 클래스의 play와 stop을 추상메소드로 하는 대신, 아무 내용 없는 메서드로 작성할 수도 있다.
// 굳이 abstract를 붙여서 추상메소드로 선언하는 이유는? -> **자손클래스에서 추상메소드를 반드시 구현하도록 강요하기 위해서다.**
// my) public class는 .java 1:1매칭이라서.. 여기서는 public떼고 걍 abstract class로 만듬.
abstract class Player {
	// ** 추상클래스라도, 생성자용, 일반메소드용 등 멤버변수를 선언할 수 있다. 일반class처럼 메소드를 작성해도되니까 그때도 필요하다. 
	boolean pause;
	int currentPos;
	
	//자식들이 반드시 가져야할 메서드들에 강제성을 부여하기 위해 공통 메서드들을 추상메서드로 작성해둔다.
	// 추상클래스도 멤버변수, 생성자를 가지며, 생성자에서 멤버변수들을 초기화 할 수 있다.
	Player() {
		pause = false;
		currentPos = 0;
	}
	
	//**자식이 반드시 가져야할 메서드를 추상메서드로 선언부만 작성해둔다.**
	abstract void play(int pos);
	
	abstract void stop();
	
	// 자식이 반드시 가져야할 게 아니라면, 일반 class처럼 일반 메소드 정의해주면 -> 상속시 알아서 받아갈 수 있다.
	void play() {
		this.play(currentPos); // 만약 현재치를 안알려주면, currentPos에 저장된 위치로 실행 ->
		// ****이게 여러개 생성자? 추상클래스를 통해 여러개 정의한 메소드를 통한.. if문 제거인가?!!! ******
		// ****파라미터가 없다 있다에 따라 여러개의 메소드를 정의 + 각 메소드를 타메소드 내부에서 활용해서 -> if문을없앤다.****
	}
	
	void pause() {
		// flag가 true로 정지상태면, 재생+flag처리
		if(pause) {
			pause = false;
			play(currentPos);
		} else {
			pause = true;
			stop(); // 일시정지는 flag + (play or stop)의 2단계 처리가 필요하군.
		}
	}
}


class CDPlayer extends Player {
	//1. The type CDPlayer must implement the inherited abstract method Player.stop()
	//2. 클릭하면 2개 추상클래스속 추상메서드가 강제 @override됨. 
	
	//3. 해당클래스의 인스턴스 변수 
	int currentTrack; // 요건 왜 private안할까..?  일단, 인스턴스변수가 default라서.. 객체.변수로 뽑고 접근까지 가능하다 생각하자.
	
	//4. 해당클래스의 인스턴스 메소드
	void nextTrack() {
		this.currentTrack++;
	}
	
	void preTrack() {
		// 뺄때는 1이상인지 확인하기~!(음수는 거의 없다.  in  index)
		if (currentTrack > 1) {
			this.currentTrack--;
		}
	}
	
	
	
	@Override
	void play(int pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		
	}
	
}

class Main {
	public static void main(String[] args) {
		
		Point3D p3 = new Point3D();
		Point3D p4 = new Point3D(10, 20, 30);
		System.out.println(p3.x);
		System.out.println(p3.y);
		System.out.println(p3.z);
		System.out.printf("%d %d %d", p4.x, p4.y, p4.z);
		


	}
}

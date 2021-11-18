package day06;

public class Practice_interface {

	
}

//1. 인터페이스는 public final static 변수 아니면 public abstract 메서드만 가진다. 없다면 생략된 것이다!!!
// -> **인터페이스는 공통 카테고리 + 공통 기능을 기본 설계도로 작성한 것이다.**
interface Champion {
	//2. abstract가 생략된 인터페이스 추상메소드 -> 
	void ChampName(String champName);
}

class LaneCheck {
	//3. 유틸클래스.static메서드()가   인터페이스 객체를 반환? -> 인터페이스(카테고리, 챔피언)를 구현한 하위요소들(바텀, 미드, 정글챔피언)이 내부에서 생성되어 반환된다는 뜻이다.
	// -> 인자로 lane이 들어가서 그에 맞는 하위챔피언들을 반환해주는 유틸메소드일것이라고 생각하면 된다.
	public static Champion getLane(String lane) {
		if (lane.equals("Bottom")) {
			return new Marksman();
		}
		if (lane.equals("Mid")){
			return new Nuker();
		}
		return new Jungle();
		
	}
}

//4. 카테고리 챔피언을 구현한 하위챔피언요소들은 interface를 구현하면 된다.
// -> *공통기능인 ChampName은 **각 구현한 하위요소들은 각자 개성에 맞게 구현하면 된다.*
class Marksman implements Champion {
	// 5. 인터페이스 추상메소드는 public + abstract가 없으면 생략이라고 생각하자.
	public void ChampName(String champName) {
		//6. 구현부는 I)구현 하위요소들마다 개성에 맞게 구현해주면 된다.
		System.out.println(champName + "은 바텀입니다.");
	}
}

class Nuker implements Champion {
    public void ChampName(String champName) {
        System.out.println(champName + "은 미드 선");
    }
}

class Jungle implements Champion {
    public void ChampName(String champName) {
        System.out.println(champName + "은 정글감");
    }
}

class Main {
	public static void main(String[] args) {
		
		//7. **유틸메소드()만 호출하면, 거기서부터 I)챔피언 구현 C)하위챔피언들이 생겨나며, 반환은 I)참조변수로 반환된다.**
		//**I)구현 하위 클래스객체를 다형성에 의해 인터페이스 참조변수(카테고리, 챔피언의 이름으로) 받는 센스...
		Champion champion = LaneCheck.getLane("Bottom");
		champion.ChampName("미스포춘");
		
		
	}
}

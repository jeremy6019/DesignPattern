package define;

public class DesignPattern {
/*
  
 ** 디자인 패턴(Design Pattern)
=>유사한 목적으로 사용되는 클래스의 템플릿을 패턴으로 정리한 것이 디자인 패턴 
객체 지향 언어에서만 존재 

 =>디자인 패턴은 여러가지 형태로 존재하는데 가장 유명한 것이 GoF의 디자인 패턴 
 입니다. 
 
=>디자인 패턴읭 분류 
객체의 생성에 관련된 패턴 
프로그램의 구조에 관련된 패턴 
객체의 행동에 관련된  패턴 

=>디자인 패턴을 사용했을 때 장점 
재사용성이 높아집니다. 
유연성이 있는 설계가 가능 
의사소통이 쉬워집니다. 디자인 패턴을 알고 있는 개발자와 대화할 때 패턴만 보면 
목적이나 행동을 예측할 수 있습니다. 

프레임워크가 디자인 패턴을 적용해서 객체를 생성해주는 경우가 많은데 이렇게 
하면 개발자는 알고리즘에만 집중할 수 있습니다. 

이전에는 프로그램을 잘 개발하려면 디자인 패턴도 알아야 하고 자료구조를 만들수도 
있어야 했지만 요즈음 나오는 언어나 프레임워크는 이러한 부담을 줄여줍니다. 

1.Singleton Pattern 
=> 클래스의 객체를 하나만 생성하도록 하는 디자인 패턴 
=>서버에서 작업을 수행하는 클래스나 Controller클래스 또는 시작점 클래스를 
만들때 사용하는 디자인 패턴 
환경설정에 관련된 클래스도 싱글톤 패턴으로 디자인 

=>싱글톤 패턴의 클래스 디자인 
1)생성자를 private으로 설정해서 외부에서 객체생성을 직접 할 수 없도록 합니다. 

2) private static으로자신의 타입변수를 생성 -static은 1개만 생성 

3)public static으로 자신의 타입을 리턴하는 메소드를 생성하고 2번에서 만든 
변수가 null일때만 생성자를 호출해서 변수에 대입 
2번에서 만든 변수를 리턴 

=>2개의 객체가 동일한 객체인지 다른 객체인지 확인하는 것은  해시코드를 비교해보면
압니다.
해시코드는 데이터의 위치를 구분(중복 안됨)하기 위해서 만들어 주는 코드값 

package java1022designpattern;

public class Singleton {
	//생성자를 private으로 만들어서 
	//외부에서 객체를 생성할 수 없도록 합니다. 
	private Singleton() {}
	
	//객체의 참조를 저장할 변수를 생성 
	private static Singleton singleTon;
	
	//객체를 생성해서참조를 넘겨주는 메소드 
	//객체를 사용하고자 할 때는 이 메소드만 이용 
	public static Singleton shareInstance() {
		if(singleTon == null) {
			singleTon = new Singleton();
		}
		return singleTon;
	}

}


  package java1022designpattern;

public class DesignMain {

	public static void main(String[] args) {
		
		Singleton s1 = 
				Singleton.shareInstance();
		Singleton s2 = 
				Singleton.shareInstance();

		System.out.printf("s1:%d\n", s1.hashCode());
		System.out.printf("s2:%d\n", s2.hashCode());
		
		
		
	}

}
  
  
 에러가 날때 undefined error라면 없는 것입니다. 
 is not visible이면 있는데 접근할 수 없다.
 
 어떤 클래스의 객체를 생성자를 이용하지 않고 자신의 static메소드를 이용해서 
 생성하는 경우는 2가지인데 하나는 싱글톤 패턴이고 다른 하나는 추상클래스나 
 인터페이스의 경우인데 이 때는 Anonymous객체를 만들어서 리턴해줍니다. 
 

2.factory Method Pattern 
=>객체 생성에 관련된 패턴 
=>자신의 객체를 자신의 생성자를 이용하지 않고 다른 클래스의 메소드를 이용해
생성해서 리턴하는 패턴 
=>객체를 만들기 위해서 동일한 작업을 반복적으로 수행해야 하는 경우 굳이 생성자
에 코드를 만들어서 복잡하게 보이지 않기 위해서 다른 클래스에서 그 작업을 수행해 
서 객체를 만들어서 리턴하는 방식  
=>이 경우에는 클래스 이름에 한가지 원칙이 있는데 객체를 대신 생성해주는 클래스의 
이름은 Factory나 Builder로 끝납니다.  

ex)DocumentBuilderFactory클래스: DocumentBuilder객체를 생성해주는 클래스  

1)생성자를 default로 설정 
=>private으로 설정하면 다른 클래스에서 생성을 못합니다. 

2)패키지내에 Factory클래스를 만들어서 객체를 생성해서 리턴하는 메소드를 생성 
메소드 이름은 대부분 create, build등의 이름을 사용합니다. 

팩토리 메소드 패턴이 적용되는 클래스 
 
package Dao;

public class Dao {

	Dao() {}
	
}

package Dao;

public class DaoFactory {
   //Dao클래스의 객체를 생성해서 리턴 
	public static Dao create() {
		return new Dao();
	}
	
}


3.Proxy Pattern 
=>개발자가 클래스를 만들면 프레임워크가 이 클래스를 기반으로 해서 하위클래스를 
생성해서 코드를 덧붙여서 사용하는 패턴 

4.decorator Pattern 
=>객체를 생성할 때 자신의 생성자를 호출하기는 하지만 다른 클래스의 객체를 매개변수
로 받아서 생성하는 패턴 
=>대입되는 객체에 따라 유사하지만 다른 작업을 수행할 수 있도록 하고자 할 떄 사용
하는 패턴

 BufferedReader클래스는 스트림으로 문자단위로 읽어오는 스트림입니다. 
 객체를 생성할 때 
 new BufferedReader(new InputStreamReader(System.in)):키보드로부터 읽어오는
 객체가 됩니다. 
 
 new BufferedReader(new InputStreamReader(new FileInputStream("파일경로")))
 :파일로부터 읽어오는 객체 
  
 new BufferedReader(new InputStreamReader(socket.getInputStream())):소켓으로 
 부터 문자 단위로 읽어오는 객체 
 
 new BufferedReader(new 
 InputStreamReader(HttpURLConnection.getInputStream())):웹사이트에서 문자 
 단위로 읽어오는 객체 
 
5.템플릿 메소드 패턴
=>구조와 관련된 패턴 
=>사용해야할 메소드를 인터페이스에 선언하고 그 내용은 인터페이스를 구현한 클래스에 
작성하는 패턴 
=>애플리케이션을 만들 때 서비스(사용자의 요구가 반영된 영역)영역의 클래스를 만들 
때 이용 

고객의 요구사항이 삽입, 삭제, 갱신, 조회라면 
1)삽입, 삭제, 갱신, 조회 메소드를 소유한 인터페이스를 생성 
=>고객의 요구 당 하나의 메소드 입니다. 

package service;
//c언어나 objective-c에서는 .h파일의 역활 
public interface CustomerService {

	//삽입을 위한 메소드 
	public void insert(); 
	
	// 삭제를 위한 메소드 
	public void delete();
	
	//갱신을 위한 메소드 
	public void update(); 
	
	//조회를 위한 메소드 
	public void select(); 
		
}
2)실제 내용을 소유한 클래스   
  package service;
// c언어에서는 c 
// c++에서는 cpp 
// objective-c에서는 m
public class CustomerServiceImpl implements CustomerService {

	@Override
	public void insert() {
		System.out.printf("데이터 삽입\n");
	}

	@Override
	public void delete() {
		System.out.printf("데이터 삭제\n");
	}

	@Override
	public void update() {
		System.out.printf("데이터 수정\n");
	}

	@Override
	public void select() {
		System.out.printf("데이터 조회\n");
	}

	
}
3)main메소드에서 패턴이 적용된 코드 사용 
	//템플릿 메소드 패턴이 적용된 경우의 객체 생성 
		//변수는 인터페이스 타입으로 만듭니다. 
		CustomerService service =
				new CustomerServiceImpl();
		service.delete();

=>SI업체에 제출하는 포트폴리오는 필수 
공공기관 프로젝트에 사용하는 전자정부 프레임워크나 대기업에서 사용하는 
프레임워크에서 만들어주는 샘플프로젝트에는 적용이 되어 있습니다. 

6.Adapter Pattern 
=>상위 클래스에 만들어진 메소드를 인터페이스에 만들어진 메소드를 통해서 
호출하는 패턴 
=>이전에 만들어진 메소드의 이름을 변경하고자 할 때 이용하며 보통 이전에 만들어진 
메소드에는 deprecated표시를 합니다. 

1)예전 클래스 생성 
package adapter;

public class OldSystem {

	public void oldMethod() {
		System.out.printf("메소드\n");
	}
}

 2)이름을 변경하고자 할 때는 인터페이스를 만들어서 새로운 이름의 메소드를 생성 
 package adapter;

public interface Target {

	//변경 하고자 하는 메소드 이름 
	public void newMethod();
}

3)OldSysem을 상속받고 Target을 구현한 새로운 클래스를 생성 
package adapter;

public class NewSystem extends OldSystem implements Target {

	@Override
	public void newMethod() {
		oldMethod();
	}

}

4)main메소드에서 사용 	
new OldSystem().oldMethod();
new NewSystem().newMethod();


7.Delegate Pattern 
=>작업수행을 다른 객체에게 위임하는 방식  
=>인터페이스나 추상클래스에 추상 메소드를 만들고 일반 클래스에 상속하거나 
구현해서 사용하는 방식 
=>템플릿메소드패턴의 경우는 구현된 클래스에 오버라이딩된 메소드 말고는 다른 
메소드가 존재하지 않는데 Delegate Pattern에는 다른 메소드가 존재할 수 있어서 
인터페이스를 implements하면 작업을 수행하기 위한 메소드가 있다는 것을 보장할 
수 있습니다. 
=>AWT, Swing, Android의 View, iOS의 View 이벤트 처리에 많이 사용합니다. 
1)Button의 이벤트 처리를 위한 Listener인터페이스를 만들고 메소드 선언 
package delegate;

public interface OnClickListener {
    public void onClick();
}


2)Button(View)클래스를 생성 
package delegate;

public class Button {
	private OnClickListener onClickListener;
	
	public void setOnClickListener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}

	public Button() {
		System.out.printf("버튼을 출력\n");
	}
	
	public void onClick() {
		if(onClickListener == null) {
			return;
		}
		onClickListener.onClick();
	}
}

3)main메소드 작성 
 Button btn = new Button();
 
 btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick() {
				System.out.printf("버큰 클릭\n");			
			}        	
        });
        
btn.onClick();  

  
  
  
  
  
  
  
  
  
  
 
 */
}

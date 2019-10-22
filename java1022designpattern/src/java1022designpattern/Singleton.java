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

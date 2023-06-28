package week06;

import common.ObjNotFoundException;

public class PointcutObj {
//Ex1, Ex2
	public String businessLogic() {
		System.out.println("핵심 로직을 구현한 businessLogic() 실행");
		return "businessLogic 메서드에서 문자열 반환";
	}
	
	//Ex 3,4,5
	public void throwNeedLogic(String objName)throws ObjNotFoundException{
		System.out.println("예외가 발생할 가능성이 있는 핵심 로직을 구현한 throwNeedLogic() 실행");
		throw new ObjNotFoundException("객체가 존재하지 않을 경우 예외 발생");
	}
}

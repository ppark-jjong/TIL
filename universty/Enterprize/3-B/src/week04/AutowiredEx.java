package week04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import common.SmsSender;
import common.WorkUnit;

public class AutowiredEx {
	@Autowired
	private WorkUnit workUnit;
	private SmsSender smsSend;

	public AutowiredEx() {
	}

	@Autowired
	public AutowiredEx(WorkUnit workUnit) {
		super();
		this.workUnit = workUnit;
		System.out.println("AutowiredEx() : workUnit.num = " + workUnit.getNum());
	}

	@Autowired
	public void generalMethod(WorkUnit[] workUnit) {
		System.out.println("generalMethod() : 배열 길이" + workUnit.length);
		for (int i = 0; i < workUnit.length; i++) {
			System.out.println("workUnit[" + i + "] = " + workUnit[i].getNum());
		}
	}

	@Autowired(required = false)
	//		<qualifier value = "main"/> 라는 xml파일에서의 식별자로 식별한다
	@Qualifier("main") //별칭을 가진 xml 값을 골라 주입 시켜준다
	public void setSmsSend(SmsSender smsSend) {
		this.smsSend = smsSend;
	}

	public void objInfo() {
		System.out.println("smsSender : " + smsSend);
		System.out.println("workUnit : " + workUnit);
	}

}

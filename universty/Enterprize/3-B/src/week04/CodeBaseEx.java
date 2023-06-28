package week04;

import common.SmsSender;
import common.WorkUnit;

public class CodeBaseEx {

	private SmsSender smsSend;
	private SmsSender send;
	private WorkUnit workUnit;

	public void setSmsSend(SmsSender smsSend) {
		this.smsSend = smsSend;
		System.out.println("-=smsSend : " + this.smsSend);
	}

	public void setSend(SmsSender send) {
		this.send = send;
		System.out.println("--send : " + this.send);
	}

	public WorkUnit getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(WorkUnit workUnit) {
		this.workUnit = workUnit;
		System.out.println("===setWorkUnit : " + workUnit);
	}

	public void info() {
		System.out.println("smsSend : " + smsSend);
		System.out.println("send : " + send);
		System.out.println("this : " + this);
	}
}

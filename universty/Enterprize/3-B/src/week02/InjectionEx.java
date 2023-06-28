package week02;

import common.SmsSender;

public class InjectionEx {
	private SmsSender smsSend;
	private String value;

	public InjectionEx(SmsSender smsSend, String value) {
		this.smsSend = smsSend;
		this.value = value;
	}

	public void setSmsSend(SmsSender smsSend) {
		this.smsSend = smsSend;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void write() {
		System.out.println("저장 프로퍼티 : " + smsSend + ", " + value);
	}

}

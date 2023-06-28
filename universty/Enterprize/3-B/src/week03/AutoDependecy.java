package week03;

import common.SmsSender;

public class AutoDependecy {
	private SmsSender smsaSend;
	private CollectionEx collectionEx;

	public void setSmsaSend(SmsSender smsSend) {
		this.smsaSend = smsSend;
		System.out.println("setSmsSend() 실행 : " + smsSend);
	}

	public AutoDependecy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCollectionEx(CollectionEx collectionEx) {
		this.collectionEx = collectionEx;
		System.out.println("collectionEx() 실행 : " + collectionEx);
	}
	
//Ex 9
	public AutoDependecy(SmsSender smsSend, CollectionEx collectionEx) {
		super();
		this.smsaSend = smsSend;
		this.collectionEx = collectionEx;
		System.out.println("SmsSender 객체 : " + smsSend);
		System.out.println("collectionEx 객체 : " + collectionEx);
	}

}

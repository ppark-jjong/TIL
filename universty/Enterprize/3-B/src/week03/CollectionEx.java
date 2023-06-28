package week03;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import common.SmsSender;

public class CollectionEx {
	private List<SmsSender> objList; // Ex 4
	private List<Double> deviations; // Ex 5
	private Map<String, SmsSender> hand; // Ex 6
	private Properties config; // Ex7

	public CollectionEx() {
		super();
		// TODO Auto-generated constructor stub
	}

//	 Ex4 : List의 객체 타입을 생성자로 주입
	public CollectionEx(List objList) {
		System.out.println("생성자로 List 주입" + objList);
		this.objList = objList;
		for (int i = 0; i < this.objList.size(); i++)
			System.out.println("[" + i + "] 객체 : " + this.objList.get(i));
	}

//Ex 5
	public void setDeviations(List<Double> deviations) {
		this.deviations = deviations;
		for (int i = 0; i < deviations.size(); i++)
			System.out.println("[" + i + "] 번 : " + this.deviations.get(i));
	}

//Ex 6
	public void setHand(Map<String, SmsSender> hand) {
		this.hand = hand;
		SmsSender smsSend;
		String keyStr;
		Set key = this.hand.keySet();
		Iterator<String> it = key.iterator();
		while (it.hasNext()) {
			keyStr = it.next();
			smsSend = (SmsSender) hand.get(keyStr);
			System.out.println(keyStr + " : " + smsSend);
		}
	}

//Ex 7
	public void setConfig(Properties config) {
		this.config = config;
	}

	public <E> void propertiesWrite(String[] key) {
		for (String s : key)
			System.out.println(s + ":" + config.getProperty(s));
	}
}

package documents;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//Documents Class
public class Documents {

	private String name, content;
	private Date now = new Date();//now�� Date��ü�ȿ� �ִ� ���� �ð��� ����
	SimpleDateFormat dayf = new SimpleDateFormat("yyyyMMdd");
	private String day = dayf.format(now).toString();
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public String getDay() {
		return day;
	}

	public Documents(String name, String day, String content) {
		this.name = name;
		this.day = day;
		this.content = content;
	}
	public Documents(String name, String content) {
		this.name = name;	
		this.content = content;
	}
	 @Override
     public boolean equals(Object obj) {
         if (obj instanceof String) {
             return obj.toString().equals(name);
         }
         return false;
    }
	
}

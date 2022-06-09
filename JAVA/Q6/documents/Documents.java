package documents;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//Documents Class
//문서의 이름, 날짜, 내용을 저장
//문서의 이름, 날짜, 내용은 생성자를 통해받는다.
//문서의 날짜를 입력받지 않는다면,현재의 날짜 입력
//이름,날짜,내용의 getter 생성
//내용의 setter 생성
public class Documents {

	private String name, content;
	private Date now = new Date();//now에 Date객체안에 있는 현재 시각이 있음
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

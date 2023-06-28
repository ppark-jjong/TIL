package homework;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class StdManager implements ApplicationContextAware, InitializingBean {
	private List<StdInfo> stdList = new ArrayList<>();
	private int numStudents;
	private StdInfo stdInfo;

	// StdInfo 주입
	public void setStdInfo(StdInfo stdInfo) {
		this.stdInfo = stdInfo;
	}

	// 외부 파일 주입
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.stdInfo = (StdInfo) applicationContext.getBean("stdInfo");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Properties prop = new Properties();
		//외부 파일의 값을 일치 시킨다
		FileInputStream file = new FileInputStream("XML/homework/num.properties");
		prop.load(file);
		this.numStudents = Integer.parseInt(prop.getProperty("numStudents"));
	}

	public int getNumStudents() {
		return this.numStudents;
	}

	// 학생 정보 입력
	public void addStudentInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 이름 : ");
		String name = sc.nextLine();
		System.out.print("학생 학번: ");
		int number = sc.nextInt();
		StdInfo std = new StdInfo(name, number);
		stdList.add(std);
	}

	//Destroy-Method 속성의 메소드 => 출력 메소드로 사용한다.
	public void outputStudentInfo() {
		System.out.println("현재 저장된 학생 리스트");
		for (StdInfo std : stdList) {
			System.out.println("이름 : " + std.getName() + ", 학번: " + std.getNumber());
		}
	}

}
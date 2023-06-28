package homeworkResolve;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class StdManager implements ApplicationContextAware, InitializingBean {
	private String stdCnt; // 입력 받을 학생 수
	private List<StdInfo> stdList = null;
	private ApplicationContext context = null; // 자바 빈을 주입 받을 컨테이너 객체 초기화

	public StdManager(List<StdInfo> stdList) {
		super();
		this.stdList = stdList;
	}

	public StdManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Required // 필수 프로퍼티라고 선언 즉 모든 메서드들이 실행 되기전에 무조건적으로 실행되어야 한다
	public void setStdCnt(String stdCnt) {
		this.stdCnt = stdCnt;
	}

	// Destroy 메서드로 실행할 출력 메서드
	public void printStdInfo() {
		Iterator it = stdList.iterator();
		StdInfo info;
		System.out.println("======================");
		while (it.hasNext()) {
			info = (StdInfo) it.next();
			System.out.println("학생 이름 출력 : " + info.getStdName());
			System.out.println("학생 학번 출력 : " + info.getStdNum());
		}
	}

	// main 클래스의 메서드가 실행 되기전에 실행되는 메서드 afterPropertiesSet()
	@Override
	public void afterPropertiesSet() throws Exception {
		// 컨테이너 객체인 Context 객체에서 입력 받은 자바 빈을 for 문을 이용해 입력 받은 학생 수 만큼 객체 생성을 한다.
		StdInfo info;
		int cnt = (int) Integer.parseInt(stdCnt);
		for (int i = 0; i < cnt; i++) {
			info = (StdInfo) context.getBean("stdInfo");
			this.stdList.add(info);
		}
	}

//자바 함수 내부에서 context Application을 사용하여야 할때 무조건 쓰인다
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// 해당 메서드로 입력 받은 자바빈 객체를 현재 클래스의 컨테이너 객체에 주입
		this.context = arg0;
	}

}

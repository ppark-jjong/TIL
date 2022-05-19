import java.util.Scanner;

abstract public class ScheduleSet implements IScheduleSet {
	private int count;
	public ScheduleSet(int count) {
		this.count = count;
	}
	@Override
	public Schedule[] makeSchedule() {//- Schedule 배열을 만들어 반환하는 makeSchedule 메서드 오버라이드
		Schedule[] sch = new Schedule[count];//Schedule 객체배열 생성 크기는 count
		
		for(int i =0; i<count; i++) {
			String [] s = getString();
			sch[i] = (s[2].isEmpty() == true)? new Schedule(s[0], s[1]):new Schedule(s[0], s[1], s[2]);
			/*if(s[2].isEmpty() == true) {
			 * sch[i] = new Schedule(s[0], s[1])
			}
			else {
				sch[i] = new Schedule(s[0], s[1], s[2]);
			}*/
			}
		return sch;
	}
	@Override
	public void searchSchedule(Schedule []sch, String day) {//-- Schedule배열과 날짜를 입력받아 찿은 스케줄을 출력 하는 sreachSchedule 메서드 오버라이드
		boolean nullIt = true;
		for(int i = 0; i<count; i++) {
			if(sch[i].getDay().equals(day)) {
				System.out.println(sch[i].getSchedule());
				nullIt = false;
			}
			if(nullIt==true) {
				System.out.println("일치하는 값이 없습니다.");
			}
		}
	}
	abstract public String[] getString();

}

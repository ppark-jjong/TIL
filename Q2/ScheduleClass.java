import java.util.Scanner;
public class ScheduleClass extends ScheduleSet{

	public ScheduleClass(int count) {
		super(count);
	}

	@Override
	public String[] getString() {
		Scanner ex = new Scanner(System.in);
		String[] sch = new String[3];
		for(int i = 0; i<3 ;i++) {
			switch(i) {
			case 0:
				System.out.print("스케줄 >>");
				sch[i] = ex.nextLine();
				break;
			case 1:
				System.out.print("장소 >>");
				sch[i] = ex.nextLine();
				break;
			case 2:
				System.out.print("시간 >>");
				sch[i] = ex.nextLine();
				break;
			}
		}
		return sch;
	}
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("스케줄을 정할 수를 정하세요 : ");
        ScheduleClass sdc = new ScheduleClass(scan.nextInt());
        
        System.out.println("---스케줄 설정---");
        Schedule[] schedule = sdc.makeSchedule();

        while(true){
            System.out.print("스케줄을 검색할 날짜를 입력하세요(종료 : q) : ");
            String day = scan.next();
            
            if(day.equals("q")){
                break;
            }
            
            sdc.searchSchedule(schedule, day);
        }
    }
	
}

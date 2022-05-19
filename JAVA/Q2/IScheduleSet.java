
public interface IScheduleSet {
	abstract Schedule[] makeSchedule();
	abstract void searchSchedule(Schedule[] sch, String day);
}

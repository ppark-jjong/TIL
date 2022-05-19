package Homework;

import java.util.Calendar;

public class Q2 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1 ;
		int date = c.get(Calendar.DATE);
		int day = c.get(Calendar.DAY_OF_WEEK); 
        System.out.println(year+ "년 " + month + "월 " + date + "일");

        switch (day) {
            case 1:
                System.out.print("일요일 ");
                break;
            case 2:
                System.out.print("월요일 ");
                break;
            case 3:
                System.out.print("화요일 ");
                break;
            case 4:
                System.out.print("수요일 ");
                break;
            case 5:
                System.out.print("목요일 ");
                break;
            case 6:
                System.out.print("금요일 ");
                break;
            case 7:
                System.out.print("토요일 ");
                break;
        }
        
        switch (c.get(Calendar.AM_PM)) {
            case 0:
                System.out.println("오전");
                break;
            case 1:
                System.out.println("오후");
        }

        System.out.println(c.get(Calendar.HOUR) + "시 " + c.get(Calendar.MINUTE) + "분 " + c.get(Calendar.SECOND) + "초");
    }

}

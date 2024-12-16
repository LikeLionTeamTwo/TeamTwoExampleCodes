package Junho.실습문제.PrintCalendar;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class PrintCalendar {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 1, 1);
        System.out.println("\t---2024년 달력---" + "\n");
        while(date.getYear() == 2024){
            System.out.println("\t\t" + date.getMonth() + "\n");
            int endDay = YearMonth.of(date.getYear(), date.getMonth()).atEndOfMonth().getDayOfMonth();
            System.out.println("일\t월\t화\t수\t목\t금\t토");
            StringBuilder sb = new StringBuilder();
            int dayOfWeekValue = getCustomDayOfWeek(date);
            for (int i = 0; i < dayOfWeekValue; i++) {
                sb.append("\t");
            }
            sb.append(date.getDayOfMonth());
            sb.append("\t");
            if(getCustomDayOfWeek(date) == 6) sb.append("\n");
            date = date.plusDays(1);
            while(date.getDayOfMonth() <= endDay){
                //첫 주는 예외 나머진 그냥 하면 됨
                sb.append(date.getDayOfMonth());
                sb.append("\t");
                if(getCustomDayOfWeek(date) == 6) sb.append("\n");
                if (date.getDayOfMonth() == endDay) break;
                date = date.plusDays(1);
            }
            System.out.println(sb.append("\n"));
            date = date.plusDays(1);
        }
    }
    public static int getCustomDayOfWeek(LocalDate date) {
        // DayOfWeek 값 가져오기 (월요일=1, 일요일=7)
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int standardDay = dayOfWeek.getValue(); // 월요일=1, 일요일=7
        return (standardDay % 7); // 일요일 7 -> 0
    }
}
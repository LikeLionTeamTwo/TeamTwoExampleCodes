package Junho.실습문제.PrintCalendar;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class PrintCalendar {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 1, 1); // 2024년 1월 1일 LocalDate 생성
        System.out.println("\t---2024년 달력---" + "\n");
        while(date.getYear() <= 2024){ // 2024 년이 넘어가기 전 까지 반복
            System.out.println("\t\t" + date.getMonth() + "\n"); // 현재 월 출력
            int endDay = YearMonth.of(date.getYear(), date.getMonth()).atEndOfMonth().getDayOfMonth(); // 현재 달의 마지막 날
            System.out.println("일\t월\t화\t수\t목\t금\t토"); // 달력의 컬럼 명 출력
            StringBuilder sb = new StringBuilder(); // 일 수를 담을 인스턴스
            int dayOfWeekValue = getCustomDayOfWeek(date); //
            //첫 째주 dayOfWeekValue 만큼 '\t' 하기
            for (int i = 0; i < dayOfWeekValue; i++) {
                sb.append("\t");
            }
            //일 수 출력
            while(date.getDayOfMonth() <= endDay){
                sb.append(date.getDayOfMonth());
                sb.append("\t");
                if(getCustomDayOfWeek(date) == 6) sb.append("\n");
                if (date.getDayOfMonth() == endDay) break; // 마지막 날이라면 반복문 종료
                date = date.plusDays(1); // 다음 일 수로 넘어가기
            }
            System.out.println(sb.append("\n"));
            date = date.plusDays(1); //다음 달로 넘어가기
        }
    }
    public static int getCustomDayOfWeek(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek(); // 현재 요일의 value 받기 (월요일=1, 일요일=7)
        int standardDay = dayOfWeek.getValue(); // 월요일=1, 일요일=7
        return (standardDay % 7); // 일요일 7 -> 0
    }
}
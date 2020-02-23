package leetcode.conquer.sol.string;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
 * just know how to use the java time lib. 
 * this question itself is stupid
 */
public class NumberOfDaysBetweenTwoDates {
	public NumberOfDaysBetweenTwoDates() {}
	
    public int daysBetweenDates(String date1, String date2) {
        //Parsing the date
        LocalDate dateBefore = LocalDate.parse(date1);
        LocalDate dateAfter = LocalDate.parse(date2);

        //calculating number of days in between
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        //displaying the number of days
        return Math.abs((int)noOfDaysBetween);
    }
}

package sourceFiles;

public class DayTester
{
	public static void main (String[] args)
	{
		Day day = new Day(1995, 1, 17);
		Day day2 = new Day();
		
		day2 = day.addDays(10);
		
		System.out.println("Expected: 10");
		System.out.println("Difference in days: " + day2.daysFrom(day));
		
	}
}

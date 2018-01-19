package Question_1;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class PrintCalendar
{
	public static void main(String[] args)
	{
		Calendar calendar = null;

		// Checking java command line usage 
		if(args.length == 2)
		{
			// Creating a Calendar object
			calendar = new GregorianCalendar(Integer.valueOf(args[1]), Integer.valueOf(args[0]) - 1, 1);
		}
		// in case the month only is entered
		else if(args.length == 1)
		{
			calendar = new GregorianCalendar();
			calendar.set(calendar.MONTH, Integer.valueOf(args[0]) - 1);
		}
		// in case nothing was specified
		else
			calendar = new GregorianCalendar();

		// Displaying the calendar header
		printHeader(calendar);

		// Displaying spaces before the first day of the month
		for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++)
			System.out.print("    ");

		// Displaying the days in the month
		while(calendar.get(Calendar.DATE) < calendar.getActualMaximum(Calendar.DATE))
		{
			if(calendar.get(Calendar.DAY_OF_WEEK) == 7)
				System.out.printf("%4d\n", calendar.get(Calendar.DATE));
			else
				System.out.printf("%4d", calendar.get(Calendar.DATE));

			// Adding a day
			calendar.add(Calendar.DATE, 1);
		}

		System.out.printf("%4d\n\n\n", calendar.get(Calendar.DATE));
	}

	// A method to display the calendar header 
	public static void printHeader(Calendar calendar)
	{
		// An array of month names
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		// Center month and year center format
		int length = 29 / 2 - (months[calendar.get(Calendar.MONTH)].length() / 2 + 3);

		System.out.println();

		for (int i = 0; i < length; i++)
			System.out.print(" ");

		System.out.println(months[calendar.get(Calendar.MONTH)] + ", " + calendar.get(Calendar.YEAR));

		// Displaying week day names
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}
}
package Question_2;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Library
{
	public static void main(String[] s) throws Exception
	{
		ArrayList<Movie> movies = new ArrayList<>();
		File input = new File("movies.txt");

		if(!input.exists())
		{
			System.out.println("--> ERROR: File not found!");
			System.exit(1);
		}

		Scanner in = new Scanner(input);

		in.nextLine(); // To ignore the first line

		while(in.hasNext())
		{
			String str = in.nextLine().trim();

			switch (getType(str))
			{
			case "Action":
				movies.add(new Action(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
						getCountry(str), getLanguage(str)));
				break;
			case "Comedy":
				movies.add(new Comedy(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
						getCountry(str), getLanguage(str)));
				break;
			case "Mystery":
				movies.add(new Mystery(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
						getCountry(str), getLanguage(str)));
				break;
			case "Rescue":
				movies.add(new Rescue(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
						getCountry(str), getLanguage(str)));
				break;
			case "Romance":
				movies.add(new Romance(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
						getCountry(str), getLanguage(str)));
				break;
			case "Romantic Comedy":
				movies.add(new RomanticComedy(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
						getCountry(str), getLanguage(str)));
				break;
			case "Hollywood Blockbuster":
				movies.add(new HollywoodBlockbuster(getType(str), getTitle(str), getStarring(str), getRunningTime(str),
						getCountry(str), getLanguage(str)));
				break;
			}
		}
		
		in.close();

		Collections.sort(movies);
		
		PrintWriter outFile = new PrintWriter("sorted_movies.txt");

		outFile.println("Type: Title, [Starring], Running time, Country, Language.");

		for (int i = 0; i < movies.size(); i++)
		{
			Movie movie = movies.get(i);

			outFile.println(
					movie.getType() + ": " + movie.getTitle() + ',' + Arrays.toString(movie.getStarring()) + ", "
					+ movie.getRunningTime() + ", " + movie.getCountry() + ", " + movie.getLanguage() + ".");
		}

		outFile.close();
	}

	public static String getType(String l)
	{
		return l.split(":")[0].trim();
	}

	public static String getTitle(String l)
	{
		return l.split("[:,]")[1].trim();
	}

	public static String[] getStarring(String l)
	{
		return l.substring(l.indexOf('[') + 1, l.indexOf(']')).trim().split(",");
	}

	public static int getRunningTime(String l)
	{
		return Integer.parseInt(l.substring(l.indexOf(']') + 2).trim().split(",")[0]);
	}

	public static String getCountry(String l)
	{
		return l.substring(l.indexOf(']') + 2).trim().split(",")[1].trim();
	}

	public static String getLanguage(String l)
	{
		return l.substring(l.indexOf(']') + 2).trim().split("[,.]")[2].trim();
	}
}
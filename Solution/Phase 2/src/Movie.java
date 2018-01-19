

import java.util.Arrays;

public abstract class Movie implements MovieInterface, Comparable<Movie>, Cloneable
{
	private String type;
	private String title;
	private String[] starring;
	private int runningTime;
	private String country;
	private String language;

	public Movie(String title, String[] starring, int runningTime, String country, String language)
	{
		this.title = title;
		this.starring = starring;
		this.runningTime = runningTime;
		this.country = country;
		this.language = language;
	}

	public String getType()
	{
		return type;
	}

	public String getTitle()
	{
		return title;
	}

	public String[] getStarring()
	{
		return starring;
	}

	public int getRunningTime()
	{
		return runningTime;
	}

	public String getCountry()
	{
		return country;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setStarring(String[] starring)
	{
		this.starring = starring;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public void setRunningTime(int runningTime)
	{
		this.runningTime = runningTime;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	@Override
	public abstract String toString();

	public String MovieInfo()
	{
		return " Movie {" + "title = " + title + ", starring = " + Arrays.toString(starring) + ", runningTime = "
				+ runningTime + ", country = " + country + ", language = " + language + " }";
	}

	@Override
	public int compareTo(Movie m)
	{
		int diff = type.compareTo(m.getType());

		if(diff != 0)
			return diff;

		return runningTime - m.getRunningTime();
	}
}
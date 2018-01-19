

public class Romance extends Movie implements RomanceInterface
{
	public Romance(String type, String title, String[] starring, int runningTime, String country, String language)
	{
		super(title, starring, runningTime, country, language);
		setType(type);
	}

	@Override
	public String toString()
	{
		return "Romance" + MovieInfo();
	}
}
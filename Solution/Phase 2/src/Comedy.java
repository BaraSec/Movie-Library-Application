

public class Comedy extends Movie implements ComedyInterface
{
	public Comedy(String type, String title, String[] starring, int runningTime, String country, String language)
	{
		super(title, starring, runningTime, country, language);
		setType(type);
	}

	@Override
	public String toString()
	{
		return "Comedy" + MovieInfo();
	}
}


public class Mystery extends Movie implements MysteryInterface
{
	public Mystery(String type, String title, String[] starring, int runningTime, String country, String language)
	{
		super(title, starring, runningTime, country, language);
		setType(type);
	}

	@Override
	public String toString()
	{
		return "Mystery" + MovieInfo();
	}
}
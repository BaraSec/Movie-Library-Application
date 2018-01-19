

public class RomanticComedy extends Movie implements RomanceInterface, ComedyInterface
{
	public RomanticComedy(String type, String title, String[] starring, int runningTime, String country,
			String language)
	{
		super(title, starring, runningTime, country, language);
		setType(type);
	}

	@Override
	public String toString()
	{
		return "RomanticComedy" + MovieInfo();
	}
}
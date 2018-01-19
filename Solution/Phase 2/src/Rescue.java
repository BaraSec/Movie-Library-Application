

public class Rescue extends Movie implements ActionInterface, RomanceInterface
{
	public Rescue(String type, String title, String[] starring, int runningTime, String country, String language)
	{
		super(title, starring, runningTime, country, language);
		setType(type);
	}

	@Override
	public String toString()
	{
		return "Rescue" + MovieInfo();
	}
}
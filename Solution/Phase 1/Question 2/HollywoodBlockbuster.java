package Question_2;

public class HollywoodBlockbuster extends Movie
		implements ActionInterface, MysteryInterface, RomanceInterface, ComedyInterface
{
	public HollywoodBlockbuster(String type, String title, String[] starring, int runningTime, String country,
			String language)
	{
		super(title, starring, runningTime, country, language);
		setType(type);
	}

	@Override
	public String toString()
	{
		return "HollywoodBlockbuster" + MovieInfo();
	}
}
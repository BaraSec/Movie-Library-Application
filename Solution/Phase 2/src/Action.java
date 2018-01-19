

public class Action extends Movie implements ActionInterface
{
	public Action(String type, String title, String[] starring, int runningTime, String country, String language)
	{
		super(title, starring, runningTime, country, language);
		setType(type);
	}

	@Override
	public String toString()
	{
		return "Action" + MovieInfo();
	}
}
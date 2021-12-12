package editor;

public class Editor 
{
	private StringBuilder text = new StringBuilder();
	
	public StringBuilder getText()
	{
		return text;
	}
	
	public void setText(StringBuilder text)
	{
		this.text = text;
	}
}

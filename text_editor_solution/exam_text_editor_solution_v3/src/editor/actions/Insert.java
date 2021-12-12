package editor.actions;

import editor.Editor;

public class Insert implements Action
{
	private String[] wordsToBeInserted;
	
	public Insert(String[] wordsToBeInserted)
	{
		if (wordsToBeInserted == null || wordsToBeInserted.length == 0)
			throw new IllegalArgumentException("Se necesita al menos una palabra a insertar");
		this.wordsToBeInserted = wordsToBeInserted;
	}
	
	@Override
	public void execute(Editor editor) 
	{
		editor.insert(wordsToBeInserted);
	}

	@Override
	public String toString()
	{
		return "Insertar " + wordsToBeInserted;
	}
}

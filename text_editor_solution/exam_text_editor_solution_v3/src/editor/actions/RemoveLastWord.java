package editor.actions;

import editor.Editor;

public class RemoveLastWord implements Action
{
	@Override
	public void execute(Editor editor) 
	{
		editor.removeLastWord();
	}
	
	@Override
	public String toString()
	{
		return "Borrar";
	}
}

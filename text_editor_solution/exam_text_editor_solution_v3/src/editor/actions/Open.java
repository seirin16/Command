package editor.actions;

import editor.Editor;

public class Open implements Action
{
	private String filename;
	
	public Open(String filename)
	{
		if (filename == null || filename.trim().length() == 0)
			throw new IllegalArgumentException("Se necesita el nombre del fichero a abrir");
		this.filename = filename;
	}
	
	@Override
	public void execute(Editor editor) 
	{
		editor.open(filename);			
	}
	
	@Override
	public String toString()
	{
		return "Abrir " + filename;
	}
}

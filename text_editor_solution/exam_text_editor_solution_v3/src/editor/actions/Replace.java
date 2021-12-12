package editor.actions;

import editor.Editor;

public class Replace implements Action
{
	private String source, destination;
	
	public Replace(String source, String destination) 
	{
		if (source == null || destination == null)
			throw new IllegalArgumentException("La operación de reemplazo necesita la cadena de origen y de destino");
		this.source = source;
		this.destination = destination;
	}
	
	@Override
	public void execute(Editor editor) 
	{
		editor.replace(source, destination);
	}
	
	@Override
	public String toString()
	{
		return "Reemplazar " + source + " por " + destination;
	}
}

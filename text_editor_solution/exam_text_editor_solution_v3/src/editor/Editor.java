package editor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Editor 
{
	private StringBuilder text = new StringBuilder();
	
	public String getText()
	{
		return text.toString();
	}
		
	public void open(String filename)
	{
		try {
			text = readFile(filename);			
		} catch (IOException e) {
			System.out.printf("No se pudo abrir el fichero '%s': %s", filename, e.getMessage());
		}
	}
	
	private StringBuilder readFile(String filename) throws IOException 
	{
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String line;
		StringBuilder result = new StringBuilder();
		while ((line = input.readLine()) != null) {
			result.append(line);
		}
		input.close();
		return result;
	}
	
	public void insert(String[] wordsToBeInserted)
	{
		for (String word : wordsToBeInserted) {
			text.append(word + " ");			
		}
	}
	
	public void removeLastWord()
	{
		int indexOfLastWord = text.toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			text = new StringBuilder("");
		else
			text.setLength(indexOfLastWord + 1);
	}
	
	public void replace(String source, String destination)
	{
		text = new StringBuilder(text.toString().replaceAll(Pattern.quote(source), destination));
	}
}

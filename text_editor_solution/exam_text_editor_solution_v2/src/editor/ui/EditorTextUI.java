package editor.ui;

import java.io.*;
import java.util.Arrays;

import editor.ActionManager;
import editor.Editor;
import editor.actions.*;

public class EditorTextUI 
{
	private static BufferedReader in;
	private Editor editor;
	private ActionManager actionManager;
	
	public EditorTextUI(Editor editor)
	{
		if (editor == null)
			throw new IllegalArgumentException("La interfaz de usuario necesita una referencia al editor");
		this.editor = editor;
		this.actionManager = new ActionManager(editor);
	}
	
	public void run() throws IOException
	{
		in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Acciones");
		System.out.println("--------");
		System.out.println("abre <fichero>");
		System.out.println("inserta <texto>\t\t// inserta las palabras al final del texto");
		System.out.println("borra\t\t\t// borra la última palabra");
		System.out.println("reemplaza <a> <b>\t// reemplaza la cadena <a> por la <b> en todo el texto");
		System.out.println("salir");
		System.out.println();
		System.out.println("Tareas");
		System.out.println("------");
		System.out.println("graba <macro>\t\t// comienza la grabación de una macro");
		System.out.println("para\t\t\t// finaliza la grabación");
		System.out.println("ejecuta <macro>\t\t// ejecuta la macro cuyo nombre se indique");
		System.out.println();

		do {
			System.out.print("> ");

			String[] line = in.readLine().split(" ");
			
			// No se comprueba que el número de palabras sea el adecuado

			if (line[0].equals("salir"))
				return;

			if (line[0].equals("abre")) {
				actionManager.execute(new Open(line[1]));
			}  else if (line[0].startsWith("ins")) {
				String[] wordsToAppend = Arrays.copyOfRange(line, 1, line.length);
				actionManager.execute(new Insert(wordsToAppend));
			} else if (line[0].startsWith("borr")) {
				actionManager.execute(new RemoveLastWord());
			} else if (line[0].startsWith("reem")) {
				actionManager.execute(new Replace(line[1], line[2]));
			} else if (line[0].startsWith("graba")) {
				actionManager.record(line[1]);
			} else if (line[0].startsWith("para")) {
				actionManager.stop();
			} else if (line[0].startsWith("ejecuta")) {
				actionManager.executeMacro(line[1]);
			} else {
				System.out.println("Instrucción desconocida");
			}

			System.out.println(editor.getText());
		} while (true);
	}
}

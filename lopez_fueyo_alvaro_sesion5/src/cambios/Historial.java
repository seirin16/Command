package cambios;

import java.util.Stack;

public class Historial {

	private Stack<ICambio> undos = new Stack<ICambio>();
	private Stack<ICambio> redos = new Stack<ICambio>();

	public void hacerCambio(ICambio cambio) {
		undos.push(cambio);
		redos.clear();

	}

	public void undo() {
		if (undos.isEmpty()) {
			System.out.println("No hay elementos");
		}

		ICambio cambio = undos.pop();
		cambio.undo();
		redos.push(cambio);
	}

	public void redo() {
		if (redos.isEmpty()) {
			System.out.println("No hay elementos");
		}

		ICambio cambio = redos.pop();
		cambio.redo();
		undos.push(cambio);

	}

}

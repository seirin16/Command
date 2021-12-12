package cambios;

import editor.Dibujo;
import editor.Figura;

public class CambioCreacion implements ICambio {
	
	private Dibujo dibujo;
	private Figura figura;
	
	
	public CambioCreacion(Dibujo dibujo, Figura figura) {
		this.dibujo=dibujo;
		this.figura=figura;
	}

	@Override
	public void undo() {
		dibujo.DeleteFigura(figura);
		
	}

	@Override
	public void redo() {
		dibujo.AddFigura(figura);
		
	}

}

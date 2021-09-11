
public class Ficha {
	private boolean pieza;
	
	public Ficha(int player) {
		if (player == 0) {
			pieza=false;
		} else {
			pieza=true;
		}
	}
	
	public boolean getPieza() {
		return pieza;
	}

	public void cambiaPieza() {
		if (pieza) {
			pieza=false;
		} else {
			pieza=true;
		}
	}

	@Override
	public String toString() {
		String piezaString;
		if (pieza) {
			piezaString = "O";
		} else {
			piezaString = "X";
		}
		
		return piezaString;
	}
	
}

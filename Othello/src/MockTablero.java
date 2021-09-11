
public class MockTablero extends Tablero {
	
	public MockTablero() {
		super();
	}
	
	public boolean colocarFicha(int x, int y, int turno) {
		boolean res = false;
		if (x==4 && y==2) {
			res = true;
		} else if (x==5 && y==4) {
			res = true;
		}
		return res;
	}
}

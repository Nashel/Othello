public class Tablero {
	private final static int tamaño = 8;
	Ficha tablero[][];
	int posiciones_libres;
	
	public Tablero() {
		posiciones_libres = (tamaño*tamaño)-4;
		tablero = new Ficha[tamaño][tamaño];
		int mitad_tablero = tamaño/2;
		tablero[mitad_tablero-1][mitad_tablero-1] = new Ficha(0);
		tablero[mitad_tablero-1][mitad_tablero] = new Ficha(1);
		tablero[mitad_tablero][mitad_tablero-1] = new Ficha(1);
		tablero[mitad_tablero][mitad_tablero] = new Ficha(0);
	}
	
	public int checkWin() {
		int ganador=-1;
		int jugador1=0,jugador2=0;
		for (int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				Ficha ficha=tablero[i][j];
				if (ficha!=null) {
					if (!ficha.getPieza()) {
						jugador1++;
					} else {
						jugador2++;
					}
				}
			}
		}
		if (jugador1>jugador2) {
			ganador=0;
		} else if (jugador2>jugador1) {
			ganador=1;
		}
		return ganador;
	}

	public boolean estaLleno(){
		boolean Lleno=false;
		if (posiciones_libres<=0)
			Lleno=true;
		return Lleno;
	}

	public boolean esMovimientoPosible(int fila, int columna, int turno) {
		boolean esPosible=false;
		int contador;
		if (!(fila>=tamaño || columna >=tamaño || fila<0 || columna<0 || tablero[fila][columna]!=null)) {
			for (int i=-1;i<=1;i++) {
				for (int j=-1;j<=1;j++) {
					if ((fila+i >= 0 && fila+i < tamaño) && (columna+j >=0 && columna+j < tamaño) && !esPosible) {
						if (tablero[fila+i][columna+j]!=null) {
							contador=0;
							esPosible=compruebaDireccion(fila,columna,i,j,turno,contador);
						}
					}
				}
			}
		}
		return esPosible;
	}

	public boolean compruebaDireccion(int fila, int columna, int i, int j, int turno, int contador) {
		boolean pieza, esPosible=false;
		if (!(fila>=tamaño || columna >=tamaño || fila<0 || columna<0)) {
			if (turno == 0) {
				
				if ((fila+i >= 0 && fila+i < tamaño) && (columna+j >=0 && columna+j < tamaño)) {
					if (tablero[fila+i][columna+j]!=null) {
						pieza = tablero[fila+i][columna+j].getPieza();
						if (pieza) {
							contador+=1;
							esPosible=compruebaDireccion(fila+i,columna+j,i,j,turno,contador);
						} else if (contador>0) {
							esPosible=true;
						}
					}
				}
				
			} else {
				
				if ((fila+i >= 0 && fila+i < tamaño) && (columna+j >=0 && columna+j < tamaño)) {
					if (tablero[fila+i][columna+j]!=null) {
						pieza = tablero[fila+i][columna+j].getPieza();
						if (!pieza) {
							contador+=1;
							esPosible=compruebaDireccion(fila+i,columna+j,i,j,turno,contador);
						} else if (contador>0){
							esPosible=true;
						}
					}
				}
				
			}
		}
		return esPosible;
	}
	
	public boolean quedanMovimientos(int turno) {
		boolean mov = false;
	
		for (int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if (tablero[i][j] == null) {
					if (esMovimientoPosible(i,j,turno)) {
						mov=true;
					}
				}
			}
		}
		
		return mov;
	}
	
	public void actualizarTableroIzquierda(int x, int y, Ficha ficha) 
	{
		if(x>0 && y<8 && x<8 && y > -1)
		{
			if (tablero[x-1][y]!=null) 
			{
				if(tablero[x-1][y].getPieza()!=ficha.getPieza())
				{
					this.actualizarTableroIzquierda(x-1, y, ficha);
				}
				else 
				{
					if (tablero[x][y]!=null) 
					{
					if(tablero[x][y].getPieza()!=ficha.getPieza())
					{
						tablero[x][y].cambiaPieza();
						actualizarTableroIzquierda(x+1,y,ficha);
					}
					}
				}
			}
		}
	}
	
	public void actualizarTableroDerecha(int x, int y, Ficha ficha) 
	{
		if(x<7 && x>-1 && y<8 && y>-1)
		{
			if (tablero[x+1][y]!=null) 
			{
				if(tablero[x+1][y].getPieza()!=ficha.getPieza())
				{
					this.actualizarTableroDerecha(x+1, y, ficha);
				}
				else 
				{
					if (tablero[x][y]!=null) 
					{
					if(tablero[x][y].getPieza()!=ficha.getPieza())
					{
						tablero[x][y].cambiaPieza();
						actualizarTableroDerecha(x-1,y,ficha);
						
					}
					}
				}
			}
		}
	}
	
	public void actualizarTableroAbajo(int x, int y, Ficha ficha) 
	{
		if(y<7 && x<8 && x>-1 && y>-1)
		{
			if (tablero[x][y+1]!=null) 
			{
				if(tablero[x][y+1].getPieza()!=ficha.getPieza())
				{
					this.actualizarTableroAbajo(x, y+1, ficha);
				}
				else 
				{
					if (tablero[x][y]!=null) 
					{
					if(tablero[x][y].getPieza()!=ficha.getPieza())
					{
						tablero[x][y].cambiaPieza();
						actualizarTableroAbajo(x,y-1,ficha);
						
					}
					}
				}
			}
		}
	}
	
	public void actualizarTableroArriba(int x, int y, Ficha ficha) 
	{
		if(y>0 && x>-1 && x<8 && y<8)
		{
			if (tablero[x][y-1]!=null) 
			{
				if(tablero[x][y-1].getPieza()!=ficha.getPieza())
				{
					this.actualizarTableroArriba(x, y-1, ficha);
				}
				else 
				{
					if (tablero[x][y]!=null) 
					{
					if(tablero[x][y].getPieza()!=ficha.getPieza())
					{
						tablero[x][y].cambiaPieza();
						actualizarTableroArriba(x,y+1,ficha);
					}
					}
				}
			}
		}
	}
	
	public void actualizarTableroArribaIzquierda(int x, int y, Ficha ficha) 
	{
		if(y>0 && x>0)
		{
			if (tablero[x-1][y-1]!=null) 
			{
				if(tablero[x-1][y-1].getPieza()!=ficha.getPieza())
				{
					this.actualizarTableroArribaIzquierda(x-1, y-1, ficha);
				}
				else 
				{
					if (tablero[x][y]!=null) 
					{
					if(tablero[x][y].getPieza()!=ficha.getPieza())
					{
						tablero[x][y].cambiaPieza();
						actualizarTableroArribaIzquierda(x+1,y+1,ficha);
					}
					}
				}
			}
		}
	}
	
	public void actualizarTableroArribaDerecha(int x, int y, Ficha ficha) 
	{
		if(y>0 && x<7)
		{
			if (tablero[x+1][y-1]!=null) 
			{
				if(tablero[x+1][y-1].getPieza()!=ficha.getPieza())
				{
					this.actualizarTableroArribaDerecha(x+1, y-1, ficha);
				}
				else 
				{
					if (tablero[x][y]!=null) 
					{
					if(tablero[x][y].getPieza()!=ficha.getPieza())
					{
						tablero[x][y].cambiaPieza();
						actualizarTableroArribaDerecha(x-1,y+1,ficha);
					}
					}
				}
			}
		}
	}
	
	public void actualizarTableroAbajoIzquierda(int x, int y, Ficha ficha) 
	{
		if(y<7 && x>0)
		{
			if (tablero[x-1][y+1]!=null) 
			{
				if(tablero[x-1][y+1].getPieza()!=ficha.getPieza())
				{
					this.actualizarTableroAbajoIzquierda(x-1, y+1, ficha);
				}
				else
				{
					if (tablero[x][y]!=null) 
					{
					if(tablero[x][y].getPieza()!=ficha.getPieza())
					{
						tablero[x][y].cambiaPieza();
						actualizarTableroAbajoIzquierda(x+1,y-1,ficha);
					}
					}
				}
			}
		}
	}
	
	public void actualizarTableroAbajoDerecha(int x, int y, Ficha ficha) 
	{
		if(y<7 && x<7)
		{
			if (tablero[x+1][y+1]!=null) 
			{
				if(tablero[x+1][y+1].getPieza()!=ficha.getPieza())
				{
					this.actualizarTableroAbajoDerecha(x+1, y+1, ficha);
				}
				else
				{
					if (tablero[x][y]!=null) 
					{
					if(tablero[x][y].getPieza()!=ficha.getPieza())
					{
						tablero[x][y].cambiaPieza();
						actualizarTableroAbajoDerecha(x-1,y-1,ficha);
					}
					}
				}
			}
		}
	}

	public boolean colocarFicha(int x, int y, int turno)
	{
		boolean posicionValida = false;
		if (esMovimientoPosible(x,y,turno)) 
		{
			Ficha fichaEntrada=new Ficha(turno);
			
			posicionValida=true;
			
			tablero[x][y]=fichaEntrada;
			posiciones_libres-=1;
			
			actualizarTableroDerecha(x,y,tablero[x][y]);
			actualizarTableroIzquierda(x,y,tablero[x][y]);
			actualizarTableroArriba(x,y,tablero[x][y]);
			actualizarTableroAbajo(x,y,tablero[x][y]);
			
			actualizarTableroArribaDerecha(x,y,tablero[x][y]);
			actualizarTableroArribaIzquierda(x,y,tablero[x][y]);
			actualizarTableroAbajoDerecha(x,y,tablero[x][y]);
			actualizarTableroAbajoIzquierda(x,y,tablero[x][y]);
		}
	return posicionValida;
	}
	
	@Override
	public String toString() {
		String tab;
		Ficha ficha;
		tab = 	"     A   B   C   D   E   F   G   H  \n"+
				"    ------------------------------- \n";
		for (int i=0;i<tamaño;i++) {
			tab += " " + (i+1) + " |";
			for (int j=0;j<tamaño;j++) {
				ficha = tablero[i][j];
				if (ficha != null) {
					tab += " " + ficha + " |";
				} else {
					tab += "   |";
				}
			}
			if (i<tamaño-1) {
				tab += "\n   |-------------------------------|\n";
			}
		}
		tab += "\n    ------------------------------- \n";
		return tab;
	}
	
}
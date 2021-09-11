import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {

	Tablero tablero= new Tablero();
	
	@Test
	public void testEstaLleno() {
		
		boolean res_0 = tablero.estaLleno();		//sense definir valor
		assertEquals(false, res_0);
		
		tablero.posiciones_libres=0;			//valor limit
		boolean res_1 = tablero.estaLleno();
		assertEquals(true, res_1);
		
		tablero.posiciones_libres=10;			//particio equivalent
		boolean res_2 = tablero.estaLleno();
		assertEquals(false, res_2);
		
		tablero.posiciones_libres=64;			//valor limit
		boolean res_3 = tablero.estaLleno();
		assertEquals(false, res_3);
		
		tablero.posiciones_libres=65;			//valor frontera
		boolean res_4 = tablero.estaLleno();
		assertEquals(false, res_4);
		
		tablero.posiciones_libres=-1;			//valor frontera
		boolean res_5 = tablero.estaLleno();
		assertEquals(true, res_5);
		
		tablero.posiciones_libres=1;			//valor frontera
		boolean res_6 = tablero.estaLleno();
		assertEquals(false, res_6);
												
		tablero.posiciones_libres=63;			//valor frontera
		boolean res_7 = tablero.estaLleno();
		assertEquals(false, res_7);
	}

	@Test
	public void esMovimientoPosibleTest() {
		
		// Jugador 1
		assertEquals(false,tablero.esMovimientoPosible(4,4,0));		//encima de otra pieza
		
		assertEquals(false,tablero.esMovimientoPosible(4,5,0));		//a la derecha
		assertEquals(true,tablero.esMovimientoPosible(4,2,0));		//a la izquierda
		
		assertEquals(false,tablero.esMovimientoPosible(5,5,0));		//a la diagonal derecha-abajo
		assertEquals(false,tablero.esMovimientoPosible(2,5,0));		//a la diagonal derecha-arriba
		assertEquals(false,tablero.esMovimientoPosible(5,2,0));		//a la diagonal izq-abajo
		assertEquals(false,tablero.esMovimientoPosible(2,2,0));		//a la diagonal izq-arriba
		assertEquals(true,tablero.esMovimientoPosible(2,4,0));		//arriba
		assertEquals(false,tablero.esMovimientoPosible(5,4,0));		//abajo

		assertEquals(false,tablero.esMovimientoPosible(4,6,0));		//a 2 casillas

		assertEquals(false,tablero.esMovimientoPosible(4,8,0));		//fuera de tablero
		assertEquals(false,tablero.esMovimientoPosible(8,4,0));
		assertEquals(false,tablero.esMovimientoPosible(8,8,0));
		assertEquals(false,tablero.esMovimientoPosible(-1,-1,0));
		
		assertEquals(false,tablero.esMovimientoPosible(0,0,0));		//Valores limite
		assertEquals(false,tablero.esMovimientoPosible(7,7,0));
		assertEquals(false,tablero.esMovimientoPosible(0,7,0));
		assertEquals(false,tablero.esMovimientoPosible(7,0,0));

		// Jugador 2
		assertEquals(false,tablero.esMovimientoPosible(4,4,1));		//encima de otra pieza
		
		assertEquals(true,tablero.esMovimientoPosible(4,5,1));		//a la derecha
		assertEquals(false,tablero.esMovimientoPosible(4,2,1));		//a la izquierda
		
		assertEquals(false,tablero.esMovimientoPosible(5,5,1));		//a la diagonal derecha-abajo
		assertEquals(false,tablero.esMovimientoPosible(2,5,1));		//a la diagonal derecha-arriba
		assertEquals(false,tablero.esMovimientoPosible(5,2,1));		//a la diagonal izq-abajo
		assertEquals(false,tablero.esMovimientoPosible(2,2,1));		//a la diagonal izq-arriba
		assertEquals(false,tablero.esMovimientoPosible(2,4,1));		//arriba
		assertEquals(true,tablero.esMovimientoPosible(5,4,1));		//abajo

		assertEquals(false,tablero.esMovimientoPosible(4,6,1));		//a 2 casillas

		assertEquals(false,tablero.esMovimientoPosible(4,8,1));		//fuera de tablero
		assertEquals(false,tablero.esMovimientoPosible(8,4,1));
		assertEquals(false,tablero.esMovimientoPosible(8,8,1));
		assertEquals(false,tablero.esMovimientoPosible(-1,-1,1));
		
		assertEquals(false,tablero.esMovimientoPosible(0,0,1));		//Valores limite
		assertEquals(false,tablero.esMovimientoPosible(7,7,1));
		assertEquals(false,tablero.esMovimientoPosible(0,7,1));
		assertEquals(false,tablero.esMovimientoPosible(7,0,1));
		
		tablero.tablero[5][2] = new Ficha(0);
		assertEquals(true,tablero.esMovimientoPosible(2,5,0));		//diagonal de mas de 1
	}

	@Test
	public void compruebaDireccionTest() {
		
		assertEquals(true,tablero.compruebaDireccion(4, 5, 0, -1, 1, 0));	//izquierda
		assertEquals(false,tablero.compruebaDireccion(4, 2, 0, 1, 1, 0));	//derecha
		assertEquals(true,tablero.compruebaDireccion(2, 4, 1, 0, 0, 0));	//arriba
		assertEquals(false,tablero.compruebaDireccion(5, 4, -1, 0, 0, 0));	//abajo
		
		assertEquals(true,tablero.compruebaDireccion(5, 4, -1, 0, 0, 1));	//cambiando contador
		assertEquals(false,tablero.compruebaDireccion(5, 4, -1, 0, 0, -1));
		
		assertEquals(false,tablero.compruebaDireccion(4,8,1,1,0,0));		//fuera de tablero
		assertEquals(false,tablero.compruebaDireccion(8,4,1,1,0,0));
		assertEquals(false,tablero.compruebaDireccion(8,8,1,1,0,0));
		assertEquals(false,tablero.compruebaDireccion(-1,-1,1,1,0,0));
		
		assertEquals(false,tablero.compruebaDireccion(0,0,1,1,0,0));		//Valores limite
		assertEquals(false,tablero.compruebaDireccion(7,7,1,1,0,0));
		assertEquals(false,tablero.compruebaDireccion(0,7,1,1,0,0));
		assertEquals(false,tablero.compruebaDireccion(7,0,1,1,0,0));
		
		tablero.tablero[7][7] = new Ficha(0);
		assertEquals(false,tablero.compruebaDireccion(7,6,0,1,1,0));
	}
	
	@Test
	public void checkWinTest() {
		for (int i=0;i<8;i++)								//Llenar tablero de Fichas de jugador 1
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=new Ficha(0);
		assertEquals(0,tablero.checkWin());
		
		for (int i=0;i<8;i++)								//Llenar tablero de Fichas de jugador 2
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=new Ficha(1);
		assertEquals(1,tablero.checkWin());
		
		for (int i=0;i<4;i++)								//Llenar tablero de Fichas mitad y mitad
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=new Ficha(0);
		for (int i=4;i<8;i++)
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=new Ficha(1);
		assertEquals(-1,tablero.checkWin());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		for (int i=0;i<8;i++)								//Deja fichas nulas
			for(int j=0;j<7;j++)
				tablero.tablero[i][j]=new Ficha(1);
		assertEquals(1,tablero.checkWin());
	}
	
	@Test
	public void quedanMovimientosTest() {
		
		assertEquals(true,tablero.quedanMovimientos(1));

		assertEquals(true,tablero.quedanMovimientos(0));
		
		for (int i=0;i<8;i++)								//Deja fichas nulas
			for(int j=0;j<7;j++)
				tablero.tablero[i][j]=new Ficha(1);
		assertEquals(false,tablero.quedanMovimientos(0));
		
		for (int i=0;i<8;i++)								//Deja fichas nulas
			for(int j=0;j<6;j++)
				tablero.tablero[i][j]=new Ficha(1);
		for (int i=0;i<8;i++)
			tablero.tablero[i][6]=new Ficha(0);
		assertEquals(false,tablero.quedanMovimientos(0));
		
		for (int i=0;i<4;i++)								//Llenar tablero de Fichas mitad y mitad
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=new Ficha(0);
		for (int i=4;i<8;i++)
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=new Ficha(1);
		assertEquals(false,tablero.quedanMovimientos(0));
	}
	
	@Test
	public void testActualizarTableroIzquierda() {
		Ficha ficha0=new Ficha(0);
		Ficha ficha1=new Ficha(1);
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[4][4]=ficha0;					//ficha sobre la que se trabaja
		tablero.tablero[5][4]=ficha1;					//1 ficha al lado;
		tablero.actualizarTableroIzquierda(5,4,ficha1);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		
		tablero.tablero[3][4]=ficha1;					//1 ficha entremedio
		tablero.actualizarTableroIzquierda(5,4,ficha1);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[3][4].getPieza(), ficha1.getPieza());
		
		tablero.tablero[3][4]=ficha0;						//2fichas al lado(no estan en medio)
		tablero.tablero[4][4]=ficha0;
		tablero.actualizarTableroIzquierda(5,4,ficha1);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		
		tablero.tablero[2][4]=ficha1;							//2fichas entremedio
		tablero.actualizarTableroIzquierda(5,4,ficha1);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[3][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		
		tablero.tablero[2][2]=ficha0;				//sin ficha al lado izquierdo
		tablero.actualizarTableroIzquierda(2,2,ficha0);
		assertEquals(tablero.tablero[1][2], null);
		assertEquals(tablero.tablero[2][2].getPieza(), ficha0.getPieza());
		
		tablero.tablero[0][1]=ficha1;					//comprovacion pegado a la pared
		tablero.actualizarTableroIzquierda(0, 1, ficha1);
		assertEquals(tablero.tablero[0][1].getPieza(), ficha1.getPieza());
		
		tablero.tablero[0][7]=ficha1;
		tablero.tablero[1][7]=ficha0;
		tablero.tablero[2][7]=ficha1;
		tablero.actualizarTableroIzquierda(2, 7, ficha1);		//pegado a la pared cambiar ficha
		assertEquals(tablero.tablero[0][7].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[1][7].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][7].getPieza(), ficha1.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[0][7]=ficha1;
		tablero.tablero[2][7]=ficha1;
		tablero.actualizarTableroIzquierda(2, 7, ficha1);				//sinFichaentremedio
		assertEquals(tablero.tablero[0][7].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[1][7],null);
		assertEquals(tablero.tablero[2][7].getPieza(), ficha1.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.actualizarTableroIzquierda(-1, 5, ficha1);	//valors limit(fora taulell)
		tablero.actualizarTableroIzquierda(8, 5, ficha1);
		tablero.actualizarTableroIzquierda(3, -1, ficha1);
		tablero.actualizarTableroIzquierda(3, 8, ficha1);
		
		tablero.actualizarTableroIzquierda(8, 8, ficha1);
		tablero.actualizarTableroIzquierda(8, -1, ficha1);
		tablero.actualizarTableroIzquierda(-1, 8, ficha1);
		tablero.actualizarTableroIzquierda(-1, -1, ficha1);
		
		tablero.actualizarTableroIzquierda(1, 5, ficha1);	//valors limit(dins taulell)
		tablero.actualizarTableroIzquierda(6, 5, ficha1);
		tablero.actualizarTableroIzquierda(3, 1, ficha1);
		tablero.actualizarTableroIzquierda(3, 6, ficha1);
		
		tablero.actualizarTableroIzquierda(6, 6, ficha1);
		tablero.actualizarTableroIzquierda(6, 1, ficha1);
		tablero.actualizarTableroIzquierda(1, 6, ficha1);
		tablero.actualizarTableroIzquierda(1, 1, ficha1);
		
		//Probes caixa_blanca (condition and decision coverage)
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[5][6]=ficha0;
		tablero.tablero[4][6]=ficha0;
		tablero.actualizarTableroIzquierda(5, 6, ficha1);
		assertEquals(tablero.tablero[5][6].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][6].getPieza(), ficha0.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[5][6]=ficha0;
		tablero.tablero[3][6]=ficha0;
		tablero.actualizarTableroIzquierda(4, 6, ficha1);
		assertEquals(tablero.tablero[5][6].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][6].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][6], null);
		
	}
	
	@Test
	public void testActualizarTableroDerecha() {
		Ficha ficha0=new Ficha(0);
		Ficha ficha1=new Ficha(1);
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[4][4]=ficha0;					//ficha sobre la que se trabaja
		tablero.tablero[5][4]=ficha1;					//1 ficha al lado;
		tablero.actualizarTableroDerecha(4,4,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		
		tablero.tablero[3][4]=ficha1;					//1 ficha entremedio
		tablero.actualizarTableroDerecha(3,4,ficha1);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[3][4].getPieza(), ficha1.getPieza());
		
		tablero.tablero[3][4]=ficha0;						//2fichas al lado(no estan en medio)
		tablero.tablero[4][4]=ficha1;
		tablero.actualizarTableroDerecha(3,4,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[3][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		
		tablero.tablero[6][4]=ficha0;							//2fichas entremedio
		tablero.actualizarTableroDerecha(3,4,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[6][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha0.getPieza());
		
		tablero.tablero[2][2]=ficha0;				//sin ficha al lado derecho
		tablero.actualizarTableroDerecha(2,2,ficha0);
		assertEquals(tablero.tablero[3][2], null);
		assertEquals(tablero.tablero[2][2].getPieza(), ficha0.getPieza());
		
		tablero.tablero[7][1]=ficha1;					//comprovacion pegado a la pared
		tablero.actualizarTableroDerecha(0, 1, ficha1);
		assertEquals(tablero.tablero[7][1].getPieza(), ficha1.getPieza());
		
		tablero.tablero[5][7]=ficha1;
		tablero.tablero[6][7]=ficha0;
		tablero.tablero[7][7]=ficha1;
		tablero.actualizarTableroDerecha(5, 7, ficha1);		//pegado a la pared cambiar ficha
		assertEquals(tablero.tablero[5][7].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][7].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[7][7].getPieza(), ficha1.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[5][7]=ficha1;
		tablero.tablero[7][7]=ficha1;
		tablero.actualizarTableroDerecha(5, 7, ficha1);					//sinFichaentremedio
		assertEquals(tablero.tablero[5][7].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][7],null);
		assertEquals(tablero.tablero[7][7].getPieza(), ficha1.getPieza());
		
		
		tablero.actualizarTableroDerecha(-1, 5, ficha1);	//valors limit(fora taulell)
		tablero.actualizarTableroDerecha(8, 5, ficha1);
		tablero.actualizarTableroDerecha(3, -1, ficha1);
		tablero.actualizarTableroDerecha(3, 8, ficha1);
		
		tablero.actualizarTableroDerecha(8, 8, ficha1);
		tablero.actualizarTableroDerecha(8, -1, ficha1);
		tablero.actualizarTableroDerecha(-1, 8, ficha1);
		tablero.actualizarTableroDerecha(-1, -1, ficha1);
		
		tablero.actualizarTableroDerecha(1, 5, ficha1);	//valors limit(dins taulell)
		tablero.actualizarTableroDerecha(6, 5, ficha1);
		tablero.actualizarTableroDerecha(3, 1, ficha1);
		tablero.actualizarTableroDerecha(3, 6, ficha1);
		
		tablero.actualizarTableroDerecha(6, 6, ficha1);
		tablero.actualizarTableroDerecha(6, 1, ficha1);
		tablero.actualizarTableroDerecha(1, 6, ficha1);
		tablero.actualizarTableroDerecha(1, 1, ficha1);
		
	}

	@Test
	public void testActualizarTableroAbajo() {
		Ficha ficha0=new Ficha(0);
		Ficha ficha1=new Ficha(1);
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[4][4]=ficha0;					//ficha sobre la que se trabaja
		tablero.tablero[4][5]=ficha1;					//1 ficha abajo;
		tablero.actualizarTableroAbajo(4,4,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha1.getPieza());
		
		tablero.tablero[4][6]=ficha0;					//1 ficha entremedio
		tablero.actualizarTableroAbajo(4,4,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][6].getPieza(), ficha0.getPieza());
		
		tablero.tablero[2][3]=ficha0;						//2fichas abajo(no estan en medio)
		tablero.tablero[2][4]=ficha1;
		tablero.tablero[2][5]=ficha1;
		tablero.actualizarTableroAbajo(2,3,ficha0);
		assertEquals(tablero.tablero[2][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][5].getPieza(), ficha1.getPieza());
		
		tablero.tablero[2][6]=ficha0;							//2fichas entremedio
		tablero.actualizarTableroAbajo(2,6,ficha0);
		assertEquals(tablero.tablero[2][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][6].getPieza(), ficha0.getPieza());
		
		tablero.tablero[6][6]=ficha0;				//sin ficha abajo
		tablero.actualizarTableroAbajo(6,6,ficha0);
		assertEquals(tablero.tablero[6][7], null);
		assertEquals(tablero.tablero[6][6].getPieza(), ficha0.getPieza());
		
		tablero.tablero[1][7]=ficha1;					//comprovacion pegado al suelo
		tablero.actualizarTableroAbajo(1, 7, ficha1);
		assertEquals(tablero.tablero[1][7].getPieza(), ficha1.getPieza());
		
		tablero.tablero[0][7]=ficha1;
		tablero.tablero[0][6]=ficha0;
		tablero.tablero[0][5]=ficha1;
		tablero.actualizarTableroAbajo(0, 5, ficha1);		//pegado al suelo cambiar ficha
		assertEquals(tablero.tablero[0][7].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[0][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[0][5].getPieza(), ficha1.getPieza());
	
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[0][7]=ficha1;
		tablero.tablero[0][5]=ficha1;
		tablero.actualizarTableroAbajo(0, 5, ficha1);			//sinFichaentremedio
		assertEquals(tablero.tablero[0][7].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[0][6],null);
		assertEquals(tablero.tablero[0][5].getPieza(), ficha1.getPieza());
	
		tablero.actualizarTableroAbajo(-1, 5, ficha1);	//valors limit(fora taulell)
		tablero.actualizarTableroAbajo(8, 5, ficha1);
		tablero.actualizarTableroAbajo(3, -1, ficha1);
		tablero.actualizarTableroAbajo(3, 8, ficha1);
		
		tablero.actualizarTableroAbajo(8, 8, ficha1);
		tablero.actualizarTableroAbajo(8, -1, ficha1);
		tablero.actualizarTableroAbajo(-1, 8, ficha1);
		tablero.actualizarTableroAbajo(-1, -1, ficha1);
		
		
		tablero.actualizarTableroAbajo(1, 5, ficha1);	//valors limit(dins taulell)
		tablero.actualizarTableroAbajo(6, 5, ficha1);
		tablero.actualizarTableroAbajo(3, 1, ficha1);
		tablero.actualizarTableroAbajo(3, 6, ficha1);
		
		tablero.actualizarTableroAbajo(6, 6, ficha1);
		tablero.actualizarTableroAbajo(6, 1, ficha1);
		tablero.actualizarTableroAbajo(1, 6, ficha1);
		tablero.actualizarTableroAbajo(1, 1, ficha1);
		
		
	}
	
	@Test
	public void testActualizarTableroArriba() {
		Ficha ficha0=new Ficha(0);
		Ficha ficha1=new Ficha(1);
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[4][4]=ficha0;					//ficha sobre la que se trabaja
		tablero.tablero[4][5]=ficha1;					//1 ficha arriba;
		tablero.actualizarTableroArriba(4,5,ficha1);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha1.getPieza());
		
		tablero.tablero[4][6]=ficha0;					//1 ficha entremedio
		tablero.actualizarTableroArriba(4,6,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][6].getPieza(), ficha0.getPieza());
		
		tablero.tablero[2][3]=ficha0;						//2fichas arriba(no estan en medio)
		tablero.tablero[2][4]=ficha0;
		tablero.tablero[2][5]=ficha1;
		tablero.actualizarTableroArriba(2,3,ficha0);
		assertEquals(tablero.tablero[2][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][5].getPieza(), ficha1.getPieza());
		
		tablero.tablero[2][2]=ficha1;							//2fichas entremedio
		tablero.actualizarTableroArriba(2,5,ficha0);
		assertEquals(tablero.tablero[2][3].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][5].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][2].getPieza(), ficha1.getPieza());
		
		tablero.tablero[6][6]=ficha0;				//sin ficha arriba
		tablero.actualizarTableroArriba(6,6,ficha0);
		assertEquals(tablero.tablero[6][5], null);
		assertEquals(tablero.tablero[6][6].getPieza(), ficha0.getPieza());
		
		tablero.tablero[1][0]=ficha1;					//comprovacion pegado al techo
		tablero.actualizarTableroArriba(1, 0, ficha1);
		assertEquals(tablero.tablero[1][0].getPieza(), ficha1.getPieza());
		
		tablero.tablero[0][0]=ficha1;
		tablero.tablero[0][1]=ficha0;
		tablero.tablero[0][2]=ficha1;
		tablero.actualizarTableroArriba(0, 5, ficha1);		//pegado al techo cambiar ficha
		assertEquals(tablero.tablero[0][0].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[0][1].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[0][2].getPieza(), ficha1.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[0][0]=ficha1;
		tablero.tablero[0][2]=ficha1;
		tablero.actualizarTableroArriba(0, 0, ficha1);				//sinFichaentremedio
		assertEquals(tablero.tablero[0][0].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[0][1],null);
		assertEquals(tablero.tablero[0][2].getPieza(), ficha1.getPieza());
		
		tablero.actualizarTableroArriba(-1, 5, ficha1);	//valors limit(fora taulell)
		tablero.actualizarTableroArriba(8, 5, ficha1);
		tablero.actualizarTableroArriba(3, -1, ficha1);
		tablero.actualizarTableroArriba(3, 8, ficha1);
		
		tablero.actualizarTableroArriba(8, 8, ficha1);
		tablero.actualizarTableroArriba(8, -1, ficha1);
		tablero.actualizarTableroArriba(-1, 8, ficha1);
		tablero.actualizarTableroArriba(-1, -1, ficha1);
		
		
		tablero.actualizarTableroArriba(1, 5, ficha1);	//valors limit(dins taulell)
		tablero.actualizarTableroArriba(6, 5, ficha1);
		tablero.actualizarTableroArriba(3, 1, ficha1);
		tablero.actualizarTableroArriba(3, 6, ficha1);
		
		tablero.actualizarTableroArriba(6, 6, ficha1);
		tablero.actualizarTableroArriba(6, 1, ficha1);
		tablero.actualizarTableroArriba(1, 6, ficha1);
		tablero.actualizarTableroArriba(1, 1, ficha1);
		
	}
	
	@Test
	public void testActualizarTableroArribaIzquierda() {
		Ficha ficha0=new Ficha(0);
		Ficha ficha1=new Ficha(1);
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[4][4]=ficha0;					//ficha sobre la que se trabaja
		tablero.tablero[3][3]=ficha1;					//1 ficha diagonal;
		tablero.actualizarTableroArribaIzquierda(4,4,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][3].getPieza(), ficha1.getPieza());
		
		tablero.tablero[2][2]=ficha0;					//1 ficha entremedio
		tablero.actualizarTableroArribaIzquierda(4,4,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][2].getPieza(), ficha0.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[5][4]=ficha1;						//2fichas diagonal(no estan en medio)
		tablero.tablero[4][3]=ficha0;
		tablero.tablero[3][2]=ficha0;
		tablero.actualizarTableroArribaIzquierda(5,4,ficha1);
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][2].getPieza(), ficha0.getPieza());
		
		tablero.tablero[2][1]=ficha1;							//2fichas entremedio
		tablero.actualizarTableroArribaIzquierda(5,4,ficha1);
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][3].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[3][2].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][1].getPieza(), ficha1.getPieza());
		
		tablero.tablero[7][6]=ficha0;				//sin ficha diagonal
		tablero.actualizarTableroArribaIzquierda(7,6,ficha0);
		assertEquals(tablero.tablero[6][5], null);
		assertEquals(tablero.tablero[7][6].getPieza(), ficha0.getPieza());
		
		tablero.tablero[0][0]=ficha1;					//comprovacion pegado a la esquina
		tablero.actualizarTableroArribaIzquierda(0, 0, ficha1);
		assertEquals(tablero.tablero[0][0].getPieza(), ficha1.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[0][0]=ficha1;
		tablero.tablero[1][1]=ficha0;
		tablero.tablero[2][2]=ficha1;
		tablero.actualizarTableroArribaIzquierda(2, 2, ficha1);		//pegado a la esquina
		assertEquals(tablero.tablero[0][0].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[1][1].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][2].getPieza(), ficha1.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[0][0]=ficha1;
		tablero.tablero[2][2]=ficha1;
		tablero.actualizarTableroArribaIzquierda(0, 0, ficha1);			//sinFichaentremedio
		assertEquals(tablero.tablero[0][0].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[1][1],null);
		assertEquals(tablero.tablero[2][2].getPieza(), ficha1.getPieza());
		
		tablero.actualizarTableroArribaIzquierda(-1, 5, ficha1);	//valors limit(fora taulell)
		tablero.actualizarTableroArribaIzquierda(8, 5, ficha1);
		tablero.actualizarTableroArribaIzquierda(3, -1, ficha1);
		tablero.actualizarTableroArribaIzquierda(3, 8, ficha1);
		
		tablero.actualizarTableroArribaIzquierda(8, 8, ficha1);
		tablero.actualizarTableroArribaIzquierda(8, -1, ficha1);
		tablero.actualizarTableroArribaIzquierda(-1, 8, ficha1);
		tablero.actualizarTableroArribaIzquierda(-1, -1, ficha1);
		
		
		tablero.actualizarTableroArribaIzquierda(1, 5, ficha1);	//valors limit(dins taulell)
		tablero.actualizarTableroArribaIzquierda(6, 5, ficha1);
		tablero.actualizarTableroArribaIzquierda(3, 1, ficha1);
		tablero.actualizarTableroArribaIzquierda(3, 6, ficha1);
		
		tablero.actualizarTableroArribaIzquierda(6, 6, ficha1);
		tablero.actualizarTableroArribaIzquierda(6, 1, ficha1);
		tablero.actualizarTableroArribaIzquierda(1, 6, ficha1);
		tablero.actualizarTableroArribaIzquierda(1, 1, ficha1);
		
	}
	
	@Test
	public void testActualizarTableroArribaDerecha() {
		Ficha ficha0=new Ficha(0);
		Ficha ficha1=new Ficha(1);
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[4][4]=ficha0;					//ficha sobre la que se trabaja
		tablero.tablero[5][3]=ficha1;					//1 ficha diagonal;
		tablero.actualizarTableroArribaDerecha(4,4,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][3].getPieza(), ficha1.getPieza());
		
		tablero.tablero[6][2]=ficha0;					//1 ficha entremedio
		tablero.actualizarTableroArribaDerecha(4,4,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[6][2].getPieza(), ficha0.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[5][4]=ficha0;						//2fichas diagonal(no estan en medio)
		tablero.tablero[4][5]=ficha0;
		tablero.tablero[3][6]=ficha1;
		tablero.actualizarTableroArribaDerecha(3,4,ficha1);
		assertEquals(tablero.tablero[5][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][6].getPieza(), ficha1.getPieza());
		
		tablero.tablero[6][3]=ficha1;							//2fichas entremedio
		tablero.actualizarTableroArribaDerecha(3,6,ficha1);
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[3][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][3].getPieza(), ficha1.getPieza());
		
		tablero.tablero[6][6]=ficha0;				//sin ficha diagonal
		tablero.actualizarTableroArribaDerecha(6,6,ficha0);
		assertEquals(tablero.tablero[7][5], null);
		assertEquals(tablero.tablero[6][6].getPieza(), ficha0.getPieza());
		
		tablero.tablero[7][0]=ficha1;					//comprovacion pegado a la esquina
		tablero.actualizarTableroArribaDerecha(7, 0, ficha1);
		assertEquals(tablero.tablero[7][0].getPieza(), ficha1.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[7][0]=ficha1;
		tablero.tablero[6][1]=ficha0;
		tablero.tablero[5][2]=ficha1;
		tablero.actualizarTableroArribaDerecha(5, 2, ficha1);		//pegado a la esquina
		assertEquals(tablero.tablero[7][0].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][1].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][2].getPieza(), ficha1.getPieza());
	
		tablero.actualizarTableroArribaDerecha(-1, 5, ficha1);	//valors limit(fora taulell)
		tablero.actualizarTableroArribaDerecha(8, 5, ficha1);
		tablero.actualizarTableroArribaDerecha(3, -1, ficha1);
		tablero.actualizarTableroArribaDerecha(3, 8, ficha1);
		
		tablero.actualizarTableroArribaDerecha(8, 8, ficha1);
		tablero.actualizarTableroArribaDerecha(8, -1, ficha1);
		tablero.actualizarTableroArribaDerecha(-1, 8, ficha1);
		tablero.actualizarTableroArribaDerecha(-1, -1, ficha1);
		
		
		tablero.actualizarTableroArribaDerecha(1, 5, ficha1);	//valors limit(dins taulell)
		tablero.actualizarTableroArribaDerecha(6, 5, ficha1);
		tablero.actualizarTableroArribaDerecha(3, 1, ficha1);
		tablero.actualizarTableroArribaDerecha(3, 6, ficha1);
		
		tablero.actualizarTableroArribaDerecha(6, 6, ficha1);
		tablero.actualizarTableroArribaDerecha(6, 1, ficha1);
		tablero.actualizarTableroArribaDerecha(1, 6, ficha1);
		tablero.actualizarTableroArribaDerecha(1, 1, ficha1);

	}
	
	@Test
	public void testActualizarTableroAbajoIzquierda() {
		Ficha ficha0=new Ficha(0);
		Ficha ficha1=new Ficha(1);
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[4][4]=ficha0;					//ficha sobre la que se trabaja
		tablero.tablero[3][5]=ficha1;					//1 ficha diagonal;
		tablero.actualizarTableroAbajoIzquierda(4,4,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][5].getPieza(), ficha1.getPieza());
		
		tablero.tablero[2][6]=ficha0;					//1 ficha entremedio
		tablero.actualizarTableroAbajoIzquierda(4,4,ficha0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][6].getPieza(), ficha0.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[5][4]=ficha1;						//2fichas diagonal(no estan en medio)
		tablero.tablero[4][5]=ficha0;
		tablero.tablero[3][6]=ficha0;
		tablero.actualizarTableroAbajoIzquierda(5,4,ficha1);
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][6].getPieza(), ficha0.getPieza());
		
		tablero.tablero[2][7]=ficha1;							//2fichas entremedio
		tablero.actualizarTableroAbajoIzquierda(5,4,ficha1);
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[3][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][7].getPieza(), ficha1.getPieza());
		
		tablero.tablero[7][6]=ficha0;				//sin ficha diagonal
		tablero.actualizarTableroAbajoIzquierda(7,6,ficha0);
		assertEquals(tablero.tablero[6][7], null);
		assertEquals(tablero.tablero[7][6].getPieza(), ficha0.getPieza());
		
		tablero.tablero[0][7]=ficha1;					//comprovacion pegado a la esquina
		tablero.actualizarTableroAbajoIzquierda(0, 7, ficha1);
		assertEquals(tablero.tablero[0][7].getPieza(), ficha1.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[0][7]=ficha1;
		tablero.tablero[1][6]=ficha0;
		tablero.tablero[2][5]=ficha1;
		tablero.actualizarTableroAbajoIzquierda(2, 5, ficha1);		//pegado a la esquina
		assertEquals(tablero.tablero[0][7].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[1][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][5].getPieza(), ficha1.getPieza());
		
		tablero.actualizarTableroAbajoIzquierda(-1, 5, ficha1);	//valors limit(fora taulell)
		tablero.actualizarTableroAbajoIzquierda(8, 5, ficha1);
		tablero.actualizarTableroAbajoIzquierda(3, -1, ficha1);
		tablero.actualizarTableroAbajoIzquierda(3, 8, ficha1);
		
		tablero.actualizarTableroAbajoIzquierda(8, 8, ficha1);
		tablero.actualizarTableroAbajoIzquierda(8, -1, ficha1);
		tablero.actualizarTableroAbajoIzquierda(-1, 8, ficha1);
		tablero.actualizarTableroAbajoIzquierda(-1, -1, ficha1);
		
		
		tablero.actualizarTableroAbajoIzquierda(1, 5, ficha1);	//valors limit(dins taulell)
		tablero.actualizarTableroAbajoIzquierda(6, 5, ficha1);
		tablero.actualizarTableroAbajoIzquierda(3, 1, ficha1);
		tablero.actualizarTableroAbajoIzquierda(3, 6, ficha1);
		
		tablero.actualizarTableroAbajoIzquierda(6, 6, ficha1);
		tablero.actualizarTableroAbajoIzquierda(6, 1, ficha1);
		tablero.actualizarTableroAbajoIzquierda(1, 6, ficha1);
		tablero.actualizarTableroAbajoIzquierda(1, 1, ficha1);
		
	}
	
	@Test
	public void testActualizarTableroAbajoDerecha() {
		Ficha ficha0=new Ficha(0);
		Ficha ficha1=new Ficha(1);
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[3][4]=ficha0;					//ficha sobre la que se trabaja
		tablero.tablero[4][5]=ficha1;					//1 ficha diagonal;
		tablero.actualizarTableroAbajoDerecha(3,4,ficha0);
		assertEquals(tablero.tablero[3][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha1.getPieza());
		
		tablero.tablero[5][6]=ficha0;					//1 ficha entremedio
		tablero.actualizarTableroAbajoDerecha(3,4,ficha0);
		assertEquals(tablero.tablero[3][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][6].getPieza(), ficha0.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[4][4]=ficha1;						//2fichas diagonal(no estan en medio)
		tablero.tablero[5][5]=ficha0;
		tablero.tablero[6][6]=ficha0;
		tablero.actualizarTableroAbajoDerecha(5,4,ficha1);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[6][6].getPieza(), ficha0.getPieza());
		
		tablero.tablero[7][7]=ficha1;							//2fichas entremedio
		tablero.actualizarTableroAbajoDerecha(4,4,ficha1);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][5].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[7][7].getPieza(), ficha1.getPieza());
		
		tablero.tablero[1][2]=ficha0;				//sin ficha diagonal
		tablero.actualizarTableroAbajoDerecha(1,2,ficha0);
		assertEquals(tablero.tablero[2][3], null);
		assertEquals(tablero.tablero[1][2].getPieza(), ficha0.getPieza());
		
		tablero.tablero[7][7]=ficha1;					//comprovacion pegado a la esquina
		tablero.actualizarTableroAbajoDerecha(7, 7, ficha1);
		assertEquals(tablero.tablero[7][7].getPieza(), ficha1.getPieza());
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[7][7]=ficha1;
		tablero.tablero[6][6]=ficha0;
		tablero.tablero[5][5]=ficha1;
		tablero.actualizarTableroAbajoDerecha(5, 5, ficha1);		//pegado a la esquina
		assertEquals(tablero.tablero[7][7].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][5].getPieza(), ficha1.getPieza());
		
		tablero.actualizarTableroAbajoDerecha(-1, 5, ficha1);	//valors limit(fora taulell)
		tablero.actualizarTableroAbajoDerecha(8, 5, ficha1);
		tablero.actualizarTableroAbajoDerecha(3, -1, ficha1);
		tablero.actualizarTableroAbajoDerecha(3, 8, ficha1);
		
		tablero.actualizarTableroAbajoDerecha(8, 8, ficha1);
		tablero.actualizarTableroAbajoDerecha(8, -1, ficha1);
		tablero.actualizarTableroAbajoDerecha(-1, 8, ficha1);
		tablero.actualizarTableroAbajoDerecha(-1, -1, ficha1);
		
		
		tablero.actualizarTableroAbajoDerecha(1, 5, ficha1);	//valors limit(dins taulell)
		tablero.actualizarTableroAbajoDerecha(6, 5, ficha1);
		tablero.actualizarTableroAbajoDerecha(3, 1, ficha1);
		tablero.actualizarTableroAbajoDerecha(3, 6, ficha1);
		
		tablero.actualizarTableroAbajoDerecha(6, 6, ficha1);
		tablero.actualizarTableroAbajoDerecha(6, 1, ficha1);
		tablero.actualizarTableroAbajoDerecha(1, 6, ficha1);
		tablero.actualizarTableroAbajoDerecha(1, 1, ficha1);
		
	}

	@Test
	public void testcolocarFicha() 
	{
		Ficha ficha0=new Ficha(0);
		Ficha ficha1=new Ficha(1);
		
		for (int i=0;i<8;i++)				//vaciar tablero
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=null;
		
		tablero.tablero[3][3]=ficha1;
		tablero.tablero[4][3]=ficha1;
		tablero.tablero[5][3]=ficha1;
		tablero.tablero[5][4]=ficha1;
		tablero.tablero[5][5]=ficha1;
		tablero.tablero[4][5]=ficha1;
		tablero.tablero[3][5]=ficha1;
		tablero.tablero[3][4]=ficha1;
		
		
		tablero.tablero[2][2]=ficha0;
		tablero.tablero[4][2]=ficha0;
		tablero.tablero[6][2]=ficha0;
		tablero.tablero[6][4]=ficha0;
		tablero.tablero[6][6]=ficha0;
		tablero.tablero[4][6]=ficha0;
		tablero.tablero[2][6]=ficha0;
		tablero.tablero[2][3]=ficha0;
		
		//test on coloquem una ficha i totes les del seu voltant s'han de girar.
		boolean res_0=tablero.colocarFicha(4, 4, 0);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
		
		assertEquals(tablero.tablero[3][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][4].getPieza(), ficha0.getPieza());
		
		assertEquals(tablero.tablero[2][2].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][2].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[6][2].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[6][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[6][6].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][6].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][6].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][3].getPieza(), ficha0.getPieza());
	
		assertEquals(res_0, true);
		
		//test intentem colocar una ficha a un posicio que no pot per que ja es plena
		boolean res_1=tablero.colocarFicha(4,4,1);
		
		assertEquals(res_1,false);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha0.getPieza());
	
		assertEquals(tablero.tablero[3][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][3].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[5][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][5].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[3][4].getPieza(), ficha0.getPieza());
		
		assertEquals(tablero.tablero[2][2].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][2].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[6][2].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[6][4].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[6][6].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[4][6].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][6].getPieza(), ficha0.getPieza());
		assertEquals(tablero.tablero[2][3].getPieza(), ficha0.getPieza());
		
		
		tablero.tablero[3][3]=ficha0;
		tablero.tablero[4][3]=ficha0;
		tablero.tablero[5][3]=ficha0;
		tablero.tablero[5][4]=ficha0;
		tablero.tablero[5][5]=ficha0;
		tablero.tablero[4][5]=ficha0;
		tablero.tablero[3][5]=ficha0;
		tablero.tablero[3][4]=ficha0;
		
		
		tablero.tablero[2][2]=ficha1;
		tablero.tablero[4][2]=ficha1;
		tablero.tablero[6][2]=ficha1;
		tablero.tablero[6][4]=ficha1;
		tablero.tablero[6][6]=ficha1;
		tablero.tablero[4][6]=ficha1;
		tablero.tablero[2][6]=ficha1;
		tablero.tablero[2][3]=ficha1;
		
		//el mateix que el primer test pero amb l'altre tipus de ficha
		boolean res_2=tablero.colocarFicha(4, 4, 1);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha1.getPieza());
		
		assertEquals(tablero.tablero[3][3].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][3].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][3].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][5].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[3][5].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[3][4].getPieza(), ficha1.getPieza());
		
		assertEquals(tablero.tablero[2][2].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][2].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][2].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][3].getPieza(), ficha1.getPieza());
		
		assertEquals(res_2, false);
		
		//al mateix que al segon test pero amb l'altre tipus de ficha
		boolean res_3=tablero.colocarFicha(4,4,0);
		
		assertEquals(res_3,false);
		assertEquals(tablero.tablero[4][4].getPieza(), ficha1.getPieza());
		
		assertEquals(tablero.tablero[3][3].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][3].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][3].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[5][5].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][5].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[3][5].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[3][4].getPieza(), ficha1.getPieza());
		
		assertEquals(tablero.tablero[2][2].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][2].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][2].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][4].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[6][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[4][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][6].getPieza(), ficha1.getPieza());
		assertEquals(tablero.tablero[2][3].getPieza(), ficha1.getPieza());
		
		//intentem colocar ficha amb el taulell ple
		tablero.posiciones_libres=0;
		boolean res_4=tablero.colocarFicha(0,0,0);
		assertEquals(res_4, false);
		
		//valors frontera fora taulell
		boolean res_5=tablero.colocarFicha(-1, 3, 0);
		boolean res_6=tablero.colocarFicha(8, 4, 0);
		boolean res_7=tablero.colocarFicha(8, 8, 0);
		boolean res_8=tablero.colocarFicha(-1, -1, 0);
		boolean res_9=tablero.colocarFicha(6, 8, 0);
		boolean res_10=tablero.colocarFicha(5, -1, 0);
		boolean res_11=tablero.colocarFicha(-1, 8, 0);
		boolean res_12=tablero.colocarFicha(8, -1, 0);
		
		//valors frontera dins taulell
		boolean res_13=tablero.colocarFicha(1, 3, 0);
		boolean res_14=tablero.colocarFicha(6, 4, 0);
		boolean res_15=tablero.colocarFicha(6, 6, 0);
		boolean res_16=tablero.colocarFicha(1, 1, 0);
		boolean res_17=tablero.colocarFicha(6, 6, 0);
		boolean res_18=tablero.colocarFicha(5, 1, 0);
		boolean res_19=tablero.colocarFicha(1, 1, 0);
		boolean res_20=tablero.colocarFicha(6, 1, 0);
		boolean res_21=tablero.colocarFicha(1, 6, 0);
		
		assertEquals(res_5,false);
		assertEquals(res_6,false);
		assertEquals(res_7,false);
		assertEquals(res_8,false);
		assertEquals(res_9,false);
		assertEquals(res_10,false);
		assertEquals(res_11,false);
		assertEquals(res_12,false);
		assertEquals(res_13,false);
		assertEquals(res_14,false);
		assertEquals(res_15,false);
		assertEquals(res_16,false);
		assertEquals(res_17,false);
		assertEquals(res_18,false);
		assertEquals(res_19,false);
		assertEquals(res_20,false);
		assertEquals(res_21,false);
		
		//valors limit
		boolean res_22=tablero.colocarFicha(0, 3, 0);
		boolean res_23=tablero.colocarFicha(7, 4, 0);
		boolean res_24=tablero.colocarFicha(3, 0, 0);
		boolean res_25=tablero.colocarFicha(4, 7, 0);
		boolean res_26=tablero.colocarFicha(7, 7, 0);
		boolean res_27=tablero.colocarFicha(0, 0, 0);
		boolean res_28=tablero.colocarFicha(7, 0, 0);
		boolean res_29=tablero.colocarFicha(0, 7, 0);
		
		assertEquals(res_22,false);
		assertEquals(res_23,false);
		assertEquals(res_24,false);
		assertEquals(res_25,false);
		assertEquals(res_26,false);
		assertEquals(res_27,false);
		assertEquals(res_28,false);
		assertEquals(res_29,false);
		
	}
	
	@Test
	public void toStringTest() {
		assertEquals(
				"     A   B   C   D   E   F   G   H  \n" +
				"    ------------------------------- \n" +
				" 1 |   |   |   |   |   |   |   |   |\n" +
				"   |-------------------------------|\n" +
				" 2 |   |   |   |   |   |   |   |   |\n" +
				"   |-------------------------------|\n" +
				" 3 |   |   |   |   |   |   |   |   |\n" +
				"   |-------------------------------|\n" +
				" 4 |   |   |   | X | O |   |   |   |\n" +
				"   |-------------------------------|\n" +
				" 5 |   |   |   | O | X |   |   |   |\n" +
				"   |-------------------------------|\n" +
				" 6 |   |   |   |   |   |   |   |   |\n" +
				"   |-------------------------------|\n" +
				" 7 |   |   |   |   |   |   |   |   |\n" +
				"   |-------------------------------|\n" +
				" 8 |   |   |   |   |   |   |   |   |\n" +
				"    ------------------------------- \n",
				tablero.toString());
		for (int i=0;i<8;i++)								//Llenar tablero de Fichas de jugador 1
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=new Ficha(0);
		

		assertEquals(
				"     A   B   C   D   E   F   G   H  \n" +
				"    ------------------------------- \n" +
				" 1 | X | X | X | X | X | X | X | X |\n" +
				"   |-------------------------------|\n" +
				" 2 | X | X | X | X | X | X | X | X |\n" +
				"   |-------------------------------|\n" +
				" 3 | X | X | X | X | X | X | X | X |\n" +
				"   |-------------------------------|\n" +
				" 4 | X | X | X | X | X | X | X | X |\n" +
				"   |-------------------------------|\n" +
				" 5 | X | X | X | X | X | X | X | X |\n" +
				"   |-------------------------------|\n" +
				" 6 | X | X | X | X | X | X | X | X |\n" +
				"   |-------------------------------|\n" +
				" 7 | X | X | X | X | X | X | X | X |\n" +
				"   |-------------------------------|\n" +
				" 8 | X | X | X | X | X | X | X | X |\n" +
				"    ------------------------------- \n",
				tablero.toString());
		
		for (int i=0;i<8;i++)								//Llenar tablero de Fichas de jugador 2
			for(int j=0;j<8;j++)
				tablero.tablero[i][j]=new Ficha(1);
		assertEquals(
				"     A   B   C   D   E   F   G   H  \n" +
				"    ------------------------------- \n" +
				" 1 | O | O | O | O | O | O | O | O |\n" +
				"   |-------------------------------|\n" +
				" 2 | O | O | O | O | O | O | O | O |\n" +
				"   |-------------------------------|\n" +
				" 3 | O | O | O | O | O | O | O | O |\n" +
				"   |-------------------------------|\n" +
				" 4 | O | O | O | O | O | O | O | O |\n" +
				"   |-------------------------------|\n" +
				" 5 | O | O | O | O | O | O | O | O |\n" +
				"   |-------------------------------|\n" +
				" 6 | O | O | O | O | O | O | O | O |\n" +
				"   |-------------------------------|\n" +
				" 7 | O | O | O | O | O | O | O | O |\n" +
				"   |-------------------------------|\n" +
				" 8 | O | O | O | O | O | O | O | O |\n" +
				"    ------------------------------- \n",
				tablero.toString());
	}

}

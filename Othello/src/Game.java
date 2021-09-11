import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

	int playerTurn;
	Tablero tablero;
	
	public Game() {
		playerTurn = 0;
		tablero = new Tablero();
	}

	public void Play() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean jugadaAceptada;
		String read = null;
		int ganador;
		
		System.out.println(" Iniciando partida");
		
		while (!tablero.estaLleno() && tablero.quedanMovimientos(playerTurn)) {
			jugadaAceptada=false;
			System.out.println(tablero);
			if (playerTurn == 0) {
				System.out.println(" Turno del jugador 1 (X)");
			} else {
				System.out.println(" Turno del jugador 2 (O)");
			}
			System.out.println(" Indique en que posicion desea colocar su ficha (Ej.: F4): ");
			
			do {
				try {
					read = br.readLine();
				} catch (IOException e) {
					System.out.println(" Ha ocurrido un error al leer los datos, por favor vuelvalo a intentar:");
				}
				jugadaAceptada = hacerJugada(read);
				if (!jugadaAceptada) {
					System.out.println(" No se puede colocar una ficha en la posicion indicada, por favor elija otra posicion: ");
				}
			} while(!jugadaAceptada);
		}
		System.out.println(tablero);
		ganador = tablero.checkWin();
		if (!tablero.estaLleno()) {
			System.out.println(" No quedan movimientos posibles");
		}
		if (ganador == 0) {
			System.out.println(" Ha ganado el jugador 1 con las (X)");
		} else if (ganador == 1) {
			System.out.println(" Ha ganado el jugador 2 con las (O)");
		} else if (ganador==-1) {
			System.out.println(" Ha habido un empate, no hay ni ganador ni perdedor");
		}
		System.out.println(" Aprieta Enter para volver a jugar");
		try {
			br.readLine();
		} catch (IOException e) {}
	}
	
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public boolean hacerJugada(String jugada) {
		boolean jugadaValida=false;
		int fila, columna;
		if (jugada.length() == 2) {
			 char col = jugada.charAt(0);
			 col = Character.toLowerCase(col);
			 columna = col - 97;
			 try {
				 fila = Integer.parseInt(jugada.substring(1,2));
			 } catch (NumberFormatException e) {
				 fila = -1;
			 }
			 fila -= 1;
			 jugadaValida = tablero.colocarFicha(fila, columna, playerTurn);
		}
		if (jugadaValida) {
			if (playerTurn == 0)
				playerTurn=1;
			else
				playerTurn=0;
		}
		return jugadaValida;
	}
	
}

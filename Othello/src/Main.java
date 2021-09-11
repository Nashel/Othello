import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static Game game;
	
	public static void main(String[] args) {
		
		game = new Game();
		
		int opcion=0;
		
		while (opcion!=2) {
			opcion = menu();
		
			if (opcion == 1) {
				game.Play();
			}
		}
		System.out.println(" Hasta pronto");

	}

	public static int menu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String read;
		int res=0;

		System.out.println(" Bienvenido al juego de Othello");
		
		do {
			System.out.println(" --------------Menu--------------");
			System.out.println(" 1-. Partida contra otro jugador");
			System.out.println(" 2-. Salir");
			System.out.println(" Por favor introduzca una de las opciones: ");
			
			try {
				read = br.readLine();
				res = Integer.parseInt(read);
				
				if (res<1 || res>2) {
					System.out.println(" Por favor introduzca uno de los números indicados en el menu\n");
				}
			}
			catch (NumberFormatException e) {
				System.out.println(" Por favor introduzca uno de los números indicados en el menu\n");
			}
			catch (IOException e) {
				System.out.println(" Ha ocurrido un error al leer los datos, por favor vuelvalo a intentar\n");
			}
		} while (res < 1 && res > 2);
		return res;
	}
}

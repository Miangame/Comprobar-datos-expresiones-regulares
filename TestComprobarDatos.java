package listadoEstructuras3.listadoExpresionesRegulares.ejercicio19;

import utiles.Menu;
import utiles.Teclado;

/**
 * Implementa un program a que permit a comprobar cada un o de estos datos
 * mediante expresiones regulares: a. Dirección MAC b. Dirección IP c. Correo
 * electrónico d. Código postal e. Número de cuenta corriente f. DNI Para ello,
 * solicita al usuario tres entradas distintas, dejando claro el patrón que vas
 * a utilizar. Por ejemplo : Introduce una dirección MAC (XX:XX:XX:XX:XX:XX) La
 * dirección NO es correcta.
 * 
 * @author Miguel Ángel Gavilán Merino
 *
 */
public class TestComprobarDatos {

	public static void main(String[] args) {
		String[] opciones = { "Direcciones MAC", "Direcciones IP", "Correo electrónico", "Código postal",
				"Cuenta corriente", "DNI", "Salir" };
		Menu menu = new Menu("\n---Test para comprobar datos---", opciones);

		int opcion;

		do {
			opcion = menu.gestionar();

			switch (opcion) {

			case 1:
				comprobarDireccionMAC();
				break;

			case 2:
				comprobarIP();
				break;

			case 3:
				comprobarCorreo();
				break;

			case 4:
				comprobarCP();
				break;

			case 5:
				comprobarCuenta();
				break;

			case 6:
				comprobarDNI();
				break;

			default:
				System.out.println("\nSALIENDO...");
				break;
			}
		} while (opcion != 7);
	} // main()

	/**
	 * Comprueba que un DNI sea válido
	 */
	private static void comprobarDNI() {
		if (Regex.DNI
				.comprobar(Teclado.leerCadena("\nIntroduce el DNI a validar " + Regex.DNI.getCadenaUsuario() + ": "))) {
			System.out.println("\nEl DNI es correcto.");
		} else {
			System.err.println("El DNI NO es correcto.\n");
		}

	}

	/**
	 * Comprueba que un número de cuenta sea válido
	 */
	private static void comprobarCuenta() {
		if (Regex.CUENTA_BANCO.comprobar(Teclado.leerCadena(
				"\nIntroduce la cuenta bancaria a validar " + Regex.CUENTA_BANCO.getCadenaUsuario() + ": "))) {
			System.out.println("\nLa cuenta bancaria es correcta.");
		} else {
			System.err.println("La cuenta bancaria NO es correcta.\n");
		}

	}

	/**
	 * Comprueba que un Código postal sea válido
	 */
	private static void comprobarCP() {
		if (Regex.CP.comprobar(
				Teclado.leerCadena("\nIntroduce el código postal a validar " + Regex.CP.getCadenaUsuario() + ": "))) {
			System.out.println("\nEl código postal es correcto.");
		} else {
			System.err.println("El código postal NO es correcto.\n");
		}

	}

	/**
	 * Comprueba que una dirección de correo sea válida
	 */
	private static void comprobarCorreo() {
		if (Regex.CORREO_ELECTRONICO.comprobar(Teclado
				.leerCadena("\nIntroduce el correo a validar " + Regex.CORREO_ELECTRONICO.getCadenaUsuario() + ": "))) {
			System.out.println("\nLa dirección de correo es correcta.");
		} else {
			System.err.println("La dirección de correo NO es correcta.\n");
		}

	}

	/**
	 * Comprueba que una IP sea válida e indica su clase
	 */
	private static void comprobarIP() {
		String cadena = Teclado.leerCadena("\nIntroduce la IP a validar " + Regex.IP.getCadenaUsuario() + ": ");

		String[] arrayNumeros = cadena.split("\\.");
		int[] numeros = new int[arrayNumeros.length];

		for (int i = 0; i < arrayNumeros.length; i++) {
			numeros[i] = Integer.parseInt(arrayNumeros[i]);
		}

		if (Regex.IP.comprobar(cadena)) {
			if (numeros[0] >= 0 && numeros[0] <= 127) {
				System.out.println("La dirección IP es válida y de clase A");
			} else if (numeros[0] > 127 && numeros[0] <= 191) {
				System.out.println("La dirección IP es válida y de clase B");
			} else if (numeros[0] > 191 && numeros[0] <= 223) {
				System.out.println("La dirección IP es válida y de clase C");
			} else if (numeros[0] > 223 && numeros[0] <= 239) {
				System.out.println("La dirección IP es válida y de clase D");
			} else {
				System.out.println("La dirección IP es válida y de clase E");
			}
		} else {
			System.err.println("La dirección IP NO es correcta.\n");
		}

	}

	/**
	 * Comrprueba que una direccion MAC sea válida
	 */
	private static void comprobarDireccionMAC() {
		if (Regex.MAC
				.comprobar(Teclado.leerCadena("\nIntroduce el MAC a validar " + Regex.MAC.getCadenaUsuario() + ": "))) {
			System.out.println("\nLa dirección MAC es correcta.");
		} else {
			System.err.println("La dirección MAC NO es correcta.\n");
		}
	}

}

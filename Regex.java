package listadoEstructuras3.listadoExpresionesRegulares.ejercicio19;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regex {
	DNI("^\\d{8}[A-Z&&[^IÑOU]]$", "(00000000X)"), CUENTA_BANCO(
			"^([a-zA-Z]{2}\\d\\d)?[\\.-:\\s]?\\d{4}[\\.-:\\s]\\d{4}[\\.-:\\s]?\\d{2}[\\.-:\\s]?\\d{10}$",
			"(AB00 0000 0000 00 0000000000)"), CP("^(0[1-9]|[1-4][0-9]|5[0-2])[0-9]{3}$",
					"(00000)"), CORREO_ELECTRONICO("^([\\w\\.])+@[\\w\\.]+\\.[a-z]{2,3}$", "(xxxx@xxxx.xxx)"), IP(
							"^(([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$",
							"(XXX.XXX.XXX.XXX)"), MAC("^((\\d|[a-fA-F]){2}(:|-)){5}((\\d|[a-fA-F]){2})$",
									"(XX:XX:XX:XX:XX:XX)");

	/**
	 * Guarda una expresión regular
	 */
	private String regex;

	/**
	 * Guarda un mensaje para el usuario
	 */
	private String cadenaUsuario;

	private Regex(String regex, String cadenaUsuario) {
		setRegex(regex);
		setCadenaUsuario(cadenaUsuario);
	}

	String getRegex() {
		return regex;
	}

	private void setRegex(String regex) {
		this.regex = regex;
	}

	String getCadenaUsuario() {
		return cadenaUsuario;
	}

	private void setCadenaUsuario(String cadenaUsuario) {
		this.cadenaUsuario = cadenaUsuario;
	}

	/**
	 * Busca si la cadena pasada por argumentos se encuentra en la expresión
	 * regular
	 * 
	 * @param cadena
	 *            Cadena para encontrar si es válida o no
	 * @return True si encuentra coincidencia, false si no la encuentra
	 */
	private boolean regex(String cadena) {
		Pattern pattern = Pattern.compile(getRegex());
		Matcher matcher = pattern.matcher(cadena);
		return matcher.find();
	}

	/**
	 * Llama al método regex()
	 * 
	 * @param cadena
	 *            Cadena para validarla
	 * @return True si encuentra coincidencia, false si no la encuentra
	 */
	boolean comprobar(String cadena) {
		return regex(cadena);
	}

}

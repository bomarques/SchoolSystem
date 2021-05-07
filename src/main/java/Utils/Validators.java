package Utils;

/**
 * Classe utilizda para definir métodos 
 * @author Senior
 *
 */
public class Validators {
	
	/**
	 * Verifica se há caracteres não alfanuméricos
	 * @param verify string a ser verificada
	 * @return boolean
	 */
	static public boolean onlyValidChars(String verify){
		return verify.matches(".*[0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\"
				+ "/?]+.*");
	}

}

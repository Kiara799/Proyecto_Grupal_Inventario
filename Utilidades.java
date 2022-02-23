package inventarioapp;

/**
 * Clase para definir algunos metodos de utilidad
 * 
 * @author
 */
public class Utilidades {
    // metodo para validar una cedula utilizando el digito verificador
    // y la suma de digitos pares e impares
    // mas informacion: 
    // http://blog.espol.edu.ec/ccpg1001/files/2015/04/SolPy_2Eva_IT2008_T2.pdf
    // https://www.alexastudillo.com/2020/10/validar-una-cedula-ecuatoriana-java.html
    // 
    public static boolean esCedulaValida(String cedula) {
        // una cedula tiene 10 digitos
        if (cedula.length() != 10) {
            return false;
        }
        
        // verificar que todos los caracteres sean digitos
        for (int i = 0; i < cedula.length(); i++) {
            if (!Character.isDigit(cedula.charAt(i))) {
                return false;
            }
        }
        
        int sumaPares = 0;
        int sumaImpares = 0;
        
        for (int i = 0; i < cedula.length() - 1; i++) {
            int digito = Character.getNumericValue(cedula.charAt(i));
            
            if ((i + 1) % 2 == 0) {
                sumaPares += digito;
            } else {
                int valor = digito * 2;
                
                if (valor > 9) {
                    valor -= 9;
                }
                
                sumaImpares += valor;
            }
        }
        
        int total = sumaPares + sumaImpares;
        int superior = (10 - (total % 10)) + total;
        int verificador = Character.getNumericValue((cedula.charAt(cedula.length() - 1)));
        
        if ((total % 10) == 0) {
            return verificador == 0;
        }
        
        return verificador == (superior - total);
    }
}

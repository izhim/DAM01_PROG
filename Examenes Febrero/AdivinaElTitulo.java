/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Trabajas en una editorial de material educativo y te encargan que programes un juego para que el
alumnado practique literatura, concretamente el título de libros.
La idea es presentar al alumno unos títulos de libros a los que les faltan palabras y dejarle tiempo para
pensar, cuando el alumno pulse la tecla [enter] el programa le desvelará la solución.
Para que entiendas mejor el enunciado, el director de contenidos de la editorial te hace un boceto de
lo que quiere como entrada:

    Un duendecillo se ha llevado algunas palabras de los títulos de libros famosos
    ¿Serías capaz de adivinar los títulos ocultos?
    ----------------------------------------------
    Don @ de la @
    El @ del @
    Las @ y una @
    Los @ de la @
    El @ no tiene quien le @
    ----------------------------------------------
    Pulsa [Enter] para desvelar el enigma

...y lo que le gustaría que apareciera como salida:

    Solución al enigma
    ----------------------------------------------
    Don Quijote de la Mancha
    El perro del hortelano
    Las mil y una noches
    Los pilares de la tierra
    El Coronel no tiene quien le escriba
    ----------------------------------------------
    ¿Cuantos habías acertado?

Otro programador ya ha hecho la parte de la entrada y la salida y te ha dejado a ti el procesamiento.
Los datos de entrada están en un array de cadenas, donde en cada fila aparece el titulo del libro con dos
palabras sustituidas por el símbolo “@” y, separadas por el símbolo “/”, las palabras que faltan en el orden
de aparición. Por ejemplo, el primer elemento del array es “Don @ de la @/Quijote/Mancha".
Debes completar el programa para que a partir del array de datos de entrada, se genere el array de salida
como un array de cadenas con los títulos completos.
Ayuda: deberás utilizar una expresión regular con grupos y manejar (métodos) de las clases String y
SringBuilder, ya sabes que para buscar la documentación de la API puedes poner en Google “API java JDK
11 <nombre de la clase>” y te llevará a la documentación oficial de esa clase.
*/

package examenfeb21_1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author JOSE
 */
public class AdivinaElTitulo {
    
    //  CONSTANTES DE CLASE
    private static final String[] ENIGMAS = {
        "Don @ de la @/Quijote/Mancha",
        "El @ del @/perro/hortelano",
        "Las @ y una @/mil/noches",
        "Los @ de la @/pilares/tierra",
        "El @ no tiene quien le @/Coronel/escriba"
        };
    
    //  VARIABLES DE OBJETO
    private String[] resultado = new String[ENIGMAS.length];
    
    //  CONSTRUCTOR 1 PARÁMETRO
    public AdivinaElTitulo(int posicion){
        String[] cadenas = ENIGMAS[posicion].split("[@/]+");
        StringBuilder resultado = new StringBuilder(cadenas[0]);
        resultado.append(cadenas[2]);
        resultado.append(cadenas[1]);
        resultado.append(cadenas[3]);
        this.resultado[posicion] = resultado.toString();
    }
    
    //  MÉTODOS DE CLASE
    public static String getEnigmas(int cont) {
        return AdivinaElTitulo.ENIGMAS[cont];
    }
    
    //  MÉTODO TOSTRING
    public String toString(int cont){
        return(this.resultado[cont]);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        String entrada;
        
        System.out.println("¿Serías capaz de adivinar los títulos ocultos?");
        System.out.println("----------------------------------------------");
        AdivinaElTitulo[] adivina = new AdivinaElTitulo[ENIGMAS.length];
        for(int cont = 0; cont < adivina.length; cont++){
            System.out.println(getEnigmas(cont));
        }
        System.out.println("----------------------------------------------");
        System.out.println("Pulsa [Enter] para revelar el enigma");
        entrada = sc.nextLine();
        System.out.println("Solución al enigma");
        System.out.println("----------------------------------------------");
        for(int cont = 0; cont < adivina.length; cont++){
            adivina[cont] = new AdivinaElTitulo(cont);
            System.out.println(adivina[cont].toString(cont));
        }
    }
}

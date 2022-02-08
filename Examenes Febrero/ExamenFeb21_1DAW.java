/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Crea un programa en Java para leer siete números reales y comprobar que
estén en el intervalo [-100, -50] o bien en el [60, 200]
 El programa debe iterar mediante un bucle.
 Se deben controlar las excepciones ante posibles lecturas de datos no válidos como caracteres
alfanuméricos en vez de números.
 Si el número real leído está en uno de los dos rangos permitidos, se contabilizará como tal, se
escribirán el total de números contabilizados en los intervalos hasta ahora y se escribirá por
consola con dos decimales, tal y como se puede ver más abajo.
 Tras salir del bucle se escribirá por consola el total de números válidos (que estén en uno de los
rangos permitidos) leídos.
Ejemplo de ejecución:

    Leer 7 números reales y comprobar que estén en el intervalo [-100, -50] o bien en el [60, 200]
    ----------------------------------------------------------------------------------------------
    Introduzca un número real que esté en el intervalo [-100, -50] o bien en el [60, 200]
    10
    Incorrecto. Número descartado. Total de números reales válidos hasta ahora: 0
    Introduzca un número real que esté en el intervalo [-100, -50] o bien en el [60, 200]
    x
    Número no válido.
    Incorrecto. Número descartado. Total de números reales válidos hasta ahora: 0
    Introduzca un número real que esté en el intervalo [-100, -50] o bien en el [60, 200]
    60
    Correcto. Total de números reales válidos hasta ahora: 1
    El último número que acabamos de leer es el: 60,00
    Introduzca un número real que esté en el intervalo [-100, -50] o bien en el [60, 200]
    -50
    Correcto. Total de números reales válidos hasta ahora: 2
    El último número que acabamos de leer es el: -50,00
    Introduzca un número real que esté en el intervalo [-100, -50] o bien en el [60, 200]
    -101
    Incorrecto. Número descartado. Total de números reales válidos hasta ahora: 2
    Introduzca un número real que esté en el intervalo [-100, -50] o bien en el [60, 200]
    201
    Incorrecto. Número descartado. Total de números reales válidos hasta ahora: 2
    Introduzca un número real que esté en el intervalo [-100, -50] o bien en el [60, 200]
    200
    Correcto. Total de números reales válidos hasta ahora: 3
    El último número que acabamos de leer es el: 200,00
    Total de números válidos leídos: 3
*/

package examenfeb21_1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author JOSE
 */
public class ExamenFeb21_1DAW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //  CONSTANTES
        final int CANT_NUMEROS = 5;
        final float CANT_MINIMA = 100;
        final float CANT_MAXIMA = 200;
        
        //  VARIABLES
        float[] resultado = new float[CANT_NUMEROS];
        Scanner sc = new Scanner(System.in);
        float suma = 0;
        int cantCorrectos = 0;
        
        for(int cont = 0; cont < CANT_NUMEROS; cont++){
            do{
                try{
                    System.out.printf("Por favor, introduzca un número entero real entre %.2f y %.2f: ",
                            CANT_MINIMA, CANT_MAXIMA);
                    resultado[cont] = sc.nextFloat();
                    if(resultado[cont] < CANT_MINIMA || resultado[cont] > CANT_MAXIMA)
                        System.out.println("Número no válido.");
                    else{
                        cantCorrectos ++;
                        System.out.printf("El último número que acabamos de leer es: %.2f \n", resultado[cont]);
                        suma += resultado[cont];
                    }
                    System.out.println("Total de números reales válidos hasta ahora: " + cantCorrectos);
                }catch(InputMismatchException ex){
                    System.out.println("El dato introducido no es un número");
                    sc.next();
                }
            }while(resultado[cont] < CANT_MINIMA || resultado[cont] > CANT_MAXIMA);
        }
        System.out.printf("Suma total: %.2f\n", suma);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
De uno en uno.
Este es un ejercicio donde trabajarás con arrays, por lo que se espera que, si la ocasión lo requiere, uses un
bucle para operar con el array.
Para empezar, rellena un array de tamaño 5 con un valor numérico proporcionado por teclado. Todos los
elementos del array se rellenarán con el mismo valor, que deberá ser mayor de 0. Por ejemplo, si el usuario
introduce el valor 4, la configuración inicial del array de tamaño 5 sería:

    Introduce un número mayor de 0: 4
    Configuración inicial del array:
    4 4 4 4 4

Pero, si el usuario no introduce un número mayor de 0, el programa terminará con un mensaje amigable
indicando al usuario el problema encontrado. Ten en cuenta el caso de que se introduzca accidentalmente
un valor no numérico. Por ejemplo:

    Introduce un número mayor de 0: cinco
    El número insertado no es válido y se aborta la ejecución.
    Introduce un número mayor de 0: 0
    El número insertado no es válido y se aborta la ejecución.

Si el número introducido por el usuario es correcto se realizará el siguiente proceso exactamente 10 veces:
1º) Se elegirá un número al azar entre 1 y 4 usando la siguiente fórmula:
1+(int)(Math.random()*4)
Ese número corresponderá con una posición del array.
2º) Dada la posición anterior, obtenida aleatoriamente, se restará uno al número entero almacenado
en dicha posición y se sumará uno al elemento en la posición 0. Por ejemplo:

    Introduce un número mayor de 0: 4
    Configuración inicial del array:
    4 4 4 4 4
    Iteración 1) Se quitará 1 de la posición con índice 2.
    5 4 3 4 4

En el ejemplo anterior la posición elegida al azar es la que tiene el índice 2, se le ha restado 1 (pasando de
4 a 3) y se le ha sumado 1 a la posición con índice 0 (pasando de 4 a 5).
Importante: tendrás que tener cuidado dado que ningún elemento del array deberá ser menor a 0 en ningún
caso. Si el elemento elegido al azar contiene un 0, el array no se modificará, y se mostrará un mensaje
como el siguiente:
    ...
    Iteración 7) Se quitará 1 de la posición con índice 1.
    12 4 2 3 0
    Iteración 8) Se ha elegido la posición con índice 4 pero está a 0.
    12 4 2 3 0
    ...
Por último, ten en cuenta que los números contenidos en el array deberán mostrarse siempre separados por
un único espacio. Un ejemplo de ejecución es el siguiente:

    Introduce un número mayor de 0: 3
    Configuración inicial del array:
    3 3 3 3 3
    Iteración 1) Se quitará 1 de la posición con índice 1.
    4 2 3 3 3
    Iteración 2) Se quitará 1 de la posición con índice 4.
    5 2 3 3 2
    Iteración 3) Se quitará 1 de la posición con índice 4.
    6 2 3 3 1
    Iteración 4) Se quitará 1 de la posición con índice 2.
    7 2 2 3 1
    Iteración 5) Se quitará 1 de la posición con índice 1.
    8 1 2 3 1
    Iteración 6) Se quitará 1 de la posición con índice 1.
    9 0 2 3 1
    Iteración 7) Se quitará 1 de la posición con índice 4.
    10 0 2 3 0
    Iteración 8) Se ha elegido la posición con índice 1 pero está a 0.
    10 0 2 3 0
    Iteración 9) Se quitará 1 de la posición con índice 2.
    11 0 1 3 0
    Iteración 10) Se ha elegido la posición con índice 4 pero está a 0.
    11 0 1 3 0
*/

package examenfeb21_1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author JOSE
 */
public class ExamenFeb20_3DAW {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //  CONSTANTES
        final int DIMENSION_ARRAY = 5;
        final int REPETICIONES = 10;
        
        //  VARIABLES
        int valor, posArray;
        int[] array_datos = new int[DIMENSION_ARRAY];
        Scanner sc = new Scanner(System.in);
        
        //  PROCESAMIENTO
        System.out.print("Introduce un número mayor que 0: ");
        try{
            valor = sc.nextInt();
            if(valor <= 0){
                System.out.println("Error: Número no válido. Se aborta la ejecución.");
            }else{
                for(int cont = 0; cont < array_datos.length; cont++){
                    array_datos[cont] = valor;
                }
                System.out.println("Configuración inicial del array: ");
                System.out.println(array_datos.toString());
                for(int cont = 0; cont < REPETICIONES; cont++){
                    posArray = 1+(int)(Math.random()*4);
                    System.out.printf("Iteracción %d: Se quitará 1 de la posición con índice %d.\n",
                                        cont + 1, posArray);
                    if(array_datos[posArray-1] == 0)
                        System.out.printf("Se ha elegido la posición con índice %d pero está a 0.\n", posArray);
                    else{
                        array_datos[posArray-1]--;
                        array_datos[0]++;
                    }
                    System.out.println(Arrays.toString(array_datos));
                }    
            }
        }catch(InputMismatchException ex){
            System.out.println("Error: Formato no válido. Se aborta la ejecución");
        }
    }
}

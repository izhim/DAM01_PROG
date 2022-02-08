/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Repartidor de caracteres.
Este ejercicio consiste en hacer un programa que "reparta" los caracteres de una cadena de forma
aleatoria en otras 5 cadenas almacenadas en un array. Éste es un ejercicio donde trabajarás con arrays,
por lo que se espera que, si la ocasión lo requiere, uses un bucle para operar con el array.
1º) Lee una cadena de tamaño 5 o superior. Si la cadena no cumple el criterio esperado, deberás volver a
leerla:
Introduce una cadena de al menos 5 caracteres: asdf
La cadena introducida no tiene 5 caracteres.
Introduce una cadena de al menos 5 caracteres: abcdefghijk
2º) Crea un array de cadenas y rellénalo con 5 cadenas vacías (esto es importante).
3º) Realiza el reparto de caracteres usando un bucle que permita recorrer uno a uno todos los caracteres
de la cadena leída por teclado.
En cada iteración deberás elegir al azar una de las 5 cadenas del array. Para ello, puedes ayudarte de la
siguiente fórmula:
                        (int)(Math.random()*5)
En la cadena del array elegida al azar deberás concatenar el carácter que corresponda de la cadena leída
por teclado. Por ejemplo:

    Introduce una cadena de al menos 5 caracteres: abcdefghijk
    Carácter posición 0 va al String en la posición 1 del array.
    [] [a] [] [] []
    Carácter posición 1 va al String en la posición 4 del array.
    [] [a] [] [] [b]

En el ejemplo anterior, el primer carácter ('a') se concatena a la cadena en la posición 1 del array, y el
segundo carácter ('b') se concatena a la cadena en la posición 4 del array. Siempre la cadena del array
donde se concatenará cada carácter será elegida al azar, como ya se ha comentado antes.
Este proceso acabará cuando todos los caracteres de la cadena leída por teclado hayan sido concatenados
a alguna de las cadenas del array.
Las cadenas almacenadas en el array deberán mostrarse entre corchetes y separadas por un espacio. Un
ejemplo de ejecución es el siguiente:

    Introduce una cadena de al menos 5 caracteres: abcde
    Carácter posición 0 va al String en la posición 3 del array.
    [] [] [] [a] []
    Carácter posición 1 va al String en la posición 3 del array.
    [] [] [] [ab] []
    Carácter posición 2 va al String en la posición 1 del array.
    [] [c] [] [ab] []
    Carácter posición 3 va al String en la posición 0 del array.
    [d] [c] [] [ab] []
    Carácter posición 4 va al String en la posición 2 del array.
    [d] [c] [e] [ab] []
*/

package examenfeb21_1;

/**
 *
 * @author JOSE
 */
public class ExamenFeb20_3DAM {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }
}

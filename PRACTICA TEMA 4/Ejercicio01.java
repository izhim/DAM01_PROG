package tarea04;

import java.util.Arrays;
import java.util.regex.*;


/**
 * Ejercicio 1. Cálculo de puntuaciones.
 * @author José Antonio Carrillo Huete
 */

public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        final char LETRA_X = 'x';

        // Variables de entrada
        // 1.- Declaramos un array de objetos String (anotaciones) 
        // con el contenido que se nos pide en el enunciado
        
        String[] anotaciones = {"a", "a-b", "X-A", "O-O-B", "X--X", "O-X-",
                                "-X-X", "O-X-O-X-O", "o", "O-o", "X", "o-x-o",
                                "x", "x-x", "O-x-X","X-X-X", "x-X-X-x"};

        // Variables de salida
        
        int validas, noValidas;
        
        // Variables auxiliares

        int i,j,puntos;
        char caracter;

        //String elemento;
        
        StringBuilder elemento = new StringBuilder("");

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("CÁLCULO DE PUNTUACIONES");
        System.out.println("-----------------------");

        // 2.- Mostramos por pantalla el contenido del array de anotaciones

        System.out.println("Anotaciones obtenidas de cada mano del juego:");
        System.out.println(Arrays.toString(anotaciones));
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------

        // 3.- Recorremos cada elemento del array
             // 3.1.- Si el elemento "encaja" con el patrón (anotación válida), se calcula su puntuación
                // Para ello habrá que descomponer la anotación en cada uno de sus elementos,
                // calcular su valor y sumarlos.
             // 3.2.- Si no "encaja" con el patrón, la anotación será inválida y su puntuación -1
            // 3.3.- Las puntuaciones obtenidas se "acumulan" o "concatenan" separadaa por comas en un objeto de tipo StringBuilder
            
        /*
            Utilizamos la expresión regular de la siguiente manera:
            [xXoO] comprobamos si la cadena empieza por x, X, o u O
            ([ '-][xXoO]){0,3} comprobamos si al primer carácter de la cadena le
                                siguen de 0 a 3 repeticiones de alguno de los 
                                siguientes carácteres: -x -X -o -O
         */

        // Inicializamos las variables
        
        Pattern p=Pattern.compile("[xXoO]([ '-][xXoO]){0,3}");
        Matcher m;
        validas = 0;
        noValidas = 0;
        
        // Recorremos el array para comprobar si las cadenas coinciden con el patrón
        
        for(i=0; i < anotaciones.length; i++){
            m = p.matcher(anotaciones[i]);
        /* 
            Si coincide con el patrón incrementamos el número de cadenas válidas,
            inicializamos los puntos a 0 y recorremos la cadena en busca del
            carácter x que es el que incrementa los puntos. Para que no haya
            problemas con mayúsculas utilizamos toLowerCase para compararlo
            siempre como minúscula
        */
            if (m.matches()){
                validas++;
                puntos = 0;
                for(j=0;j<anotaciones[i].length();j++){
                    caracter = anotaciones[i].toLowerCase().charAt(j);
                    if(caracter == LETRA_X){
                        puntos++;
                    }   
                }
        /* 
            Si la cadena no coincide con el patrón no es válida y por lo tanto
            restamos 1 punto al total e incrementamos el contador de cadenas
            no válidas
        */    
            }else{
                puntos = -1;
                noValidas++;
            }
        /*  
            Al StringBuilder elemento añadimos al final el número de puntos que
            hemos obtenido de la cadena junto con una coma
        */
            elemento.append(puntos + ",");
        }
        //  Al final de la cadena elemento restamos la coma sobrante
        
        elemento.delete(elemento.length()-1,elemento.length());
        
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO: PUNTUACIONES CALCULADAS");
        System.out.println("----------------------------------");

        // 4.- Mostramos por pantalla el resultado final
        
        // 4.1.- Lista completa de puntuaciones de cada mano
        
        System.out.println("Puntuaciones: " + elemento);

        // 4.2.- Número de anotaciones válidas
        
        System.out.println("Número de anotaciones válidas: " + validas);
        
        // 4.3.- Número de anotaciones no válidas
        
        System.out.println("Número de anotaciones inválidas: " + noValidas);
        
    }

}

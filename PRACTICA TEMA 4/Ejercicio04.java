
package tarea04;

import java.util.Arrays;

/**
 * Ejercicio 4. ¡Línea!
 * @author José Antonio Carrillo Huete
 */

public class Ejercicio04 {
    
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
        
        final String FILA = "línea";
        final String NO = "no";
        
        // Variables de entrada
        
        // 1.- Declaración del array que representa las bolas que han salido hasta el momento
        
        int[] bolas = {1, 2, 5, 10, 11, 12, 14, 15, 22, 55, 56, 57, 59, 60, 61, 66, 78, 89, 90};

        // 2.- Declaración del array bidimensional "irregular" de números enteros para representar el cartón
        
        int[][] carton = {{1, 2, 5, 9}, {11, 15}, {22, 29}, {34}, {47, 49}, {55, 59, 60}, {61}, {71, 75}, {88, 90}};

        // Variables de salida
        // 3.- Declaración del array unidimensional que almacenará los resultados

        String[] resultados;
        

        // Variables auxiliares
        
        int i, j, k;
        int cantLineas = 0;
        boolean linea, resultadoLinea;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("BUSCADOR DE LÍNEAS EN UN CARTÓN DE BINGO");
        System.out.println("----------------------------------------");

        // 4.- Mostramos por pantalla el contenido del cartón
        
        System.out.println("Cartón: " + Arrays.deepToString(carton));

        // 5.- Mostramos por pantalla la lista de bolas

        System.out.println("Números que ya han salido: " + Arrays.toString(bolas));
        
        //----------------------------------------------
        //                   Procesamiento 
        //---------------------------------------------- 
        // 6.- Reservamos espacio para el array de resultados (sin usar un literal)
        
        resultados = new String[carton.length];

        // 7.- Recorremos cada fila del cartón
        
        for(i = 0; i < carton.length; i++){
        
        // 7.1.- Para cada fila, recorremos todos los números que contenga
            
    /*
        Inicializamos la variable lógica "resultadoLinea" con valor "true" y la 
        utilizamos como testigo de manera que en el momento que un número del
        array de fila no se encuentre entre las bolas su valor pasa a ser "false"
        y si esta condición no se cumple (es decir, que el valor se encuentra)
        mantiene el valor "true"
    */
            
            resultadoLinea = true;
            for(j = 0; j < carton[i].length; j++){
            
        // 7.2.- Comprobamos si cada número ha salido o no (habrá que recorrer la lista de bolas que ya han salido)
        //       Si han salido todos, se marcará esa fila como "línea" en el array de resultados

    /*
        Utilizamos la variable "linea" como testigo para comprobar si un valor
        del cartón coincide con algún número que ya haya salido. Se inicializa a
        "false" y no se modifica a menos que haya una coincidencia.
    */
                
                linea = false;
                for(k = 0; k < bolas.length; k++){
                    if(carton[i][j] == bolas[k]){
                        linea = true;                        
                    }
                }
                
    /*
        En este apartado utilizamos el valor lógico de "linea" para decirle a
        "resultadoLinea" que no se ha encontrado un número, momento en que su
        valor pasa a valer "false", pues ya el array no es válido como línea.
    */
                
                if(!linea)
                    resultadoLinea = false;
            }
            
    /*  
        Trasladamos el resultado obtenido al array de resultados e incrementamos
        el contador de cantidad de líneas si corresponde.
    */
            if(resultadoLinea){
                resultados[i] = FILA;
                cantLineas++;
                
        // 7.3.- Si no han salido todos, se marcará es fila como "no" en el array de resultados
            
            }else resultados[i] = NO;
        }
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        
        // 8.- Mostramos por pantalla el array de resultados y cuántas líneas han salido

        System.out.println("Resultado de la búsqueda de líneas en el cartón de bingo:");
        System.out.println(Arrays.toString(resultados));
        System.out.println("Número de líneas obtenidas: " + cantLineas);
        
    }      
}

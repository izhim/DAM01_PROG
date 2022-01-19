package tarea04;

import java.util.Arrays;

/**
 * Ejercicio 5. Sopa de letras.
 * @author José Antonio Carrillo Huete
 */

public class Ejercicio05 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
        
        final String NO = "no";
        
        // Variables de entrada
        // 1.- Declaración del array unidimensional que contiene la lista de palabras para buscar

        String[] palabras = new String[]{"Hola", "sol", "AMOR", "ARA", "Casa", "dos"};
        
        // 2.- Declaración del array bidimensional que representa la sopa de letras
        
        char[][] sopaLetras = new char[][]{{'H','J','S','O','L'},{'O','E','C','A','U'},{'L','Y','K','D','A'},{'A','A','M','O','R'},{'V','C','A','S','A'}};

        
        // Variables de salida
        // 3.- Declaración del array unidimensional que almacena los resultados

        String[] resultados;
        
        // Variables auxiliares

        int i, j;
        int fila = 0;
        int columna = 0;
        int contador = 0;
        boolean encontrado;
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("BUSCADOR DE PALABRAS EN HORIZONTAL");
        System.out.println("----------------------------------");
        
        // 4.- Mostramos por pantalla el contenido de la sopa de letras en forma de tabla
        
        // Hacemos un doble ciclo for para recorrer la matriz entera
        
        System.out.println("Sopa de letras:");
        for(i = 0; i < sopaLetras.length; i++){
            for(j = 0; j < sopaLetras[i].length; j++)
                System.out.print(sopaLetras[i][j] + "  ");
            System.out.println();
        }
        
        // 5.- Mostramos por pantalla la lista de palabras
        
        System.out.println("\nLista de palabras de prueba:");
        System.out.println(Arrays.toString(palabras));

        //----------------------------------------------
        //                  Procesamiento 
        //----------------------------------------------
        // 5.- Reservamos espacio para el array de resultados (sin usar un literal)
        
        resultados = new String[palabras.length];
        
        // 7.- Exploramos la sopa de letras para buscar horizontalmente cada una de las palabras de la lista
        
        /*
            Tenemos 4 ciclos for:
                - Con el primero cogemos las palabras de la lista una por una
                - Con el segundo recorremos la fila una por una
                - Con el tercero recorremos la columna una por una
                - El cuarto lo utilizamos para, una vez encontrada una coincidencia
                    entre la primera letra de la palabra y una letra de la matriz,
                    comprobar letra a letra si las consecutivas también coinciden
        */
        
        // 7.1.- Recorremos la lista de palabras
        
        for(int k = 0; k < palabras.length; k++){
            
        // Asignamos a la variable "encontrado" un valor inicial falso
            encontrado = false;
            
        // 7.2.- Para cada palabra, la buscamos horizontalmente (en cada fila de la sopa)
            
            for(i = 0; i < sopaLetras.length; i++){
                for(j = 0; j < sopaLetras[i].length; j++){
        /*
            Al recorrer la matriz comprobando la palabra lo que buscamos es
            una coincidencia con la primera letra de la palabra siempre y cuando
            la palabra no se haya encontrado antes, si no hiciéramos esta excepción
            tendríamos un falso negativo si una vez encontrada la palabra diéramos
            con una segunda letra que coincidiera con la primera letra de nuestra
            palabra.
        */
                    if((palabras[k].toUpperCase().charAt(0) == sopaLetras[i][j]) && (!encontrado)){
        /*
            Al asignar a la variable "encontrado" el valor true lo estamos utilizando
            para que, mientras no se cumpla ninguna de las condiciones posteriores
            para descartar el que la palabra se encuentre en la sopa de letras,
            se trabaje con la premisa de que hemos encontrado una palabra, si al
            final no encontramos una condición para descartarla será porque hemos
            encontrado la palabra.
        */
                        encontrado = true;
        /*
            Cuando encontramos una coincidencia en la primera letra lo primero
            que comprobamos es que la palabra no tenga mayor longitud que el
            resto de la fila, en cuyo caso sería imposible que hubiéramos localizado
            la palabra y además evitamos que se pueda cometer un fallo de memoria.
        */
                        if(palabras[k].length() <= sopaLetras[i].length-j){
        /*
            En este punto utilizamos un contador "h" para ir incrementando la
            posición de la letra, tanto en la palabra a buscar como en la matriz,
            para poder ir comparándolas una a una.
        */
                            for(int h = 1; h < palabras[k].length()-1; h++){
        /*
            Si las letras sucesivas de la palabra no coinciden con las del vector
            le asignamos a nuestra variable de control "encontrado" el valor falso
        */
                                if(palabras[k].toUpperCase().charAt(h) != sopaLetras[i][j+h])
                                    encontrado = false;
                            }
        //  Tomamos los valores de la fila y la columna
                            fila = i;
                            columna = j;
        //  Asignamos falso si la longitud de palabras no cabe en la fila a partir
        //  de la coincidencia
                        }else encontrado = false;
        /*
            Si al final de las comprobaciones el valor de "encontrado" sigue siendo
            true significa que hemos encontrado la palabra, así que almacenamos los
            datos en el vector "resultados" en la misma posición de la palabra
            e incrementamos el contador.
        */
                        if(encontrado){
                            resultados[k] = " fila " + fila + " columna " + columna;
                            contador++;
        //  Si no lo hemos encontrado guardamos en "resultados" el valor de NO
                        }else{
                            resultados[k] = NO;
                        }
                    }
                }
            }
        }
           
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        
        // 8.- Mostramos por pantalla el array de resultados y cuántas palabras se han encontrado
        System.out.println("Resultado de la búsqueda horizontal:");
        System.out.println(Arrays.toString(resultados));
        
    }
}

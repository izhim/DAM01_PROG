package tarea04;

import java.util.Arrays;


/**
 * Ejercicio 2. Reconocimiento de palíndromos.
 * @author José Antonio Carrillo Huete
 */

public class Ejercicio02 {
    
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        
        // Variables de entrada
        
        // 1.- Declaración del array de objetos String de entrada
        // (Textos "Reconocer", "AMANECER", "Esto no es un palindromo",
        //    "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
        //    "A man a plan and a canal, Panama", "No deseo ese don..."
        
        String[] palindromos = {"Reconocer", "AMANECER", "Esto no es un palindromo",
                    "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
                    "A man a plan and a canal, Panama", "No deseo ese don..."};
        

        // Variables de salida
        // 2.- Declaración de un array de boolean para los resultados
        
        boolean[] resultados;
        
        // Variables auxiliares

        int i,j,k;
        String frase = new String();
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("RECONOCIMIENTO DE PALÍNDROMOS");
        System.out.println("-----------------------------");

        // 3.- Reservamos espacio para el array de resultados (procura no usar un literal)
        
        resultados = new boolean[palindromos.length];
        
        // 4.- Mostramos el array de textos por pantalla
        
        System.out.println("Los textos que vamos a analizar son: ");
        for(i=0; i < palindromos.length; i++){
            System.out.println("Texto " + (i+1) + ": " + palindromos[i]);
        }
                
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 5.- Recorremos de nuevo el array de textos
        // 5.1.- Para cada texto comprobamos si es palíndromo
        // Habrá que "limpiar" los textos de espacios y signos de puntuación
        // 5.2.- Si se trata de un palíndromo, se almacena el valor true en el
        // array de salida. Si no, se almacena false
        
        /*
            Recorremos el array y en "frase" almacenamos cada cadena habiendo
            sustituido todos los caracteres que no son alfabéticos por "", es
            decir, los eliminamos, y utilizamos .toLowerCase() para almacenarlos
            todos en minúscula.
        
            Utilizamos una variable "j" inicializada a 0 y una variable "k"
            inicializada con el valor de la extensión de la cadena "frase" menos
            uno como contadores para ir recorriendo los caracteres desde los
            extremos de la cadena hacia el centro y comparándolos.
        
            La comparación la hacemos asignando a la posición correspondiente el
            valor lógico "true", y si al recorrer la cadena alguno de los
            caracteres del contador "j" no coincide con el correspondiente del
            contador "k" le asignamos el valor "false" (si no cambia es que está
            todo correcto)
        
        */
        
            for(i=0; i < palindromos.length; i++){
                frase = palindromos[i].replaceAll("\\W","").toLowerCase();
                resultados[i] = true;
                k = frase.length()-1;
                j = 0;
                do{
                    if(frase.charAt(j) != frase.charAt(k)){
                        resultados[i] = false;
                    }
                    j++;
                    k--;
                }while(j<=k);
            }

        /*
            NOTA:   Otra opción para el cálculo del palíndromo hubiera sido
                    creando un StringBuilder utilizando la variable "frase"
                    con el método reverse() y comparando ambas cadenas, pero ya
                    que es un resultado que se ha mostrado en el temario dentro
                    del apartado 2.1.4 en el enlace sobre la clase StringBuilder
                    he decidido utilizar este método alternativo.
        */

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADOS OBTENIDOS");
        System.out.println("--------------------");
        
        // 6.- Mostramos por pantalla el array de resultados
       
        System.out.println(Arrays.toString(resultados));
        
    }

    
}
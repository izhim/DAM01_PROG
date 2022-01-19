package tarea04;

import java.util.Arrays;

/**
 * Ejercicio 3. Inversión de palabras.
 * @author Jose Antonio Carrillo Huete
 */

public class Ejercicio03 {
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        // 1.- Declaración del array de objetos String de entrada
        // (Textos "Reconocer", "AMANECER", "Esto no es un palindromo",
        //    "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
        //    "A man a plan and a canal, Panama", "No deseo ese don..."
        
        String[] entrada = {"Reconocer", "AMANECER", "Esto no es un palindromo",
                "Dabale arroz a la zorra el abad.", "A man, a plan, a canal: Panama",
                "A man a plan and a canal, Panama", "No deseo ese don..."};

        // Variables de salida
        // 2.- Declaración de un array de String para los resultados

        String[] resultados;
        
        // Variables auxiliares

        int i,j;
        StringBuilder frase;
        String texto = new String("");
        String[] cadenaAuxiliar;
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("INVERSIÓN DE PALABRAS");
        System.out.println("---------------------");

        // 3.- Reservamos espacio para el array de resultados (procura no usar un literal)

        resultados = new String[entrada.length];
        
        // 4.- Mostramos el contenido del array de textos por pantalla
        // colocando cada texto en una línea diferente

        System.out.println("Los textos que vamos a analizar son: ");
        for(i=0; i < entrada.length; i++){
            System.out.println("Texto " + (i+1) + ": " + entrada[i]);
        }        
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // 5.- Recorremos el array de textos.
        // Para cada texto:
        //   5.1.- obtenemos cada palabra del texto;
        //   5.2.- invertimos cada palaba del texto;
        //   5.3.- almacenamos cada palabra invertida separadas por espacios en una misma cadena.
        //         Esa cadena de palabras invertidas se almacenará en el array de resultados
        
        /*
            Recorremos todo el vector de entrada para coger las frases una por una.
            En cada ciclo iniciamos las variables String con campo vacío e
            inicializamos un StringBuilder.
        */
        for(i = 0; i < entrada.length; i++){
            texto = "";
            frase = new StringBuilder("");
        /*
            Cada frase la almacenamos por palabras en el vector "cadenaAuxiliar"
            tomando como referencia del método .split el espacio en blando,
            habiendo eliminado previamente los signos de puntuación mediante el
            regex "\\p{Punct}"
        */
            cadenaAuxiliar = entrada[i].replaceAll("\\p{Punct}","").split(" ");
            
        /*
            Ahora recorremos este nuevo vector para ir almacenando en la variable
            "frase" el contenido de cada elemento, utilizamos un StringBuilder
            para poder aplicar el método .reverse() que invierte cada palabra.
            
            Añadimos el resultado al final del String "texto" junto con un espacio
            para dividir las palabras.
        */    
            for(j = 0; j < cadenaAuxiliar.length; j++){
                frase = new StringBuilder(cadenaAuxiliar[j]);
                texto = texto.concat(frase.reverse().toString()+" ");
            }
        /*
            Por último guardamos la String "texto" (que ya tiene guardada la frase
            completa con las palabras invertidas) dentro del vector "resultado"
            en la misma posición del vector "entrada" y aprovechamos para aplicar
            el método .trim() para eliminar el último espacio creado en la cadena
        */
            
            resultados[i] = texto.trim();
        }
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("RESULTADOS OBTENIDOS");
        System.out.println("--------------------");
        
        // 6.- Mostramos los resultado por pantalla.
        // Recorremos el array de textos y para cada texto:
        //   6.1. Mostramos el texto original 
        //   6.2. Mostramos el texto con las palabras invertidas 
        
        
        //    Recorremos ambos arrays para mostrar los resultados por pantalla
        
        
        for(i = 0; i < entrada.length; i++)
        {
            System.out.println("Texto " + (i+1) + ": '" + entrada[i] + "'");
            System.out.println(" Palabras invertidas: '" + resultados[i] + "'");
        }
        
        
        
    }

    
}
package tarea03;

// Incluir los imports que se necesiten

import libtarea3.Dado;

/**
 * Ejercicio 2: Lanzando los dados.
 * @author JOSE ANTONIO CARRILLO HUETE
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        
        final int numVeces = 4;
        
        // Variables de entrada
        
        Dado dado;     // Declaramos el objeto dado

        // Variables de salida
        // (no hace falta ninguna)
        
        // Variables auxiliares

        int i,j;        // Utilizados en los bucles For
        int random;     // Utilizado para almacenar número aleatorio

        System.out.println("LANZANDO LOS DADOS");
        System.out.println("------------------");
        System.out.println();

        //----------------------------------------------
        //               Análisis inicial
        //----------------------------------------------        
        
        // 1. Consulta de valores iniciales
        
        System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES");
        System.out.println("---------------------------------------");
        System.out.println();

        // 1.1. Número total de dados creados
        
        // Para ello utilizamos el método getNumeroDadosCreados()
        
        System.out.print("Número total de dados creados hasta el momento: ");
        System.out.println(Dado.getNumeroDadosCreados());
        
        // 1.2. Número total de lanzamientos
        
        // Para ello utilizamos el método getNumeroLanzamientosGlobal()

        System.out.print("Número total de lanzamientos hasta el momento: ");
        System.out.println(Dado.getNumeroLanzamientosGlobal());
        
        // 1.3. Consulta de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar)   
        
        // Para ello hacemos un bucle For hasta el valor 4 (constante numVeces) como se indica el ejercicio

        for(i = 1 ; i <= numVeces ; i++){
            System.out.print("Número de veces que se ha obtenido " + i + ": ");
            System.out.println(Dado.getNumeroVecesCaraGlobal(i));
        }

        
        //----------------------------------------------
        //      Creación y lanzamiento de dados
        //----------------------------------------------
        
        System.out.println();
        System.out.println("2.- CREACIÓN Y LANZAMIENTO DE DADOS");
        System.out.println("-----------------------------------");
        System.out.println();
        
        // 2.1. Intentos de creación 
        // Se intentan crear 10 dados que tengan aleatoriamente entre 0 y 8 caras (bucle)
        // Sólo algunas llamadas al constructor funcionarán y en esos casos es cuando se podrá lanzar el dado
        // Otras harán que salte una excepción IllegalArgumentException
        // Habrá que recogerla y mostrar el mensaje de error por pantalla
         
        /*
            Hacemos un recorrido con un bucle for para valores de i entre 1 y 10 (crear 10 dados)
        
            Utilizamos Math.random()*8 para obtener un número aleatorio entre 1 y 8
            y lo redondeamos con Math.round(*) para almacenarlo como entero en la
            variable round.
        
            Probamos a instanciar el objeto dado para cada bucle, en caso de que se haya creado
            correctamente muestra el mensaje por pantalla e inicia otro ciclo para lanzar
            el dado random veces. En caso de que no se haya podido crear correctamente
            muestra por pantalla un mensaje de error.
        */
        
        for(i=1 ; i<=10 ; i++){
            random = (int)Math.round(Math.random()*8);
            System.out.print("Intento " + i + ": Intentando crear dado aleatorio de " + random + " caras: ");
            try
            {
                dado = new Dado(random);
                System.out.println("Correcto, creado dado de " + random + " caras.");
                System.out.print("Lo lanzamos " + random + " veces: ");
                for(j=1 ; j <= random ; j++)
                    dado.lanzar();      
                System.out.println(dado.getSerieHistoricaLanzamientos());
                
            }catch(IllegalArgumentException e){
                System.out.println("Error, número de caras no válido: " + random);
            }
            
        }
        
        //----------------------------------------------
        //         Análisis de resultados finales
        //----------------------------------------------
        // 3. Análisis de resultados una vez realizados todos los lanzamientos
        System.out.println();
        System.out.println("3.-ANÁLISIS DE RESULTADOS FINALES");
        System.out.println("---------------------------------");

        // 3.1. Número total de dados creados
        
        // Para ello utlizamos el método getNumeroDadosCreados()
        System.out.println("Número total de dados creados hasta el momento: " + Dado.getNumeroDadosCreados());
        
        // 3.2. Número total de lanzamientos

        // Para ello utilizamos el método getNumeroLanzamientosGlobal()
        System.out.println("Número total de lanzamientos llevados a cabo: " + Dado.getNumeroLanzamientosGlobal());
        
        // 3.3. Análisis de los lanzamientos realizados (bucle desde 1 hasta el número de caras que se desea analizar) 
        
        // Creamos un bucle For para comprobar desde el valor 1 hasta el 4 (constante numVeces)
        // el número de veces total que ha salido cada cara

        for(i = 1 ; i <= numVeces ; i++)
                System.out.println("Número de veces que se ha obtenido " + i + " entre todos "
                        + "los lanzamientos de todos los dados: " + Dado.getNumeroVecesCaraGlobal(i));
        
    }
}

package tarea03;

// Incluir los imports que se necesiten

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.InputMismatchException;
import java.util.Scanner;



/**
 * Ejercicio 3: Horario de clases.
 *
 * @author JOSE ANTONIO CARRILLO HUETE
 */
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // utilizadas para almacenar la hora y el minuto exactos de inicio de las clases
        
        final int horaInicio = 8;
        final int minutoInicio = 0;

        // Variables de entrada

        // Variables de salida
        // Variable tipo String que almacena el resultado que se va a mostrar por pantalla
        String resultado;
        
        // Variables auxiliares
        /*
            int hora: creado para guardar el valor de la hora introducido por pantalla
            int minuto: creado par guardar el valor del minuto introducido por pantalla
            long minutos: creado para almacenar la diferencia en minutos entre la hora
                de inicio de las clases y la hora introducida
            boolean correcto: condición que se utiliza para los ciclos while
        */

        int hora = 0;
        int minuto = 0;
        long minutos;
        boolean correcto;
        
        // Objeto Scanner para lectura desde teclado
        
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("HORARIO DE CLASES");
        System.out.println("-----------------");

        
        // 1. Creación de un objeto de la clase LocalTime con la primera hora de clase (08:00)

        LocalTime primeraHora = LocalTime.of(horaInicio, minutoInicio);
        
        
        // 2. Lectura por teclado y comprobación de hora y minuto

        // 2.1. Leer y comprobar la hora (debe estar entre 0 y 23)
        /*
                Hacemos un bucle do-while (para que se ejecute al menos una vez)
                teniendo como condición de control el valor lógico correcto que
                se inicializa en false. 
                Dentro del bucle hacemos un try-catch que intenta tomar por
                pantalla el valor de la hora, dentro del try comprobamos si la
                hora se encuentra entre 0 y 23, y en el caso de cumplir esta
                condición damos a correcto el valor true para que finalice el
                ciclo do-while.
                Si el try arroja una excepción quiere decir que no se ha introducido
                un valor int correcto e indica que el formato no es válido para
                que se vuelva a solicitar en el siguiente ciclo del do-while
        */
        
        correcto = false;
        do{
            System.out.print("Por favor, introduzca una hora válida (0-23): ");
            try{
                hora = teclado.nextInt();
                if(hora >= 0 && hora <=23)
                    correcto = true;
                else
                    System.out.print("La hora debe estar entre 0 y 23. ");
            }catch(InputMismatchException e){
                System.out.print("Formato incorrecto. ");
                teclado.nextLine();
            } 
        }while (!correcto);
        
        // 2.2.  Leer y comprobar el minuto (entre 0 y 59)
        /*
                Llevamos a cabo la misma operación que con la hora pero esta vez
                con el minuto.
        */

        correcto = false;
        do{
            System.out.print("Por favor, introduzca un minuto válido (0-59): ");
            try{
                minuto = teclado.nextInt();
                if(minuto >= 0 && minuto <=59)
                    correcto = true;
                else
                    System.out.print("El minuto debe estar entre 0 y 59. ");
            }catch(InputMismatchException e){
                System.out.print("Formato incorrecto. ");
                teclado.nextLine();
            } 
        }while (!correcto);
        
        
        // 3. Creación de objeto LocalTime a partir de los datos leídos por teclado
        /*
              Creamos un objeto tipo LocalTime con la hora y el minuto recogidos
              por pantalla, una vez hemos comprobado que los valores son correctos
        */

        LocalTime horaIntroducida = LocalTime.of(hora, minuto);
        
        
        //----------------------------------------------
        //               Procesamiento 
        //----------------------------------------------
        // 4. Obtener el rango en el que se encuentra la hora a partir de los dos objetos LocalTime
        /*
                En primer lugar comprobamos si la hora introducida es anterior a
                la primera hora, y si es así calculamos los minutos que faltan
                para que empiecen las clases, guardando el resultado en una String
                que será la que se muestre por pantalla
        */

        if(horaIntroducida.isBefore(primeraHora)){
            minutos = horaIntroducida.until(primeraHora, MINUTES);
            resultado = "Faltan " + minutos + " minutos para que empiecen las clases";
            
        /*
                Si la hora introducida no es anterior comprobamos en cada condicional
                if si la hora se encuentra en cada uno de los tramos de cada asignatura
                y en el caso de cumplirse la condición asignamos a la variable resultado
                el valor que debe de mostrar por pantalla
        */    
        }else{
            minutos = primeraHora.until(horaIntroducida, MINUTES);
            if(horaIntroducida.isBefore(primeraHora.plusHours(2))){
                resultado = "Clase correspondiente: Programación";
            }else if(horaIntroducida.isBefore(primeraHora.plusHours(4))){
                resultado = "Clase correspondiente: Sistemas Informáticos";
            }else if (horaIntroducida.isBefore(primeraHora.plusHours(6))){
                resultado = "Clase correspondiente: Entornos de Desarrollo";
                
        /*
                Si no se dan ninguna de las condiciones anteriores entonces se cumple
                la condición de que la hora introducida es posterior a la finalización
                de las clases y guardamos en la variable resultado los minutos que han
                pasado desde la finalización de las mismas, restando a la variable
                minutos la cantidad de minutos que duran todas las clases ya que tiene
                como referencia la hora de inicio de las clases.
        */
                
            }else{
                minutos = minutos - 360;
                resultado = "Las clases finalizaron hace " + minutos + " minutos";
            }
        }
       
        
        //----------------------------------------------
        //            Salida de resultados 
        //----------------------------------------------
        // 5. Mostrar la hora y introducida y los resultados obtenidos
        /*
                Utilizamos horaIntroducida.toString() para obtener el valor
                de la hora introducida en formato cadena y así poder mostrarla
                por pantalla.
                En segundo lugar mostramos por pantalla la String resultado que
                nos indica el resultado obtenido en el apartado 4.
        */
                
        System.out.println("Hora introducida: " + horaIntroducida.toString());
        System.out.println(resultado);

    }
}

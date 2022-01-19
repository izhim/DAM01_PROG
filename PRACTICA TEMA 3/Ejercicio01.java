package tarea03;


import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import libtarea3.CuentaBancaria;

/**
 * Ejercicio 1: Uso de cuentas bancarias.
 * @author JOSE ANTONIO CARRILLO HUETE
 */

public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        
        // 1.- Declaración de tres variables referencia a objetos instancia de la clase CuentaBancaria
        //     ---------------------------------------------------------------------------------------
        
        // Declaración de las variables de referencia
        
        CuentaBancaria cuentaPrivada, cuentaConjunta, cuentaFamiliar;
                
        // Declaración de valores de fecha
        
        LocalDate fecha = LocalDate.of(2027,9,1);        // creamos fecha con el valor inválido
        LocalDate fechaCreacion = LocalDate.of(2021, 7, 1);  // creamos la fecha de creación de las cuentas conjunta y privada
        
        // Declaración de los formatos de fecha y moneda
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd'/'MM'/'yyyy");  // creamos el formato de fecha
        DecimalFormat df = new DecimalFormat("#0.00");       // utilizamos este objeto para mostrar al menos 1 entero y 2 decimales
        
        // Declaración de constantes
        
        final double saldo = -200;          // creamos saldo negativo para la prueba de error
        final double saldoPrivada = 1000;   // creamos el saldo de la cuenta privada
        final double saldoConjunta = 200;   // creamos el saldo de la cuenta conjunta
        final double embargo = -200;        // creamos el descubierto máximo para embargo
        
       
        // Declaración de variables auxiliares que se utilizan para indicar si una cuenta está embargada o al descubierto
        
        String embargada, descubierto;       
        
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        
        System.out.println("USANDO CUENTAS BANCARIAS");
        System.out.println("------------------------");
        // aplicamos el formato de fecha a la fecha local
        System.out.printf ("Fecha actual: %s\n", LocalDate.now().format(formato));  
        System.out.println();

        
        // 2.- Instanciación de tres objetos CuentaBancaria
        //     --------------------------------------------

        System.out.println("Creación de cuentas (constructores)");
        System.out.println("-----------------------------------");
        
        // 2.1.- Intento de crear una cuenta con fecha no válida (hay gestionar la posible excepción)
        //       ------------------------------------------------------------------------------------
        /*
            Utilizamos el bloque try catch para crear el objeto cuentaPrivada a partir de la constante
            fecha, si no consigue crearla se genera una excepción con un mensaje por pantalla que
            indica el valor de fecha incorrecto. En la excepción no usamos cuentaPrivada.getFechaCreacion()
            porque al producirse la excepción el objeto no ha sido creado
        */

        System.out.println("Intentando crear una cuenta privada con fecha inválida...");
        try{
            // probamos a crear el objeto con un valor no válido:
            cuentaPrivada = new CuentaBancaria(0,fecha);                        
        }catch(IllegalArgumentException e){
            System.out.println("Error: Parámetros de creación de cuenta inválidos. "
                    // utilizamos formato para mostrar por pantalla la fecha con el formato dd/mm/yyyy
                    + "Fecha de creación inválida: " + fecha.format(formato) + "\n");  
        }
        
        // 2.2.- Intento de crear una cuenta con saldo no válido (hay que gestionar la posible excepción)
        //       ----------------------------------------------------------------------------------------
        /*
               Utilizamos el bloque try catch para intentar crear un objeto con la constante saldo
               Si no se puede crear manda una respuesta por pantalla indicando que los parámetros
               no son válidos, mostrando el valor de la constante saldo (no mostramos directamente
               el valor de cuentaPrivada.getSaldo() porque si nos produce una excepción no llega a
               crearse.
         */
        
        System.out.println("Intentando crear una cuenta privada con saldo inválido...");
        try{
            // probamos a crear el objeto con un valor no válido:
            cuentaPrivada = new CuentaBancaria(saldo);          
        }catch(IllegalArgumentException e){
            System.out.println("Error: Parámetros de creación de cuenta inválidos. "
                    // utilizamos df para que el saldo se muestre con al menos un entero y dos decimales:
                    + "Saldo inicial: " + df.format(saldo) + "\n");     
        }
        
        // 2.3.- Creación de una cuenta válida usando el constructor de tres parámetros
        //       ----------------------------------------------------------------------
        
        System.out.println("Creando una cuenta privada válida usando el constructor de tres parámetros:");
        cuentaPrivada = new CuentaBancaria(saldoPrivada,fechaCreacion,embargo);   
       
        System.out.println("Cuenta privada creada: " + cuentaPrivada.toString() + "\n");
               
        // 2.4.- Creación de una cuenta válida usando el constructor de dos parámetros  
        //       ----------------------------------------------------------------------
        
        System.out.println("Creando una cuenta conjunta válida usando el constructor de dos parámetros:");
        cuentaConjunta = new CuentaBancaria(saldoConjunta,fechaCreacion);
        System.out.println("Cuenta conjunta creada: " + cuentaConjunta.toString() + "\n");

        // 2.5.- Creación de una cuenta válida usando el constructor sin parámetros        
        //       -------------------------------------------------------------------
        
        System.out.println("Creando una cuenta familiar válida usando el constructor sin parámetros:");
        cuentaFamiliar = new CuentaBancaria();
        System.out.println("Cuenta familiar creada: " + cuentaFamiliar.toString() + "\n");
        
        
        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        // Dado que se va a ir mostrando información de salida a la vez que 
        // se van realizando operaciones, podemos considerar en este caso
        // que el procesamiento y la salida de resultado van unidos y "mezclados"
        
        
        // 3.- Obtención de información de la cuenta privada
        //     ---------------------------------------------
        /*
            Mostramos los datos de la cuenta privada por pantalla utilizando
            los métodos de la clase definidos para ello:
                - getID(): para obtener el valor del ID
                - getFechaCreacion(): para obtener la fecha de creación
                - getLimiteDescubierto(): para obtener el límite de descubierto
                - isEmbargada(): obtenemos un valor lógico y asignamos al String
                  embargada el valor "sí" o "no" dependiendo del resultado
                - isDescubierta(): hacemos la misma operación que con isEmbargada()
                  para saber si la cuenta está al descubierto
                - getDiasCuenta(): nos devuelve el valor de los días que lleva la
                  cuenta abierta
         */
        
        System.out.println("Prueba de los getters de la cuenta privada:");
        System.out.println("-------------------------------------------");
        // utilizamos getId() para mostrar el valor del ID de la cuenta
        System.out.println("ID: " + cuentaPrivada.getId());
        // utilizamos getFechaCreacion() y format(formato) para mostrar el valor de la fecha con el formato dd/mm/yyyy
        System.out.println("Fecha de creación: " + cuentaPrivada.getFechaCreacion().format(formato));
        // mostramos el límite de descubierto con getLumiteDescubierto() utilizando el formato de moneda que hemos definido
        System.out.println("Límite de descubierto: " + df.format(cuentaPrivada.getLimiteDescubierto()));
        // asignamos a la cadena embargada el valor sí o no dependiendo del valor lógico de isEmbargada() y mostramos su valor
        embargada = cuentaPrivada.isEmbargada()? "Sí" : "No";
        System.out.println("Está embargada: " + embargada);
        // asignamos a la cadena descubierto el valor sí o no dependiendo del valor lógico de isDescubierta() y mostramos su valor
        descubierto = cuentaPrivada.isDescubierta()? "Sí" : "No";
        System.out.println("Está al descubierto: " + descubierto);
        // Obtenemos los días que la cuenta lleva abierta mediante getDiasCuenta() y lo mostramos por pantalla
        System.out.println("Número de días que lleva la cuenta abierta: " + cuentaPrivada.getDiasCuenta() + "\n");

        
        // 4.- Realización de operaciones sobre las cuentas
        //     --------------------------------------------
        /*  
            Para este caso utilizamos los siguientes métodos para las distintas
            operaciones:
                - ingresar(double): para ingresar la cantidad indicada en el objeto
                  correspondiente
                - extraer(double): para extraer la cantidad indicada en el objeto
                  correspondiente
                - transferir(double,CuentaBancaria): para transferir la cantidad
                  indicada desde el objeto correspondiente hasta el objeto destino
                  que es el indicado en los valores de entrada del método        
         */

        System.out.println("Realización de operaciones sobre las cuentas:");
        System.out.println("---------------------------------------------");
        
        // Ingreso de 100 en la cuenta familiar:
        
        System.out.println("Ingresamos 100 en la cuenta familiar...");
        cuentaFamiliar.ingresar(100);
        
        // Extracción de 100 de la cuenta conjunta:
        
        System.out.println("Extraemos 100 de la cuenta conjunta...");
        cuentaConjunta.extraer(100);
        
        // Transferencia de 1100 desde la cuenta privada a la cuenta familiar:
        
        System.out.println("Transferimos 1100 de la cuenta privada a la familiar...");
        cuentaPrivada.transferir(1100, cuentaFamiliar);
       
        
        // 5.- Estado final de las cuentas
        //     ---------------------------
        
        System.out.println("\n");
        System.out.println("Estado final de las cuentas:");
        System.out.println("----------------------------");
        System.out.println("Estado final de la cuenta privada:  " + cuentaPrivada.toString());
        System.out.println("Estado final de la cuenta conjunta: " + cuentaConjunta.toString());
        System.out.println("Estado final de la cuenta familiar: " + cuentaFamiliar.toString());
        
    }
    
}

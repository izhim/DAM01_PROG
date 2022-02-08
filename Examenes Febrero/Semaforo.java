/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Implementa una clase Semaforo que represente a un semáforo de vehículos
con las siguientes propiedades y comportamiento:
a) Una instancia de la clase Semaforo sólo podrá tener un estado de los tres siguientes: ROJO,
AMARILLO, VERDE. Los únicos atributos que necesitas para representar a un semáforo serán el
estado y el número de veces que ha cambiado de estado desde que se creó.
b) Se dispondrá de dos constructores:
◦ Un constructor con un parámetro, donde se indicará el estado inicial del semáforo con un
número entero (0=ROJO, 1=AMARILLO, 2=VERDE). Si el estado no es válido (no está entre 0
y 2), se lanzará una excepción de tipo IllegalArgumentException.
◦ Un constructor sin parámetros, donde se tendrá el estado ROJO como el estado inicial por
omisión.
c) Dos métodos getEstado, y getNumCambios que devolverán el estado actual del semáforo (un
String con el valor “ROJO”, “AMARILLO” o “VERDE”) y el número de veces que ha cambiado de
estado respectivamente.
d) Un método cambiar, que cambiará el estado del semáforo, pasando de ROJO a AMARILLO, de
AMARILLO a VERDE, y de VERDE a ROJO . Este método no devolverá ningún valor.
e) Un método toString, que devuelva una cadena del tipo “Semáforo en xxx. Ha cambiado
zzz veces de estado”, donde xxx será el estado actual del semáforo (cadena “ROJO”,
“AMARILLO” o “VERDE”) y zzz el número de veces que ha cambiado de estado hasta el momento.
f) En la misma clase Semaforo, crea un método main() donde:
◦ Se instancie un semáforo con el constructor sin parámetros y se muestren sus datos usando
toString.
◦ Se intente instanciar un semáforo con un estado inicial inválido (por ejemplo 3), de manera
que se genere una excepción que habrá que capturar con una estructura try-catch.
◦ Se instancie un semáforo con estado inicial 1 y se muestren sus datos por pantalla, usando
los métodos getEstado y toString. A continuación, se cambiará 5 veces de estado (bucle
for), mostrándose en pantalla los datos del semáforo tras cada cambio de estado usando
toString.
Aquí tienes un ejemplo de la salida por pantalla tras una ejecución de prueba:

    SEMÁFOROS
    ---------
    Prueba del constructor sin parámetros:
    Objeto creado: Semáforo en ROJO. Ha cambiado 0 veces de estado
    Prueba del constructor con parámetros con valor inválido:
    Error. Estado inválido: 3.
    Prueba del constructor con parámetros con valor 1:
    Prueba del getEstado: AMARILLO
    Prueba del toString: Semáforo en AMARILLO. Ha cambiado 0 veces de estado
    Pruebas de cambio:
    Semáforo en VERDE. Ha cambiado 1 vez de estado
    Semáforo en ROJO. Ha cambiado 2 veces de estado
    Semáforo en AMARILLO. Ha cambiado 3 veces de estado
    Semáforo en VERDE. Ha cambiado 4 veces de estado
    Semáforo en ROJO. Ha cambiado 5 veces de estado
*/

package examenfeb21_1;

/**
 *
 * @author JOSE
 */
public class Semaforo {

    //  CONSTANTES
    private static final String[] LUCES = {"ROJO","AMARILLO","VERDE"};
    private static final int DEFAULT_ESTADO = 0;
    
    //  VARIABLES
    private int estado;
    private int cambios;
    
    //  CONSTRUCTORES
    public Semaforo(int estado) throws IllegalArgumentException{
        if(estado < 0 || estado > 2)
            throw new IllegalArgumentException("Estado inválido: " + estado);
        this.estado = estado;
        this.cambios = 0;
    }
    
    public Semaforo(){
        this(DEFAULT_ESTADO);
    }
    
    //  MÉTODOS DE OBJETO
    public String getEstado(){
        return LUCES[this.estado];
    }
    
    public int getNumCambios(){
        return this.cambios;
    }
    
    public void cambiar(){
        int estado = this.estado == 2 ? 0 : this.estado + 1;
        this.estado = estado;
        this.cambios++;
    }

    //  MÉTODO TOSTRING
    @Override
    public String toString(){
        return(String.format("Semáforo en %s. Ha cambiado %d veces de estado", 
                this.getEstado(), this.getNumCambios()));
    }
    
    
    public static void main(String args[]) {
        
        final int INVALIDO = 3;
        final int VALIDO = 1;
        final int VECES_CAMBIO = 5;
        
        System.out.println("Prueba del constructor sin parámetros.");
        Semaforo semaforo1 = new Semaforo();
        System.out.println("Objeto creado: " + semaforo1.toString());
        
        System.out.println("Prueba del constructor con valor inválido.");
        try{
            Semaforo semaforo2 = new Semaforo(INVALIDO);
            System.out.println("Objeto creado: " + semaforo2.toString());
        }catch(IllegalArgumentException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        
        System.out.printf("Prueba del constructor con valor %d\n", VALIDO);
        try{
            Semaforo semaforo3 = new Semaforo(VALIDO);
            System.out.println("Prueba del getEstado: " + semaforo3.getEstado());
            System.out.println("Prueba del toString: " + semaforo3.toString());
            System.out.println("Pruebas de cambio.");
            for(int cont = 0; cont < VECES_CAMBIO; cont++){
                semaforo3.cambiar();
                System.out.println(semaforo3.toString());
            }
        }catch(IllegalArgumentException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}

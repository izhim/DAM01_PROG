/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.tema.pkg5;

/**
 *
 * @author JOSE
 */
/*
    Se nos ha planteado implementar una clase que represente un modelo básico de 
    funcionamiento de una bombilla:

        estado lumínico de la bombilla (encendida o apagada),
        número de veces que ha sido encendida desde que se fabricó.

    Además de eso se querría mantener un registro de cuántas bombillas han sido
    creadas hasta el momento y cuántas de ellas se encuentran encendidas.
*/
public class Bombilla {
    
//------------------------------| ATRIBUTOS |-----------------------------------
    
    //  VARIABLES DE CLASE
    private static int bombillasCreadas;    // cantidad total de bombillas creadas
    private static int bombillasEncendidas; // cantidad total de bombillas que están encendidas
   
    //  CONSTANTES DE CLASE
    
    public static final boolean    ESTADO_INICIAL_BOMBILLA = false;
    public static final int        MIN_POTENCIA_BOMBILLA = 10;
    public static final int        MAX_POTENCIA_BOMBILLA = 200;
    public static final int        DEFAULT_POTENCIA_BOMBILLA = 60;
    
    //  VARIABLES DE OBJETO
    private boolean estadoBombilla;      // Estado lumínico de la bombilla
    private int     vecesEncendida;      // veces que se ha encendido desde que se fabricó
    private int     tiempoEncendida;     // Tiempo que lleva encendida la bombilla
    
    //  CONSTANTES DE OBJETO
    private final int potencia;         // Potencia de la bombilla
    
//-----------------------------| CONSTRUCTORES |--------------------------------
    
    //  Constructor con 2 parámetros
    public Bombilla(boolean estado, int potencia){
        this.potencia = potencia;
        this.estadoBombilla = estado;
        Bombilla.bombillasCreadas ++;
        Bombilla.bombillasEncendidas += this.estadoBombilla ? 1 : 0;
        this.vecesEncendida += this.estadoBombilla ? 1 : 0;
    }
    
    /*
        Una vez que tenemos un núcleo básico de atributos para la clase, se nos 
        plantean los siguientes constructores:

            - Un constructor con un solo parámetro (estado inicial de la bombilla), 
            que hará que la bombilla tenga ese estado inicial al crearse;
            - Un constructor sin parámetros, que hará que la bombilla al crearse 
            esté apagada.

        Implementa esos constructores en Java y añade, si lo consideras necesario, 
        los atributos adicionales que estimes oportuno.

    */
    
    //  Constructor con 1 parámetro
    public Bombilla(boolean estado){
        this(estado, Bombilla.DEFAULT_POTENCIA_BOMBILLA);
    }
    
    // Constructor sin parámetros
    public Bombilla(){
        this(Bombilla.ESTADO_INICIAL_BOMBILLA);
        this.vecesEncendida ++;
    }
    
//---------------------------| MÉTODOS DE CLASE |-------------------------------    
    
    public static int getBombillasCreadas(){
        return Bombilla.bombillasCreadas;
    }
    
    public static int getBombillasEncendidas(){
        return Bombilla.bombillasEncendidas;
    }
    
//--------------------------| MÉTODOS DE OBJETO |-------------------------------
    
    /*
        Analiza e implementa los getter (métodos get) que consideres apropiado 
        que esta clase podría tener.
    */
    
    public boolean getEstadoBombilla(){
        return this.estadoBombilla;
    }
    
    public int getVecesEncendida(){
        return this.vecesEncendida;
    }
    
    /*
        Respecto a los posibles métodos de acción que se pueden aplicar sobre un 
        objeto bombilla se ha pensado en los siguientes:

        - método para encender una bombilla;
        - método para apagar una bombilla;
        - método para conmutar el estado de una bombilla (pasarla de encendida a 
        apagada o viceversa).

        Debes tener en cuenta que una bombilla sólo puede ser encendida si aún no
        lo está. Si se intenta encender una bombilla encendida que ya lo está,
        debería producirse algún tipo de señal que indicara que se ha intentado 
        llevar a cabo una acción que no se podía o no se debía realizar en ese 
        momento. ¿Qué mecanismo proporciona Java para informar sobre ese tipo de 
        circunstancias? También debería tenerse en cuenta lo mismo para cuando
        intente apagarse una bombilla que ya se encuentra apagada.

        También debes reflexionar acerca de todos los efectos que producen estas 
        acciones sobre todos y cada uno de los atributos de objeto y de clase, no 
        sólo de los más evidentes. Está claro que encender o apagar una bombilla 
        afectará al estado lumínico de la bombilla (apagada o encendida), pero es 
        probable que afecte también a otros atributos (número de veces que se ha
        encendido la bombilla, cantidad de bombillas encendidas, etc.). Ese análisis
        habrá que realizarlo siempre que se vaya a implementar un nuevo método.

        Teniendo en cuenta todas las consideraciones anteriores, implementa esos 
        tres métodos para la clase Bombilla.
    */
      
    public void encenderBombilla() throws IllegalStateException{
        if (this.estadoBombilla)
            throw new IllegalStateException("No se puede encender una bombilla ya encendida.");
        this.estadoBombilla = true;
        this.vecesEncendida ++;
        Bombilla.bombillasEncendidas ++;
    }
    
    public void apagarBombilla() throws IllegalStateException{
        if(!this.estadoBombilla)
            throw new IllegalStateException("No se puede apagar una bombilla ya apagada.");
        this.estadoBombilla = false;
        Bombilla.bombillasEncendidas --;
    }
    
    public void conmutarBombilla(){
        this.estadoBombilla = !this.estadoBombilla;
        Bombilla.bombillasEncendidas += this.estadoBombilla ? 1 : -1;
        this.vecesEncendida += this.estadoBombilla ? 1 : 0;
    }
    
//--------------------------| MÉTODO TO-STRING |--------------------------------

    /*
        Una vez que ya disponemos de constructores y métodos de consulta de atributos, 
        es el momento de plantearse un posible método toString para esta clase. 
        Nos han propuesto el siguiente formato de salida:

            Bombilla xxx. Se ha encendido zzz veces

        donde xxx será el estado de la bombilla (encendida o apagada) y zzz el 
        número de veces que ha sido encendida hasta el momento. También queremos
        que si la bombilla se ha encendido una sola vez, aparezca la palabra "vez" 
        (singular) y no "veces" (plural).
    */
    @Override
    public String toString(){
        return String.format("Bombilla %s. Se ha encendido %d %s",
                this.estadoBombilla ? "encendida" : "apagada", this.vecesEncendida,
                this.vecesEncendida == 1 ? "vez" : "veces");
   
    }
}

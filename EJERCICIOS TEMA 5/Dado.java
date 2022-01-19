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
    Hemos recibido el encargo de implementar una clase que represente a los dados 
    de un juego de mesa. Los posibles dados para estos juegos son todos aquellos
    poliedros que tengan todas las caras iguales. Matemáticamente existen cinco 
    tipos diferentes (con cuatro, seis, ocho, doce o veinte caras). Son conocidos
    como los sólidos platónicos.

    Para cada dado queremos registrar la siguiente información:

        - el número de caras que tiene;
        - la cantidad de lanzamientos que se han realizado con él.
*/
public class Dado {
    
//---------------------------| ATRIBUTOS |--------------------------------------
    
    // VARIABLES DE CLASE
    
    // CONSTANTES DE CLASE
    
    public static final int[]   SOLIDOS_PLATONICOS  = {4,6,8,12,20};
    public static final int     CARAS_POR_DEFECTO   = 6;
    
    // VARIABLES DE OBJETO
    
    private int cantidadLanzamientos;   // Cantidad de lanzamientos del dado
    private int[] vecesCara;            // Veces que ha salido cada cara
    
    // CONSTANTES DE OBJETO
    private final int numeroCaras;      // Número de caras que tiene el dado
 
//----------------------------| CONSTRUCTORES |---------------------------------
    
    /*
        Para poder crear instancias de esta clase se nos ha sugerido implementar
        dos constructores: uno con un parámetro entero, que indique el número de 
        caras del dado, y otro sin parámetros, que instancie un dado de seis caras.
    */
    
    public Dado(int carasDado) throws IllegalArgumentException{
        boolean caras = false;
        for(int i = 0; i < Dado.SOLIDOS_PLATONICOS.length; i++){
            if(carasDado == Dado.SOLIDOS_PLATONICOS[i])
                caras = true;
        }
        if(!caras)
            throw new IllegalArgumentException("El número de caras introducido no es correcto.");
        this.numeroCaras = carasDado;
        this.cantidadLanzamientos = 0;
        this.vecesCara = new int[carasDado];
        for(int a = 0; a < carasDado; a++){
            this.vecesCara[a] = 0;
        }
    }
    public Dado(){
        this(Dado.CARAS_POR_DEFECTO);
    }
    
//-------------------------------| MÉTODOS |------------------------------------
    
    /*
        Respecto a los métodos get se ha decido disponer de métodos para obtener
        la siguiente información:

            - el número de caras del dado;
            - el número de lanzamientos que se han realizado con el dado.
    */
    
    // Método GET que devuelve el número de caras del dado:
    public int getCarasDado(){
        return this.numeroCaras;
    }
    
    // Método GET que devuelve el número de lanzamientos que se han realizado
    public int getLanzamientos(){
        return this.cantidadLanzamientos;
    }
    
    /*
        Para que los objetos de la clase Dado resulten de utilidad, han de poder
        lanzarse para obtener un resultado al azar. Se ha planteado un método
        llamado lanzar que devuelva un valor aleatorio equiprobable dentro de las 
        caras que tenga el dado. Se nos ha pedido además el valor devuelto sea de 
        tipo String y consista en una cadena que represente el número de la cara 
        en castellano. Es decir, que este método devolverá cadenas del tipo 
        "UNO", "DOS", "TRES", "CUATRO", etc.
    */
    
    /*
        Dado, nos ha llegado un nuevo requerimiento para que cada dado lleve un 
        registro del número de veces que ha salido cada cara.

        ¿Cómo afectaría esta nueva funcionalidad a la nueva clase Dado desde el 
        punto de vista de los atributos?
        
            Creada la variable array int vecesCara

        Teniendo en cuenta que ahora debemos registrar cada lanzamiento, ¿cómo 
        implementarías el método lanzar?
    
            En el constructor implementamos el tamaño del array, en el método
            lanzar sumamos en cada posición del vector el número de veces
            correspondiente.
    */
    
    public String lanzar(){
        String[] resultado = {"UNO","DOS","TRES","CUATRO","CINCO","SEIS","SIETE",
            "OCHO","NUEVE","DIEZ","ONCE","DOCE","TRECE","CATORCE","QUINCE",
            "DIECISÉIS","DIECISIETE","DIECIOCHO","DIECINUEVE","VEINTE"};
        int valorResultado;
        valorResultado = (int)(Math.random()*this.numeroCaras+1);
        this.cantidadLanzamientos ++;
        valorResultado --;
        this.vecesCara[valorResultado] ++;
        return resultado[valorResultado];
    }
    
    public int getNumeroVecesCara(int cara) throws IllegalArgumentException{
        if(cara < 1 || cara > this.vecesCara.length)
            throw new IllegalArgumentException("Cara del dado no válida");
        return this.vecesCara[cara - 1];
    }
    
//--------------------------| MÉTODO TO-STRING |--------------------------------
    
    /*
        En cuanto a una posible representación textual de los objetos de la clase
        Dado se nos ha propuesto el siguiente formato de salida:
        
            Número de caras: xxx. Número de lanzamientos: zzz.
        
        Donde xxx será el número de caras del dado y zzz el número de veces que
        ha sido lanzado hasta el momento.
    */
    
    @Override
    public String toString(){
        return String.format("Número de caras: %03d. Número de lanzamientos: %03d",
                this.numeroCaras, this.getLanzamientos());
    }
}

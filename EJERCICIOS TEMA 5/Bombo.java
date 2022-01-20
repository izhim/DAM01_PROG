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
public class Bombo {
    
/*
    Nuestra empresa ha entrado en contacto con un posible cliente dedicado a los 
    juegos de azar tradicionales que quiere lanzar una nueva línea de productos 
    digitales. Uno de los primeros productos será un bingo digital.

    El equipo de desarrollo ha recibido el encargo de representar un bombo de un 
    bingo. Para ello habrá que implementar una clase Bombo cuyos objetos contendrán 
    una serie de bolas que podrán ir extrayéndose una a una con la particularidad 
    de que una vez que se extraiga una bola ya no podrá volver a salir.

    El número de bolas con el que podemos configurar los bombos estará entre 9 y 90.

    Teniendo en cuenta esas especificaciones, realiza un análisis preliminar sobre 
    cuáles serían los atributos apropiados para implementar la clase Bombo.

*/
    
//------------------------------| ATRIBUTOS |-----------------------------------
    
    //  VARIABLES DE CLASE
    
    //  CONSTANTES DE CLASE
    
    public static final int MINIMO_BOLAS = 9;
    public static final int MAXIMO_BOLAS = 90;
    
    //  VARIABLES DE OBJETO
    
    private boolean[] bolasBombo;       //  Vector que indica si una bola (la posición en el array) ha salido
    
    //  CONSTANTES DE OBJETO
    
   // private final int capacidadBombo;   //  Cantidad de bolas con las que se crea el bombo
    
    
//----------------------------| CONSTRUCTORES |---------------------------------
    
/*
    Se han previsto dos constructores para esta clase:

        - un constructor con un parámetro, donde se indicará la capacidad del bombo 
        (número de bolas cuando esté lleno);
        - un constructor sin parámetros, que creará un bombo con la capacidad por 
        omisión (noventa bolas).
*/
    
    public Bombo(int bolas) throws IllegalArgumentException{
        if(bolas < Bombo.MINIMO_BOLAS)
            throw new IllegalArgumentException(String.format("Cantidad de bolas "
                    + "inferior al mínimo de %d bolas", Bombo.MINIMO_BOLAS));
        if(bolas > Bombo.MAXIMO_BOLAS)
            throw new IllegalArgumentException(String.format("Cantidad de bolas "
                    + "superior al máximo de %d bolas", Bombo.MAXIMO_BOLAS));
        this.bolasBombo = new boolean[bolas];
        for(int i = 0; i < bolas; i++){
            this.bolasBombo[i] = false;
        }
    }
    
    public Bombo(){
        this(Bombo.MAXIMO_BOLAS);
    }
    
//-------------------------------| MÉTODOS |------------------------------------
  
/*
    Como métodos get para esta clase se ha pensado en aquellos que permitan:

    - obtener la capacidad del bombo (número de bolas cuando está lleno): getCapacidad;
    - obtener la cantidad de bolas que quedan por salir: getCantidadBolasRestantes;
    - obtener la cantidad de bolas que ya han sido extraídas: getCantidadBolasExtraidas;
    - indicar si el bombo está completamente lleno: isCompleto;
    - indicar si el bombo está completamente vacío: isVacio.  
*/
    
    public int getCapacidad(){
        return(this.bolasBombo.length);
    }
    
    public int getCantidadBolasRestantes(){
        int bolasRestantes = 0;
        for(int j = 0; j < this.bolasBombo.length; j++){
            if(this.bolasBombo[j] == false)
                bolasRestantes++;
        }
        return bolasRestantes;
    }
    
    public int getCantidadBolasExtraidas(){
        return this.getCapacidad() - this.getCantidadBolasRestantes();
    }
    
    public boolean isCompleto(){
        return this.getCantidadBolasRestantes() == this.getCapacidad();
    }
    
    public boolean isVacio(){
        return this.getCantidadBolasExtraidas() == this.getCapacidad();
    }
/*
    El método "estrella" de esta clase es el de extracción de una bola, que debe 
    evitar que se repitan bolas. Si el número de bolas que quedan por salir es 
    cero, debería lanzarse una excepción, pues no se puede devolver ningún número
*/
    
    public int extraccionBola()throws IllegalStateException{
        if(this.isVacio())
            throw new IllegalStateException("No se pueden sacar bolas, el bombo está vacío.");
        int numero;
        do{
            numero = (int) (Math.random()*this.getCapacidad()) + 1;
        }while(this.bolasBombo[numero - 1] == true);
        this.bolasBombo[numero -1] = true;
        return numero;
    }
    
/*
    También se nos ha pedido un método llamado reset, sin parámetros, que reinicie 
    el bombo y lo vuelva a llenar con todas las bolas para empezar de nuevo. Este 
    método además devolverá un entero que será la cantidad de bolas que ha habido 
    que volver a introducir en el bombo.
*/
    
    public int reset(){
        int bolasDevueltas = 0;
        for(int k = 0; k < this.bolasBombo.length; k++){
            if(this.bolasBombo[k] == true){
                this.bolasBombo[k] = false;
                bolasDevueltas ++;
            }
        }
        return bolasDevueltas;
    }
    
/*
    Una vez que disponemos de una implementación básica y funcional de la clase 
    Bombo, nos han pedido una ampliación para que incorpore dos nuevos métodos 
    que permitan:

        1.- obtener un array con los números de bola que quedan en el bombo;
        2.- obtener un array con los números de bola que ya han salido del bombo.
*/
  
//  Creamos un método privado que realiza las dos operaciones que se piden según
//  sea su parámetro de entrada verdadero o falso, para posteriormente utilizarlo
//  en cada uno de los métodos requeridos con intención de no repetir código
    
    private short[] bolasRestantesExtraidas(boolean extraidas){
        short i;
        short j = 0;
        short[] bolas = new short[extraidas ? (short)this.getCantidadBolasExtraidas() : (short)this.getCantidadBolasRestantes()];
        for(i = 0; i < this.bolasBombo.length; i++){
            if(this.bolasBombo[i] == extraidas){
                bolas[j] = (short) (i + 1);
                j++;
            }
        }
        return bolas;
    }
    
/*
    Implementa el método public short[] getBolasExtraidas() que devuelve un array 
    con los números de las bolas que ya han salido del bombo.
*/
    public short[] getBolasExtraidas(){
        return bolasRestantesExtraidas(true);
    }
    
/*
    Implementa el método public short[] getBolasRestantes() que devuelve un array
    con los números de las bolas que aún permanecen en el bombo.
*/
     public short[] getBolasRestantes(){
        return bolasRestantesExtraidas(false);
    }
    
//---------------------------| MÉTODO TO-STRING |-------------------------------
  
/*
    En cuanto a una posible representación textual de los objetos Bombo, se ha 
    planteado el siguiente formato:

        Capacidad: xx bolas. Cantidad de bolas extraídas: zz
        donde xx será la capacidad del bombo (número de bolas cuando está lleno) 
        y zz el número de bolas que han sido extraídas hasta el momento. Algunos 
        ejemplos de salida podrían ser:

            - Capacidad: 90 bolas. Cantidad de bolas extraídas: 0
            - Capacidad: 9 bolas. Cantidad de bolas extraídas: 9
            - Capacidad: 10 bolas. Cantidad de bolas extraídas: 7
            - Capacidad: 90 bolas. Cantidad de bolas extraídas: 63 
*/

    @Override
    public String toString(){
        return String.format("Capacidad: %02d bolas. Cantidad de bolas extraídas: %02d."
                , this.getCapacidad(), this.getCantidadBolasExtraidas());
    }
}

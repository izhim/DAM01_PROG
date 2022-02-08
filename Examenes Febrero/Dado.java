/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Implementa una clase Dado que represente a un dado con las siguientes
propiedades y comportamiento:
a. Una instancia de la clase Dado sólo podrá ser de cuatro, seis u ocho caras. Los únicos atributos
que necesitas para representar a un dado serán el número de caras y el número de veces que
ha sido lanzado desde que se creó.
b. Se dispondrá de dos constructores:
◦ Un constructor con un parámetro, donde se indicará el número de caras para el dado. Si el
número de caras no es válido (cuatro, seis u ocho), se lanzará una excepción de tipo
IllegalArgumentException.
◦ Un constructor sin parámetros, donde se tendrá el valor 6 como el número de caras por
omisión.
c. Dos métodos getNumCaras y getNumLanzamientos, que devolverán el número de caras del
dado y el número de veces que ha sido lanzado desde que se creó.
d. Un método toString, que devuelva una cadena del tipo “Dado de xxx caras. Se ha lanzado zzz
veces”, donde xxx será el número de caras del dado y zzz el número de veces que ha sido lanzado
hasta el momento.
e. Un método lanzar, que devolverá un String con un valor aleatorio representando la cara que ha
salido al lanzar el dado. El valor devuelto será un String con valores como “UNO”, “DOS”,
“TRES”, “CUATRO”, etc. y no un int. Recuerda que no existe cara “CERO” en un dado.
f. En la misma clase Dado, crea un método main() donde:
 Se instancie un dado con el constructor sin parámetros y se muestren sus datos usando
toString().
 Se intente instanciar un dado con un número de caras inválido (por ejemplo 7), de
manera que se genere una excepción que habrá que capturar con una estructura trycatch.
 Se instancie un dado con 4 caras, se muestren sus datos por pantalla, usando los métodos
getNumCaras y toString. Y a continuación, se lance 10 veces (bucle for),
mostrándose en pantalla el valor obtenido en cada lanzamiento.
 Una vez realizados todos los lanzamientos del último dado (4 caras) se mostrará en
pantalla de nuevo los datos del dado usando toString().
Aquí tienes un ejemplo de la salida por pantalla tras una ejecución de prueba:

    DADOS
    -----
    Prueba del constructor sin parámetros:
    Creado objeto: Dado de 6 caras. Se ha lanzado 0 veces
    Prueba del constructor con parámetros con valor inválido:
    Error. Número de caras inválido: 7.
    Prueba del constructor con parámetros con valor 4:
    Prueba del getNumCaras: 4
    Prueba del toString: Dado de 4 caras. Se ha lanzado 0 veces
    Pruebas de lanzamiento: UNO CUATRO TRES DOS CUATRO UNO CUATRO CUATRO CUATRO
    UNO
    Estado final del dado (toString): Dado de 4 caras. Se ha lanzado 10 veces
*/
package examenfeb21_1;

import java.util.InputMismatchException;

/**
 *
 * @author JOSE
 */
public class Dado {

    //  CONSTANTES DE CLASE
    private final static int[] NUMERO_CARAS_PERMITIDAS = {4,6,8};
    private final static String[] NUMERO_CARAS = {"UNO","DOS","TRES","CUATRO","CINCO","SEIS","SIETE","OCHO"};
    
    //  VARIABLES DE OBJETO
    private int numCaras;
    private int vecesLanzado;
    
    //  CONSTRUCTOR DE 1 PARÁMETRO
    public Dado(int numCaras) throws IllegalArgumentException{
        boolean esCorrecto = false;
        for(int cont = 0; cont < Dado.NUMERO_CARAS_PERMITIDAS.length; cont++){
            if(numCaras == Dado.NUMERO_CARAS_PERMITIDAS[cont])
                esCorrecto = true;
        }
        if(!esCorrecto)
            throw new IllegalArgumentException("Número de caras inválido: " + numCaras);
        this.numCaras = numCaras;
        this.vecesLanzado = 0;
    }
    
    //  CONSTRUCTOR SIN PARÁMETROS
    public Dado(){
        this(NUMERO_CARAS_PERMITIDAS[1]);
    }
    
    //  MÉTODOS GETTER DE OBJETO
    public int getNumCaras(){
        return this.numCaras;
    }
    public int getNumLanzamientos(){
        return this.vecesLanzado;
    }
    
    //  MÉTODO TOSTRING
    @Override
    public String toString(){
        return(String.format("Dado de %d caras. Se ha lanzado %d %s",
                this.numCaras, this.vecesLanzado,
                this.vecesLanzado == 1 ? "vez" : "veces"));
    }
    
    //  MÉTODO lanzar
    public String lanzar(){
        int valorAleatorio = (int) (Math.random() * this.numCaras);
        this.vecesLanzado ++;
        return(Dado.NUMERO_CARAS[valorAleatorio]);
    }
    
    
    public static void main(String args[]) {
        
        //  CONSTANTES
        final int PRUEBA_INVALIDA = 7;
        final int PRUEBA_VALIDA = 4;
        final int NUM_TIRADAS = 10;
        
        System.out.println("Probando constructor sin parámetros.");
        Dado dado1 = new Dado();
        System.out.println("Dado creado:" + dado1.toString());
        System.out.println();
        
        //  PRUEBA INVÁLIDA
        System.out.println("Prueba del constructor con parámetros con valor inválido.");
        try{
            Dado dado2 = new Dado(PRUEBA_INVALIDA);
        }catch (IllegalArgumentException ex1){
            System.out.println("ERROR: " + ex1.getMessage());
        }catch (InputMismatchException ex2){
            System.out.println("ERROR: El valor no es un número");
        }
        System.out.println();
        
        //  PRUEBA VÁLIDA
        System.out.println("Prueba del constructor con parámetros con valor válido.");
        try{
            Dado dado3 = new Dado(PRUEBA_VALIDA);
            System.out.println("Prueba del toString: " + dado3.toString());
            System.out.println("Prueba del método getNumCaras: " + dado3.getNumCaras());
            System.out.println("Pruebas de lanzamiento.");
            for(int cont = 0; cont < NUM_TIRADAS; cont++){
                System.out.print(dado3.lanzar() + " ");
            }
            System.out.println();
            System.out.println("Estado final del dado: " + dado3.toString());
        }catch (IllegalArgumentException ex1){
            System.out.println("ERROR: " + ex1.getMessage());
        }catch (InputMismatchException ex2){
            System.out.println("ERROR: El valor no es un número");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.tema.pkg5;

import static ejercicios.tema.pkg5.Ticket.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author JOSE
 */
public class Ejercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//-----------------------| PRUEBAS DE LA CLASE BOMBILLA |-----------------------
        
        System.out.println("PRUEBA DE CLASE BOMBILLA");
        System.out.println("------------------------\n");
        System.out.println("Cantidad de bombillas creadas: " + Bombilla.getBombillasCreadas());
        System.out.println();
        System.out.println("Cantidad de bombillas encendidas: " + Bombilla.getBombillasEncendidas());
        System.out.println();
        Bombilla b1 = new Bombilla();
        System.out.println("Estado de la bombilla b1: \n" + b1.getEstadoBombilla());
        System.out.println();
        Bombilla b2 = new Bombilla(true);
        System.out.println("Estado inicial de la bombilla b2: \n" + b2.toString());
        System.out.println();
        for(int i = 0; i < 3; i++){
            b2.conmutarBombilla();
        }
        System.out.println("Estado de la bombilla b2 tras conmutar 3 veces: \n" + b2.toString());
        System.out.println();
        for(int i = 0; i < 2; i++){
            System.out.println("Estado de la bombilla b2 al encender 2 veces:");
            try{
                
                b2.encenderBombilla();
                System.out.println(b2.toString() + "\n");
            }catch(IllegalStateException ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
        System.out.println();
        System.out.println("Estado de la bombilla b2 al apagar: ");
        try{
            b2.apagarBombilla();
            System.out.println(b2.toString());
        }catch(IllegalStateException ex){
                System.out.println("Error: " + ex.getMessage());
        }
        System.out.println();
        System.out.println("Estado de la bombilla b2 tras encenderla:");
        try{
            b2.encenderBombilla();
            System.out.println(b2.toString());
        }catch(IllegalStateException ex){
                System.out.println("Error: " + ex.getMessage());
        }
        System.out.println();
        Bombilla b3 = new Bombilla(true);
        System.out.println("Estado de la bombilla b3: \n" + b3.toString());
        System.out.println();
        System.out.println("Total de bombillas creadas: " + Bombilla.getBombillasCreadas());
        System.out.println("Total de bombillas encendidas: " + Bombilla.getBombillasEncendidas());
        System.out.println("\n\n");
        System.out.println("PRUEBA DE CLASE TICKET");
        System.out.println("----------------------\n");
        
        Ticket t1 = random();
        System.out.println("Ticket aleatorio en este año: ");
        System.out.println(t1.toString());
        System.out.println("Ticket aleatorio en este mes: ");
        Ticket t2 = randomEsteMes();
        System.out.println(t2.toString());
        System.out.println("Ticket con valores por defecto: ");
        Ticket t3 = new Ticket();
        System.out.println(t3.toString());
        System.out.println(t3.getFecha());
        System.out.println(LocalDate.now());
        try{
            t3.usar();
            System.out.println("Ticket t3 usado: ");
            System.out.println(t1.toString());
        }catch (IllegalStateException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        try{
            t3.usar();
            System.out.println("Ticket t3 usado: ");
            System.out.println(t1.toString());
        }catch (IllegalStateException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        try{
            t2.usar();
            System.out.println("Ticket t2 usado: ");
            System.out.println(t1.toString());
        }catch (IllegalStateException ex){
            System.out.println("Error: " + ex.getMessage());
        }
        Ticket[] tickets = new Ticket[10];
        for(int i = 0; i < 10; i++){
            try{
                tickets[i] = randomEsteMes();
                System.out.println(tickets[i].toString());
            }catch (IllegalStateException ex){
                System.out.println("Error: " + ex.getMessage());
            }catch (IllegalArgumentException ex2){
                System.out.println("Error: " + ex2.getMessage());
            }
            
        }
        
//-------------------------| PRUEBAS DE LA CLASE DADO |-------------------------
        
        System.out.println(" \n");
        System.out.println("PRUEBA DE CLASE DADO");
        System.out.println("----------------------\n");
        try{
            Dado dado = new Dado();
            for(int i = 0; i < 10; i++){
                System.out.printf("Dado de %d caras. Tirada número %d: %s \n"
                        , dado.getCarasDado(),i+1, dado.lanzar());
                System.out.println(dado.toString());
            }
            try{
                for(int k = 1; k <= dado.getCarasDado(); k++){
                    System.out.printf("Número de veces que ha salido %d: %d\n",
                            k, dado.getNumeroVecesCara(k));
                }
            }catch(IllegalArgumentException ex2){
                System.out.println("Error: " + ex2.getMessage());
            }
        }catch(IllegalArgumentException ex){
                System.out.println("Error: " + ex.getMessage());
        }
    
//-------------------------| PRUEBAS DE LA CLASE BOMBO |------------------------
 
/*
    Implementa un programa de prueba para la clase Bombo que lleve a cabo las 
    siguientes acciones:

        1.- Cree un bombo con la capacidad por omisión y muestre su estado 
            (método toString).
        2.- Solicite por teclado un número entero como capacidad para el bombo.
        3.- Intente crear un bombo con esa capacidad. Si no es posible porque la 
            capacidad no es válida (salta una excepción) o bien porque se introduce 
            algún valor inapropiado como número entero, entonces el programa finaliza.
        4.- Si el bombo ha podido ser creado correctamente, mostramos el estado 
            del bombo (método toString).
        5.- A continuación se ejecutará un bucle en el que se irán realizando 
            extracciones de bolas y se irán mostrando por pantalla hasta que 
            salte la excepción por bombo vacío.
        6.- Una vez que el bombo esté vacío se muestra el estado del bombo 
            (método toString).
*/
        Scanner sc = new Scanner(System.in);
        int capacidadBombo;
        boolean error;
        System.out.println(" \n");
        System.out.println("PRUEBA DE CLASE BOMBO");
        System.out.println("----------------------\n");

    //  1.- Creación del bombo con la capacidad por omisión
        
        Bombo bombo = new Bombo();
        System.out.println(bombo.toString());
        
    //  2.- Creación del bombo con cantidad introducida por teclado
        do{        
            try{    //  En este caso en vez de dar por finalizado el programa volvemos a solicitar el valor
                error = false;
                System.out.print("Por favor, introduzca una capacidad para el bombo: ");
                capacidadBombo = sc.nextInt();
                System.out.println();
                Bombo bombo2 = new Bombo(capacidadBombo);
                System.out.println(bombo2.toString());
                
        // 5.- Ejecutamos un bucle de extracción de bolas hasta que el bombo quede vacío
                do{
                    System.out.printf("Ha salido el número: %d \n", bombo2.extraccionBola());
                }while(!bombo2.isVacio());
                System.out.println();
                System.out.println(bombo2.toString());

        // excepción si el número introducido no es válido
            }catch(IllegalArgumentException ex2){       
                System.out.println("Error: " + ex2.getMessage());
                error = true;
        // excepción si el formato introducido no es válido
            }catch(InputMismatchException ex){          
                System.out.println("Error: Formato introducido no válido.");
                sc.nextLine();
                error = true;
            }
            System.out.println();
        }while(error);
        
/*
    Por último, nos quedaría implementar algún programa de prueba para comprobar
    que esta clase funciona correctamente. Podríamos escribir por ejemplo un 
    programa que generara un bombo de capacidad nueve bolas, que fuera extrayendo 
    las bolas una a una y que se fueran mostrando por pantalla la lista (array) 
    de bolas extraídas y la de bolas restantes.    
*/    
        System.out.printf("Instanciando bombo de capacidad %d bolas \n",Bombo.MINIMO_BOLAS);
        
        Bombo bombo3 = new Bombo(Bombo.MINIMO_BOLAS);
        System.out.println("Bombo creado.");
        System.out.printf("Estado inicial: %s \n",bombo3.toString());
        System.out.printf("Extraídas: %s \n", Arrays.toString(bombo3.getBolasExtraidas()));
        System.out.println("Prueba de extracción de bolas:");
        try{
            for(int i = 0; i <= bombo3.getCapacidad(); i++){
                System.out.printf("Bola extraída: %d\n", bombo3.extraccionBola());
                System.out.printf("Array de bolas extraídas: %s \n", Arrays.toString(bombo3.getBolasExtraidas()));
                System.out.printf("Array de bolas restantes: %s \n", Arrays.toString(bombo3.getBolasRestantes()));
            }
        }catch(IllegalStateException ex2){
            System.out.println("Error: " + ex2.getMessage());
        }
        System.out.printf("Estado final del bombo: %s", bombo3.toString());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.tema.pkg5;

import static ejercicios.tema.pkg5.Ticket.*;
import java.time.LocalDate;

/**
 *
 * @author JOSE
 */
public class Ejercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
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
        
    }
}

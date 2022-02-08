/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Crea un programa que esté continuamente leyendo sueldos hasta que se
escriba “fin”.
 Lee un sueldo en euros (número real).
 Considerando que el sueldo anterior se cobra 12 veces al año, calcula cuánto dinero ahorra en un
año si cada semana ahorra 15% de su sueldo. Considera cuatro semanas por mes.
Podemos ver un ejemplo de ejecución a continuación, donde puedes observar que al introducir valores

    incorrectos se vuelve a pedir al usuario un valor numérico correcto:
    Introduce un el sueldo semanal de una persona (o fin para terminar): a
    ERROR: número no válido.
    Introduce un el sueldo semanal de una persona (o fin para terminar): 1200
    Ahorro semanal: 180,00 Ahorro mensual: 720,00 Ahorro anual: 8640,00
    Introduce un el sueldo semanal de una persona (o fin para terminar): 50a
    ERROR: número no válido.
    Introduce un el sueldo semanal de una persona (o fin para terminar): 500
    Ahorro semanal: 75,00 Ahorro mensual: 300,00 Ahorro anual: 3600,00
    Introduce un el sueldo semanal de una persona (o fin para terminar): fin
*/
package examenfeb21_1;

import java.util.Scanner;

/**
 *
 * @author JOSE
 */
public class ExamenFeb20_1DAW {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //  CONSTANTES
        final String FIN = "fin";
        final int porcentaje = 15;

        //  VARIABLES
        String entrada;
        float sueldo;
        Scanner sc = new Scanner(System.in);
        float semanal, mensual, anual;
        
        do{
            System.out.print("Introduzca un sueldo (o fin para terminar): ");
            entrada = sc.nextLine();
            if(!entrada.toLowerCase().equals(FIN))
                try{
                    sueldo = Float.parseFloat(entrada);
                    semanal = sueldo * porcentaje / 100;
                    mensual = semanal * 4;
                    anual = mensual * 12;
                    System.out.printf("Ahorro semanal: %.2f Ahorro mensual: %.2f Ahorro anual: %.2f\n",
                            semanal, mensual, anual);
                }catch(Exception ex){
                    System.out.println("ERROR: Número no válido.");
            }
        }while(!entrada.toLowerCase().equals(FIN));
        
    }
}

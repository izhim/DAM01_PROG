/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Realizar un programa que esté iterando continuamente haciendo lo siguiente
hasta que se introduzca la palabra “end” o “END” al pedir el precio:
 Pedir precio base de un artículo (de tipo real float) por teclado.
 Si no se ha introducido “end” o “END”, se realizará lo siguiente:
◦ Pedir tanto por ciento de descuento (entero) del artículo.
◦ Si el precio base y el descuento son ambos mayores que cero entonces deberá calcular cuánto
se debe pagar por ese artículo. Primero aplica el descuento, y a continuación, aplica un 15%
de IVA. Debe mostrar el precio con descuento y el precio final.
◦ Si el precio base o el descuento no son mayores de cero, deberá mostrar por pantalla el texto:
“El precio y el descuento deben ser mayores de 0”.
Podemos ver una ejecución de ejemplo a continuación, donde puedes observar que al introducir valores
incorrectos se vuelve a pedir al usuario un valor numérico correcto:

    Introduzca el precio del artículo (o bien end para terminar): 10
    Introduzca el % de descuento del artículo: 0
    El precio y el descuento deben ser mayores que 0.
    Introduzca el precio del artículo (o bien fin para terminar): a
    Error, número esperado en la entrada de datos
    Introduzca el precio del artículo (o bien fin para terminar): 20
    Introduzca el % de descuento del artículo: a
    Error en la entrada de datos
    Introduzca el precio del artículo (o bien fin para terminar): 20
    Introduzca el % de descuento del artículo: 2
    Precio: 20,00 Con el descuento: 19,60 Con el IVA: 22,54
    Introduzca el precio del artículo (o bien fin para terminar): end
*/

package examenfeb21_1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author JOSE
 */
public class ExamenFeb20_1DAM {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        //  CONSTANTES
        final String FIN = "end";
        final int IVA = 15;
        
        //  VARIABLES
        String entrada;
        float precio, descontado, conIva;
        int descuento;
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        
        do{
            System.out.print("Introduzca el precio del artículo (o bien end para terminar): ");
            entrada = sc.nextLine();
            if(!entrada.toLowerCase().equals(FIN)){
                try{
                   precio = Float.parseFloat(entrada);
                   System.out.print("Introduzca el % de descuento del artículo: ");
                       descuento = sc2.nextInt();
                       if(precio > 0 && descuento > 0){
                           descontado = precio*(1-(float)(descuento*0.01));
                           conIva = descontado*(1+(float)(IVA*0.01));
                           System.out.printf("Precio: %.2f Con el descuento: %.2f Con el IVA: %.2f\n",
                                   precio, descontado,conIva) ;
                       }else
                           System.out.println("El precio y el descuento deben ser mayores de 0.");
                }catch(NumberFormatException ex){
                    System.out.println("Error: número esperado en la entrada de datos: ");
                }
                catch(InputMismatchException ex2){
                       System.out.println("Error: valor no válido.");
                }     
            }
        }while(!entrada.toLowerCase().equals(FIN));
    }
}

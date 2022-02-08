/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Dado el siguiente programa que ya tiene implementada la entrada de datos y
la salida de resultados, escribir el código necesario en Java para que se procese el array de entrada
con números de serie y se rellene un array de salida indicando para cada número de serie si es
válido o no (cadena “válido” o “inválido”).
Los requisitos que debe cumplir un número de serie para ser válido son:
1. Debe comenzar por dos letras mayúsculas. La primera obligatoriamente tiene que ser X o Y. La
segunda puede ser cualquiera (sin contar la eñe).
2. A continuación habrá un guión (‘-’).
3. Ha de terminar por un año que debe encontrarse entre 1970 y el año actual.
4. Si el año es impar, la primera letra del número de serie debe ser ‘Y’. Si el año es par, la primera
letra debe ser ‘X’.
El resultado que debe proporcionar el programa es el siguiente:

    VALIDADOR DE NÚMEROS DE SERIE
    -----------------------------
    Lista de números de serie de prueba:
    [ZA-2000, XAZ2000, XA2000, XA-1969, YH-1969, XQ-1970, XJ-2002, YV-2021, XB-2022, YV-
    2022, YA-1970, YH-2002, XB-2021]
    RESULTADO
    ---------
    El resultado de la comprobación de la validez de los números de serie es:
    [inválido, inválido, inválido, inválido, inválido, inválido, inválido, inválido,
    inválido, inválido, válido, válido, válido]

Tan solo hay que implementar la parte del procesamiento así como declarar y utilizar todas las
variables auxiliares que consideres oportunas. La entrada de datos y la salida de resultados están ya
hechas y no hay que tocar nada.
En el procesamiento que implementes podrás hacer uso de expresiones regulares para facilitarte el
trabajo (es lo más recomendable), aunque habrá comprobaciones que no podrás realizar mediante
expresiones regulares y que tendrás que hacer “a mano” mediante código.
¡Y no olvides reservar el espacio apropiado para el array de salida procurando no usar un literal! (El tamaño
debe ser el mismo que del array de entrada).
*/

package examenfeb21_1;

import java.util.regex.*;

/**
 *
 * @author JOSE
 */
public class ExamenFeb21_2DAW {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        final String[]ENTRADA_DATOS = {"234/24","24/234","31/531","ABCD/ABCD","ABC/CBA",
            "23456/65432","23/23","32/23","23/32","32/32","0/0","122/122","3301/1033"};
        
        //  VARIABLES
        String[] resultado = new String[ENTRADA_DATOS.length];
        String[] numSerie;
        int[] valores ={0,0};
        int inverso = 0;
        int numero, resto;
        boolean valido;
        
        Pattern p = Pattern.compile("^[\\d]+/[\\d]+");
        for(int cont = 0; cont < ENTRADA_DATOS.length; cont++){
            valido = false;
            Matcher m = p.matcher(ENTRADA_DATOS[cont]);
                if(m.matches()){
                    numSerie = ENTRADA_DATOS[cont].split("/");
                    valores[0] = Integer.parseInt(numSerie[0]);
                    valores[1] = Integer.parseInt(numSerie[1]);

        //  CÁLCULO DEL NÚMERO INVERSO
                    numero = valores[0];
                    inverso = 0;
                    while(numero > 0){
                        resto = numero % 10;
                        inverso = inverso * 10 + resto;
                        numero /= 10;
                    }
                    
        //  COMPROBACIÓN DE LOS VALORES SEGÚN SI ES PAR O IMPAR
                    valido = ((valores[0]%2 == 0)&& (valores[0] == valores[1])
                            || (valores[0]%2 != 0)&& (valores[1] == inverso)
                            ? true : false);
                }
            resultado[cont] = valido ? "si" : "no";
        }
        System.out.println("El resultado de la comprobación de la validez de los números de serie es:");
        for(int i = 0; i < resultado.length; i++){
            System.out.print(resultado[i]+" ");
        }
    }
}

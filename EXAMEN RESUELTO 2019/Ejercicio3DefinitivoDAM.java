/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.util.Scanner;

/**
 * Examen DAM.
 * Comprobacion de código.
 * @author salva
 */
public class Ejercicio3DefinitivoDAM {
    public static void main(String[] args) {
        
//        String[] prueba = new String[10]; //- no tiene que hacerla el alumnado
        
        /* Generación de códigos de prueba - no tiene que hacerla el alumnado */        
//        char[] letters={'V','X'};
//        for (int i=0;i<prueba.length;i++)
//        {   
//            int i1=(int)(Math.random()*90+10);
//            int i2=(int)(Math.random()*900+100);            
//            char letra=letters[(i1*i2)%2];
//            prueba[i]=""+i1+"-"+i2+"-"+letra;            
//        }
        
        /* Comprobación de los códigos de prueba - no tiene que hacerla el alumnado*/
//        for (int i=0;i<prueba.length;i++)
//            checkCode(prueba[i]);
        
        /* Código a realizar por el alumnado */
        Scanner sc=new Scanner(System.in);        
        System.out.println("Introduce un número un código:");
        String codigo=sc.next().trim();
        checkCode(codigo);
        
           
    }   
    
    /**
     * Método que comprueba si el código sigue el formato "NN-NNN-L".
     * (N es un número y L es una letra que será V o X)
     * - Si (NN * NNN) % 2 es 0, L debería ser 'V'.
     * - Si (NN * NNN) % 2 es 1, L debería ser 'X'.
     * @param codigo código a comprobar (distingo de null)
     */
    public static void checkCode (String codigo)
    {
        
        // Solución admitida como correcta:
        String pattern="[0-9]{2}-[0-9]{3}-[VX]";
        // Solución más completa:
        // String pattern="[1-9][0-9]{1}-[1-9][0-9]{2}-[VX]";
        if (codigo.matches(pattern))
        {
            String[] partes=codigo.split("-");
            int num=Integer.parseInt(partes[0])*Integer.parseInt(partes[1]);
            num=num%2;                      
            char letra=partes[2].charAt(0);
            if (num==0 && letra=='V' || num==1 && letra=='X')
            {
                System.out.printf("Código %s válido.\n",codigo);
            }
            else
            {
                System.out.println("Código no válido.");
            }
        } else {
            System.out.println("Formato de código no válido.");
        }       
    }
}

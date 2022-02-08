package examen;

/**
 * Ejercicio 1.
 * 
 * El siguiente código genera un número aleatorio entre 0 y 9, ambos incluidos:
 *
 * i=(int)(Math.random()*10);
 *
 * En este ejercicio deberás rellenar un array de 20 elementos con números
 * enteros entre 0 y 9 elegidos al azar. Para hacerlo, deberás seguir los
 * siguientes criterios:
 *
 * ? La primera posición del array se rellenará con un número aleatorio.
 * 
 * ? A partir de ahí, el resto de posiciones del array se rellenarán con un número
 * aleatorio mayor o igual al de la posición anterior. Solo habrá una excepción
 * a esta regla, si el número justo anterior es 9, situación en la cual el
 * número podrá ser cualquiera entre 0 y 9. 
 * 
 * ? Una vez relleno el array, este array se mostrará por pantalla siguiendo
 * igual que en el siguiente ejemplo: "{89589066788895913897}"
 *
 * @author salva
 */
public class Ejercicio1 {
    public static void main (String args[])
    {
        int[] array=new int[20];
        
        array[0]=(int)(Math.random()*10);
        
        for (int i=1;i<array.length;i++)
        {
            boolean completado=false;
            do
            {   
                int numAle=(int)(Math.random()*10);
                if (array[i-1]<=numAle || array[i-1]==9)
                {
                    array[i]=numAle;              
                    completado=true;
                }
            } while (!completado);            
        }
        
        System.out.print("{");
        for (int i=0;i<array.length;i++)
        {
            System.out.print(array[i]);
        }
        System.out.print("}");
    }
}

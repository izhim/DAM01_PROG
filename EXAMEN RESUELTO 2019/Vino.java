package examen;

/**
 * Clase para representar vino. Constará del código del vino, la denominación 
 * del mismo, los grados que posee, el origen (Ribera, Jumilla, etc) y además
 * tendrá un atributo par lleva la cuenta del total de vinos de que se diponga,
 * o sea, del total de objetos creados.
 * 
 * @author JJBH
 */
public class Vino {
            
    private int codigo ;
    private String denominacion ;
    private float grados ;
    private String origen ;
    private static int numVinos ;

    
    /**
     * Constructor por defecto.
     * 
     */
    public Vino() {
        // Llamada al constructor con parámetros
        this(1, "Vino peleón", 25,"Jumilla") ;
    }

    
    /**
     * 
     * @param codigo
     * @param denominacion
     * @param grados
     * @param origen 
     */
    public Vino(int codigo, String denominacion, float grados, String origen) throws IllegalArgumentException {
        if (codigo < 0 || grados <0) {
            throw new IllegalArgumentException("Error: parámetros no válidos en el constructor") ;
        } else {
            this.codigo = codigo;
            this.denominacion = denominacion;
            this.grados = grados;
            this.origen = origen;
            Vino.numVinos ++ ;
        }
    }

    @Override
    public String toString() {
        return "Vino{" + "codigo=" + codigo + ", denominacion=" + denominacion + ", grados=" + grados + ", origen=" + origen + '}';
    }
      
    
    /**
     * Comprueba si el origen del vino es Rioja y los grados son mayores o 
     * iguales que 17
     * @return true si es Rioja de 17 grados o mas, false en caso contrario.
     */
    public boolean isRiojaFuerte() {
        boolean resultado = false ;
        if (this.origen.equalsIgnoreCase("Rioja") && this.grados >= 17)
            resultado = true ;
        return resultado ;
    }
  
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear objeto con el constructor por defecto
        Vino chatico = new Vino() ;
        System.out.println("Crear vino 1 con el constructor por defecto:" );
        System.out.println(chatico.toString()) ;
        
        System.out.println("\nCrear vino 2 con el constructor con parámetros:" );
        Vino copiRioja = new Vino(2, "Conmorcillo Rioja Reserva", 19, "Rioja");
        System.out.println(copiRioja.toString());
        if (copiRioja.isRiojaFuerte())
            System.out.println("Es rioja fuerte");
        else
            System.out.println("No rioja es fuerte");

        System.out.println("\nModificar graduación vino 2 a 15 grados:" );        
        copiRioja.setGrados(15);
        System.out.println(copiRioja.toString());       
        if (copiRioja.isRiojaFuerte())
            System.out.println("Es rioja fuerte");
        else
            System.out.println("No rioja es fuerte");
        
        
        try {
            System.out.println("\nIntentar crear vino 3 con datos incorrectos (-7 grados):" );
            Vino copaDeMas = new Vino(3, "Viña Solaz", -7, "Rioja") ;
        }catch(IllegalArgumentException e){
            System.out.println(e.toString());                
        } 
        
        System.out.println("\nTotal vinos: " + Vino.getNumVinos()) ;
    }

    
    public static int getNumVinos() {
        return numVinos;
    }

    public static void setNumVinos(int aNumVinos) {
        numVinos = aNumVinos;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public float getGrados() {
        return grados;
    }

    public void setGrados(float grados) {
        this.grados = grados;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    
    
    
    
    
}

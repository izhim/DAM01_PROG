/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenfeb21_1;

/**
 *
 * @author JOSE
 */
public class CamionDeReparto {
    
    //  CONSTANTES DE OBJETO
    private static final int CANTIDAD_REPARTOS = 3;
    
    //  VARIABLES DE OBJETO
    private final double cargaInicial = 0;
    private double cargaKilos;
    private double[] repartoKilos = new double[CANTIDAD_REPARTOS];
    
    //  CONSTRUCTOR
    public CamionDeReparto(){
        this.cargaKilos = cargaInicial;
    }
    
    //  MÉTODOS DE OBJETO
    public void cargar(double kilos){
        this.cargaKilos += kilos;
    }
    public boolean descargar(double kilos){
        if(this.cargaKilos <= kilos){
            this.cargaKilos -= kilos;
            return(true);
        }else
            return(false);
    }
    public double cargaActual(){
        return this.cargaKilos;
    }
    
    //  MÉTODO TOSTRING
    @Override
    public String toString(){
        return String.format("La carga actual es: %.2f", this.cargaKilos);
    }
}

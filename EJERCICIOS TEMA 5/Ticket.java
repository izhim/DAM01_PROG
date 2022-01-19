/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.tema.pkg5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author JOSE
 */
public class Ticket {
    
//----------------------------| ATRIBUTOS |-------------------------------------
    
    //  VARIABLES DE CLASE
    
    private static int numeroID = 0;
    private static int anioID = LocalDate.now().getYear();
    
    //  CONSTANTES DE CLASE
    
    public static final int MAX_NUMERO_IDENTIFICADOR = 99999999;
    
    //  VARIABLES DE OBJETO
    
    private LocalTime   horaUtilizado;      //  Registra la hora a la que el ticket ha sido utilizado
        
    //  CONSTANTES DE OBJETO
    
    private final String        identificador;    //  Parte del identificador correspondiente al número de ticket
    private final LocalDate     fechaTicket;      //  Fecha de operación del ticket
    
    
    
//---------------------------| CONSTRUCTORES |----------------------------------
    
    public Ticket(LocalDate fechaOperacion) throws IllegalArgumentException, IllegalStateException{
        if(fechaOperacion == null)
            throw new IllegalArgumentException("Fecha introducida no válida");
        if(fechaOperacion.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Fecha de operación anterior a la fecha actual");
        if(fechaOperacion.getYear() > LocalDate.now().getYear())
            throw new IllegalArgumentException("No se pueden registrar operaciones en años futuros");
        if(Ticket.numeroID == MAX_NUMERO_IDENTIFICADOR)
            throw new IllegalStateException("Cantidad de tickets excedida por este año");
        if(Ticket.anioID != LocalDate.now().getYear()){
            Ticket.anioID = LocalDate.now().getYear();
            Ticket.numeroID = 0;
        }
        this.horaUtilizado = null;
        this.fechaTicket = fechaOperacion;
        Ticket.numeroID ++;
        this.identificador = String.format("%04d-%08d", Ticket.anioID, Ticket.numeroID);
    }
    
    public Ticket(){
        this(LocalDate.now());
    }
    
//-----------------------------| MÉTODOS |--------------------------------------
    
    public String getID(){
        return this.identificador;
    }
    
    public LocalDate getFecha(){
        return this.fechaTicket;
    }
    
    public boolean isUsado(){
        return (this.horaUtilizado != null ? true : false);
    }
    
    public boolean isFinDeSemana(){
        return (this.fechaTicket.getDayOfWeek() == DayOfWeek.SATURDAY
                || this.fechaTicket.getDayOfWeek() == DayOfWeek.SUNDAY);
    }
    
    /*
        Cuando un ticket vaya a ser utilizado podrá ejecutarse el método usar,
        que tendrá que comprobar:
            1.- si nos encontramos en la fecha de uso del ticket (la fecha actual
                coincide con la fecha de uso).
            2.- si el ticket ha sido ya usado o no.
        En caso de que el ticket sea "usable", entonces habrá que marcarlo como
        usado y registrar la hora y minuto en que fue usado.
    */
    public void usar()throws IllegalStateException{
        if(!this.fechaTicket.equals(LocalDate.now()))
            throw new IllegalStateException("La fecha de uso no coincide con la fecha actual");
        if(this.isUsado())
            throw new IllegalStateException("El ticket ya ha sido utilizado");
        this.horaUtilizado = LocalTime.now();
    }
    
    /*
        Se implementan dos métodos de clase para generar tickets con fechas aleatorias:
            1.- randomEsteMes calcula un día aleatorio dentro del mes actual y a
                partir de la fecha actual.
            2.- random calcula un día aleatorio dentro del año actual y a partir
                de la fecha actual.
        
    */
    
    public static Ticket randomEsteMes(){
        int diasMes;
        diasMes = (int) (Math.random()*(LocalDate.now().lengthOfMonth() - LocalDate.now().getDayOfMonth() + 1));
        Ticket ticket = new Ticket(LocalDate.now().plusDays(diasMes));
        return ticket;
    }
    
    public static Ticket random(){
        int diasAnio;
        diasAnio = (int) (Math.random() * (LocalDate.now().lengthOfYear() - LocalDate.now().getDayOfYear() +1));
        Ticket ticket = new Ticket(LocalDate.now().plusDays(diasAnio));
        return ticket;
    }
    
    
    
//--------------------------| MÉTODO TO-STRING |--------------------------------
    
    @Override
    public String toString(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        return String.format("{ID: %s, fecha: %s, usado: %s",
                this.identificador,this.fechaTicket.format(formato), 
                this.horaUtilizado != null ? this.horaUtilizado.format(formatoHora) : "No");
    }
    
}

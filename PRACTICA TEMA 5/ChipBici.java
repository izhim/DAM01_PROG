package tarea05;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un sistema de <strong>gestión de alquiler de bicis</strong>.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar
 * información sobre:</p>
 * <ul>
 * <li><strong>Número de serie</strong> de la bicicleta. Este valor se establecerá
 * al crear la bicicleta y ya no podrá cambiar. Es un valor constante.</li>
 * <li><strong>Fecha de adquisición</strong> de la bicicleta. Es también un
 * valor constante y no permitirá su posterior modificación ya que es una constante.</li>
 * <li><strong>Versión y revisión</strong> del firmware del chip perteneciente
 * a la bici.</li>
 * <li><strong>Indicador de bici en alquiler</strong> que nos indica si una bici
 * se encuentra alquilada.</li>
 * <li><strong>Cantidad total de kilómetros</strong> de la bici desde su creación.</li>
 * <li><strong>Fecha y hora de inicio</strong> del alquiler actual de la bici.</li>
 * <li><strong>Kilómetros que lleva recorridos</strong> la bici durante el
 * alquiler en curso.</li>
 * <li><strong>Fecha y hora de inicio</strong> del último alquiler de la bici.</li>
 * <li><strong>Fecha y hora de finalización</strong> del último alquiler de la bici.</li>
 * <li><strong>Kilómetros recorridos</strong> durante el último alquiler</li>
 * </ul>
 * <p>
 * Además de los anteriores atributos de cada objeto disponemos de información
 * general de la clase:</p>
 * <ul>
 * <li><strong>Cantidad total de bicis adquiridas</strong> hasta el momento.</li>
 * <li><strong>Cantidad total de bicis alquiladas</strong> hasta el momento.</li>
 * <li><strong>Kilómetros totales</strong> recorridos entre todas las bicis.</li>
 * </ul>
 * @author José Antonio Carrillo Huete.
 * @version 1.0
 */


public class ChipBici { 
    

    /*                    +----------------------+
    ----------------------|       ATRIBUTOS      |------------------------------
                          +----------------------+                            
    
                              ATRIBUTOS DE CLASE
                              ------------------                              */
        
    //  -------------------------------------
    //  Atributos privados de clase variables
    //  -------------------------------------
    
    private static int  totalBicis;         //  Cantidad total de bicis adquiridas
    private static int  totalAlquiladas;    //  Cantidad total de bicis alquiladas en el momento
    private static int  totalKilometros;    //  Cantidad total de kilómetros recorridos entre todas las bicis
    
    //  --------------------------------------
    //  Atributos públicos de clase constantes
    //  --------------------------------------
    
    /**
     * Máxima distancia permitida de recorrido de bicicleta: 
     * {@value MAX_DISTANCIA_TRAYECTO} km.
     */
    public static final float       MAX_DISTANCIA_TRAYECTO   = 140;
    /**
     * Versión mínima de firmware permitida: {@value MIN_VERSION}.
     */
    public static final int         MIN_VERSION              = 1;
    /**
     * Versión máxima de firmware permitida: {@value MAX_VERSION}.
     */
    public static final int         MAX_VERSION              = 10;
    /**
     * Revisión mínima de firmware permitida: {@value MIN_REVISION}.
     */
    public static final int         MIN_REVISION             = 0;
    /**
     * Revisión máxima de firmware permitida: {@value MAX_REVISION}.
     */
    public static final int         MAX_REVISION             = 9;
    /**
     * Versión por defecto del firmware: {@value DEFAULT_VERSION}.
     */
    public static final int         DEFAULT_VERSION          = MIN_VERSION;
   /**
    * Revisión por defecto del firmware: {@value DEFAULT_REVISION}.
    */
    public static final int         DEFAULT_REVISION         = MIN_REVISION;
    /**
     * Fecha mínima de adquisición de la bici: 15/06/2020
     */
    public static final LocalDate   MIN_FECHA_ADQUISICION    = LocalDate.of(2020, 6, 15);
    
    
    //                          ATRIBUTOS DE OBJETO
    //                          -------------------
    
    //  ---------------------------------------
    //  Atributos privados de objeto constantes
    //  ---------------------------------------
    
    private final int           numeroSerie;        //  Número de serie de la bici
    private final LocalDate     fechaAdquisicion;   //  Fecha de adquisición de la bici
    
    //  --------------------------------------
    //  Atributos privados de objeto variables
    //  --------------------------------------
    
    //  Información general de la bici
    private int         biciVersion, biciRevision;  //  Versión y revisión de la bici
    private boolean     biciAlquilada;              //  Nos dice si está alquilada o no la bici
    private float       biciKilometros;             //  Cantidad de kilómetros totales de la bici
    
    //  Información sobre el alquiler actual
    private LocalDateTime   alquilerInicio;     //  Fecha y hora de inicio del alquiler actual
    private float           alquilerKilometros; //  Kilómetros recorridos hasta el momento en el alquiler actual
    
    //  Información sobre el último alquiler;
    private LocalDateTime   inicioUltimoAlquiler, finUltimoAlquiler;    //  Fecha y hora de inicio y fin del último alquiler
    private float           kilometrosUltimoAlquiler;                   //  Kilómetros recorridos durante el último alquiler
    

        
    /*                   +--------------------------+
    ---------------------|      CONSTRUCTORES       |---------------------------
                         +--------------------------+                         */
    
    //  ----------------------------
    //  Constructor con 3 parámetros
    //  ----------------------------
    /**
     * Constructor del objeto ChipBici con tres parámetros.
     * 
     * <p>En base a los parámetros introducidos este constructor asigna al chip 
     * de la bici los parámetros necesarios para funcionar, tales como 
     * <strong>versión</strong> y <strong>revisión</strong> de la bici, el 
     * <strong>número de serie</strong> y la <strong>fecha de adquisición</strong>.
     * </p>
     * <p>También actualiza el contador general de bicis e inicializa el estado 
     * de la bici y los kilómetros de la misma.
     * </p>
     * 
     * @param fechaAdquisicion Fecha de adquisición de la bici.
     * @param version Versión del firmware del chip de la bici.
     * @param revision Revisión del firmware del chip de la bici.
     * @throws IllegalArgumentException si alguno de los parámetros no es válido.
     */

    public ChipBici(LocalDate fechaAdquisicion, int version, int revision)
            throws IllegalArgumentException{
        
    //  Utilizamos DateTimeFormatter para mostrar la fecha con el formato requerido
        DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        
    //  Comprobamos que la fecha de adquisición no sea anterior a la fecha mínima,
    //  posterior a la fecha actual o null
        if(fechaAdquisicion != null){
            if(fechaAdquisicion.isAfter(LocalDate.now())
                || fechaAdquisicion.isBefore(MIN_FECHA_ADQUISICION))                
            throw new IllegalArgumentException (String.format("Fecha incorrecta: (%s)",
                    fechaAdquisicion.format(FORMATO_FECHA)));
        } else throw new IllegalArgumentException ("Fecha incorrecta: null");
        
    
    //  Comprobamos si la versión está dentro de los parámetros requeridos
        if((version < MIN_VERSION) || (version > MAX_VERSION))
            throw new IllegalArgumentException ("Versión incorrecta: " + version);
        
    //  Comprobamos si la revisión se encuentra dentro de los parámetros
        if((revision < MIN_REVISION) || (revision > MAX_REVISION))
            throw new IllegalArgumentException ("Revisión incorrecta: " + revision);
        
    //  Se actualizan los atributos de clase, en este caso el contador    
        ChipBici.totalBicis++;
        
    //  Se asignan los valores iniciales de los atributos de objeto
        this.biciVersion        = version;
        this.biciRevision       = revision;
        this.biciAlquilada      = false;
        this.biciKilometros     = 0;
        this.numeroSerie        = totalBicis;
        this.fechaAdquisicion   = fechaAdquisicion;
    }
    
    //  ----------------------------
    //  Constructor con 2 parámetros
    //  ----------------------------
    /**
     * Constructor del objeto ChipBici con dos parámetros.
     * 
     * <p>Mediante este constructor crearemos un objeto facilitándole los parámetros 
     * de <strong>versión</strong> y <strong>revisión</strong>, asignando como 
     * fecha de adquisición el valor por defecto, es decir, la fecha del momento 
     * de creación del objeto.
     * </p>
     * @param version Versión del firmware del chip de la bici.
     * @param revision Revisión del firmware del chip de la bici.
     * @throws IllegalArgumentException si alguno de los parámetros no es válido.
     */
    
    public ChipBici(int version, int revision) throws IllegalArgumentException{
        this(LocalDate.now(), version,revision);
    }
     
    //  --------------------------
    //  Constructor sin parámetros
    //  --------------------------
     /**
      * Constructor del objeto ChipBici sin parámetros.
      * 
      * <p>Para este constructor creamos una bici con los valores por defecto,
      * tanto de fecha como de versión y revisión.
      * </p>
      */
    public ChipBici(){
        this(LocalDate.now(),DEFAULT_VERSION, DEFAULT_REVISION);
    }
    

    
/*                        +---------------------+
--------------------------|       MÉTODOS       |-------------------------------
                          +---------------------+                                
      
                            MÉTODOS DE CLASE
                            ----------------                                  */
    
    //  ----------------------------------
    //  Métodos de acciones sobre la clase
    //  ----------------------------------
    
    /**
     * Método que crea un array de objetos ChipBici.
     * 
     * <p>Con este método lo que conseguimos es, a través de un número entero, 
     * generar tantos objetos en un array como el número que hemos indicado.
     * </p>
     * @param i Cantidad de elementos que va a tener nuestro array.
     * @return Array de objetos ChipBici.
     * @throws IllegalArgumentException Si la cantidad no es válida.
     */
    
    /*  Utilizamos un bucle for para recorrer todas las posiciones del array
        creado para ir creando cada objeto                                    */
    
    public static ChipBici[] crearArrayChipBici(int i) 
            throws IllegalArgumentException{
        if(i < 1)
            throw new IllegalArgumentException("Cantidad no válida: " + i);
        
        ChipBici[] arrayChipBici = new ChipBici[i];
        for(int j = 0; j < i; j++)
        {
            arrayChipBici[j] = new ChipBici();
        }
        return arrayChipBici;
    }    
    
    //  ----------------------------
    //  Métodos de consulta de clase 
    //  ----------------------------
    
    /**
     * Método que devuelve la cantidad de chips creados.
     * 
     * <p>Con este método lo que hacemos es realizar una petición del númeto total 
     * de bicis, es decir, la cantidad de objetos ChipBici que hemos creado.     * 
     * </p>
     * @return Cantidad total de bicis creadas.
     */
    public static int getNumBicis()
    {
        return ChipBici.totalBicis;
    }
    
    /**
     * Método que devuelve la cantidad de bicis alquiladas.
     * 
     * <p>Este método lo utilizamos para lanzar una consulta a la clase sobre 
     * la cantidad de bicis que están alquiladas de entre todas las que disponemos.
     * </p>
     * @return Cantidad total de bicis alquiladas.
     */
    public static int getNumBicisAlquiladas(){
        return ChipBici.totalAlquiladas;
    }
    
    /**
     * Método que devuelve el total de kilómetros recorridos.
     * 
     * <p>Con este método lo que hacemos es consultar la cantidad de kilómetros 
     * totales que han recorrido hasta el momento todas las bicis durante su 
     * alquiler.
     * </p>
     * @return Cantidad de kilómetros totales entre todas las bicis.
     */
    public static double getKilometrosTodasLasBicis(){
        return ChipBici.totalKilometros;
    }

      
    //                    MÉTODOS DE OBJETO
    //                    -----------------
    
    //  -----------------------------
    //  Métodos de consulta de objeto
    //  -----------------------------   
    
    /**
     * Devuelve el número de serie.
     * 
     * <p>Este método realiza una petición para obtener el número de serie del 
     * objeto ChipBici.
     * </p>
     * @return Número de serie de la bici.
     */
    public String getNumSerie(){
        return String.valueOf(this.numeroSerie);
    }
    
    /**
     * Devuelve la fecha de adquisición.
     * 
     * <p>
     * Con este método se lanza una petición que nos devuelve la fecha en la que 
     * la bicicleta fue adquirida.
     * </p>
     * @return Fecha de adquisición de la bici.
     */
    public LocalDate getFechaAdquisicion(){
        return this.fechaAdquisicion;
    }
    
    /**
     * Devuelve la versión actual del firmware.
     * 
     * <p>Con este método lo que realizamos es una consulta sobre la versión 
     * actual del firmware correspondiente al chip de la bici del objeto.
     * </p>
     * @return Versión actual del firmware.
     */
    public int getVersion(){
        return this.biciVersion;
    }
    
    /**
     * Devuelve la revisión actual del firmware.
     * 
     * <p>Con este método lo que hacemos es lanzar una consulta para obtener el 
     * número de revisión del firmware del chip de la bici.
     * </p>
     * @return Versión actual del firmware.
     */
    public int getRevision(){
        return this.biciRevision;
    }
    
    /**
     * Devuelve la versión y la revisión actuales del firmware.
     * 
     * <p>Este método devuelve en formato "v.r" la versión y la revisión actuales 
     * del firmware del chip de la bici.
     * </p>
     * @return Versión y revisión del firmware.
     */
    public String getVersionRevision(){
        String versionRevision = String.valueOf(this.biciVersion) + "." 
                + String.valueOf(this.biciRevision);
        return versionRevision;
    }
    
    /**
     * Indica si la bici está alquilada.
     * 
     * <p>Este método lo que hace es comprobar si la bicicleta está alquilada 
     * en el momento de la consulta o no.
     * </p>
     * @return True si la bici está alquilada y false si no lo está.
     */
    public boolean isAlquilada(){
        return this.biciAlquilada;
    }
    
    /**
     * Devuelve el total de kilómetros recorridos por la bici.
     * 
     * <p>Este método lo que hace es consultar los kilómetros que ha recorrido 
     * la bici desde que el objeto fue creado, es decir, es acumulativo de todos 
     * los kilómetros de cada alquiler que ha tenido la bici.
     * </p>
     * @return Cantidad total de kilómetros recorridos por la bici.
     */
    //  7.- Método que devuelve el total de kilómetros recorridos por la bici
    public double getKilometrosTotales(){       
        return this.biciKilometros;
    }
    
    /**
     * Devuelve la fecha y la hora del inicio del alquiler actual.
     * 
     * <p>Este método nos dice, en caso de que la bici se encuentre alquilada, 
     * la fecha y la hora del inicio de dicho alquiler, en caso contrario nos 
     * devuelve el valor null.
     * </p>
     * @return Devuelve la fecha y hora de alquiler o null si no ha sido alquilada.
     */
    public LocalDateTime getRegistroInicioAlquilerActual(){
        return this.biciAlquilada ? this.alquilerInicio : null;
    }
    
    /**
     * Devuelve los kilómetros recorridos durante el alquiler actual.
     * 
     * <p>Mediante este método podemos consultar el valor de los kilómetros que 
     * se han recorrido desde que la bici fue alquilada hasta el momento de la 
     * consulta.
     * </p>
     * @return Cantidad de kilómetros recorridos durante el alquiler o 0 si no 
     * ha sido alquilada.
     */
    public double getKilometrosRecorridosAlquilerActual(){
        return this.biciAlquilada ? this.alquilerKilometros : 0;
    }
    
    /**
     * Devuelve la fecha y hora de inicio del último alquiler.
     * 
     * <p>Con este método consultamos la fecha y hora en que se alquiló la bici 
     * por última vez, devolviendo el valor null en caso de no haber sido alquilada.
     * </p>
     * @return Fecha y hora del último alquiler o null si no ha sido alquilada.
     */
        
    /*  Utilizamos la variable finUltimoAlquiler como testigo para comprobar
        si la bici ha sido alquilada anteriormente, si hay una fecha de 
        devolución significa que se ha alquilado al menos una vez             */
    public LocalDateTime getRegistroInicioUltimoAlquiler(){
        return this.finUltimoAlquiler != null ? this.inicioUltimoAlquiler : null;
    }
    
    /**
     * Devuelve la fecha y hora de devolución del último alquiler.
     * 
     * <p>Este método nos dice, en caso de que haya sido alquilada con anterioridad, 
     * la fecha y la hora en que fue devuelta la bici en el último alquiler. Nos 
     * devolverá null si no ha sido alquilada.
     * </p>
     * @return Fecha y hora de devolución del último alquiler. 
     */

    /*  Utilizamos finUltimoAlquiler de igual manera que en la función
        getRegistroInicioUltimoAlquiler del punto anterior                    */
    public LocalDateTime getRegistroFinUltimoAlquiler(){
        return this.finUltimoAlquiler != null ? this.finUltimoAlquiler : null;
    }
    
    /**
     * Devuelve los kilómetros recorridos durante el último alquiler.
     * 
     * <p>Mediante este método podemos averiguar los kilómetros totales recorridos 
     * por una bici durante el último alquiler de la misma. Si la bicicleta no 
     * ha sido alquilada con anterioridad devolverá el valor 0.
     * </p>
     * @return Cantidad de kilómetros recorridos durante el último alquiler
     */
    public double getKilometrosRecorridosUltimoAlquiler(){
        return this.kilometrosUltimoAlquiler;
    }
        
    //  -----------------------------------
    //  Métodos de acciones sobre el objeto
    //  -----------------------------------
    
    /**
     * Asigna a la bici como alquilada.
     * 
     * <p>Si la bici ya está alquilada no se puede alquilar y devolvemos una 
        excepción, si no lo está asignamos los siguientes valores:
     * </p>
     * <ol>
     * <li> - El estado de alquilada pasa a ser verdadero.</li>
     * <li> - A la fecha de inicio de alquiler le asignamos el valor del momento 
        en el que se alquila.</li>
     * <li> - Incrementamos el valor del contador de bicis alquiladas.</li>
     * </ol>
     * 
     * @throws IllegalStateException Si la bici ya se encuentra alquilada.
     */
    public void alquilar() throws IllegalStateException{
        if (this.biciAlquilada)
            throw new IllegalStateException("Bici ya alquilada");
        else{
            this.biciAlquilada          = true;
            this.alquilerInicio         = LocalDateTime.now();
            ChipBici.totalAlquiladas    ++;
            
        }
    }
    
    /**
     * Establece el estado de la bici como devuelta.
     * 
     * <p>Si la bici no está alquilada devolvemos una excepción, pues no se puede 
       devolver. Si está alquilada asignamos los siguientes valores:
     * </p>
     * <ol>
     * <li>Asignamos a la fecha y hora de último alquiler la del alquiler que 
        termina.</li>
     * <li>Anulamos la fecha de inicio del alquiler de inicio.</li>
     * <li>Asignamos a la fecha y hora de la devolución del último alquiler 
     * el valor del momento en que se devuelve.</li>
     * <li>Descontamos el contador de bicis alquiladas.</li>
     * <li>El estado de alquilada pasa a ser falso.</li>
     * <li>Guardamos el valor total de kilómetros recorridos en este alquiler.</li>
     * <li>El contador de kilómetros de la bici en alquiler se reinicia.</li>
     * </ol>
     * 
     * @throws IllegalStateException Si la bici no se encuentra alquilada.
     */
    public void devolver() throws IllegalStateException{
        if(!this.biciAlquilada)
            throw new IllegalStateException("Bici no alquilada");
        else{
            this.inicioUltimoAlquiler       = this.alquilerInicio;
            this.alquilerInicio             = null;
            this.finUltimoAlquiler          = LocalDateTime.now();
            ChipBici.totalAlquiladas        --;
            this.biciAlquilada              = false;
            this.kilometrosUltimoAlquiler   = this.alquilerKilometros;
            this.alquilerKilometros         = 0;
        }
    }
    
    /**
     * Representa la realización de trayectos.
     * 
     * <p>En el caso de que la bicicleta se encuentre alquilada y los kilómetros 
     * introducidos estén dentro del rango válido, es decir, se encuentren entre 
     * 0 y MAX_DISTANCIA_TRAYECTO, hacemos una actualización en los parámetros 
     * de la bici incrementando los kilómetros indicados.
     * </p>
     * 
     * @param kilometros Cantidad de kilómetros recorridos en el trayecto.
     * @return Valor actualizado del contador de kilómetros.
     * @throws IllegalStateException Si la bici no está alquilada.
     * @throws IllegalArgumentException  Si la distancia no se encuentra dentro del 
     * rango.
     */
    public double recorrerTrayecto(double kilometros) 
            throws IllegalStateException, IllegalArgumentException{
        if(!this.biciAlquilada)
            throw new IllegalStateException("Bici no alquilada");
        if(kilometros < 0 || kilometros > MAX_DISTANCIA_TRAYECTO)
            throw new IllegalArgumentException(String.format("Distancia incorrecta: %.2f km",kilometros));
        this.alquilerKilometros     += kilometros;
        this.biciKilometros         += kilometros;
        ChipBici.totalKilometros    += kilometros;
        return this.alquilerKilometros;
    }
    
    /**
     * Representa la realización de trayectos con el valor por defecto.
     * 
     * <p>Se realiza la introducción del trayecto con el valor por defecto 
     * definido por MAX_DISTANCIA_TRAYECTO.
     * </p>
     * @return Valor actualizado del contador de kilómetros.
     */
    public double recorrerTrayecto(){
        return recorrerTrayecto(MAX_DISTANCIA_TRAYECTO);
    }
    
    /**
     *  Actualización del firmware.
     * 
     * <p>Actualiza el firmware siempre y cuando la bici no se encuentre en 
     * alquiler y la versión y la revisión tienen valores válidos, es decir, 
     * se encuentran entre los valores mínimo (MIN_VERSION.MIN_REVISION) y los 
     * valores máximos (MAX_VERSION.MAX_REVISION) y además la versión sea un 
     * upgrade de la versión de firmware instalada en el momento.
     * </p>
     * @param version Valor de la nueva versión de firmware.
     * @param revision Valor de la nueva revisión de firmware.
     * @throws IllegalStateException Si la bici se encuentra alquilada.
     * @throws IllegalArgumentException Si los valores introducidos son inválidos.
     */
    
    /*  No se considera upgrade si se cumple alguna de estas dos condiciones:
            - Tanto la revisión como la versión son menores o iguales que las de
              la bici.
            - La nueva versión es menor que la de la bici.
        De esta manera se abarcan todas las combinaciones de posibilidades para
        asegurarse de que el nuevo firmware no sea igual o anterior al que ya
        tiene la bici                                                         */
    public void actualizarFirmware(int version, int revision)
            throws IllegalStateException, IllegalArgumentException{
        if(this.biciAlquilada)
            throw new IllegalStateException("No se puede actualizar el firmware a una bici alquilada");
        if(version < MIN_VERSION || version > MAX_VERSION)
            throw new IllegalArgumentException(String.format("Versión incorrecta: %d", version));
        if(revision < MIN_REVISION || revision > MAX_REVISION)
            throw new IllegalArgumentException(String.format("Revisión incorrecta: %d", revision));
        if((revision <= this.biciRevision && version <= this.biciVersion)
                || version < this.biciVersion)
            throw new IllegalArgumentException(String.format("Es necesario actualizar "
                    + "a una versión superior a la actual: %d.%d <= %d.%d",
                    version, revision,this.biciVersion, this.biciRevision));
        this.biciVersion    = version;
        this.biciRevision   = revision;
    }
    
    /**
     *  Actualización de firmware con un solo parámetro.
     * 
     * <p>Se pide únicamente el valor de la versión y se utiliza el valor de 
     * la revisión por defecto (DEFAULT_REVISION) para actualizar el firmware.
     * </p>
     * @param version La nueva versión del firmware.
     */
    public void actualizarFirmware(int version){
        actualizarFirmware(version,DEFAULT_REVISION);
    }

    /**
     * Restauración de los valores de fábrica.
     * 
     * <p>En el caso que la bici no se encuentre alquilada se realiza un reseteo 
     * de los valores de la misma, estableciendo los valores de fábrica siguientes:
     * </p>
     * <ol>
     * <li>Versión y revisión de la bici: DEFAULT_VERSION.DEFAULT_REVISION.</li>
     * <li>Kilómetros en alquiler, kilómetros del último alquiler y kilómetros de la bici: 0.</li>
     * <li>Fechas de inicio de alquiler y de inicio y fin del último alquiler: null.</li>
     * </ol>
     *
     * @throws IllegalStateException Si la bici se encuentra alquilada.
     */
    public void reset() throws IllegalStateException{
        if(this.biciAlquilada)
            throw new IllegalStateException("No se puede resetear un chip de una "
                    + "bici que esté alquilada");
        this.biciVersion                = DEFAULT_VERSION;
        this.biciRevision               = DEFAULT_REVISION;
        this.alquilerKilometros         = 0;
        this.alquilerInicio             = null;
        this.biciKilometros             = 0;
        this.finUltimoAlquiler          = null;
        this.inicioUltimoAlquiler       = null;
        this.kilometrosUltimoAlquiler   = 0;
    }

    
    //  ---------------
    //  Método toString
    //  ---------------
    
    /**
     * Devuelve una <code>String</code> que representa el estado actual de la bici.
     * Esta <code>String</code> proporciona la siguiente información:
     * <ol>
     * <li>Número de serie de la bici.</li>
     * <li>Fecha de adquisición.</li>
     * <li>Versión y la revisión actuales.</li>
     * <li>Si la bici se encuentra alquilada.</li>
     * <li>Cantidad de kilómetros totales de la bici.</li>
     * <li>Fecha y hora del alquiler actual.</li>
     * <li>Kilómetros del actual alquiler.</li>
     * <li>Fecha y hora del inicio y de la finalización del último alquiler.</li>
     * <li>Kilómetros del último alquiler.</li>
     * </ol>
     * <p>Dicha <code>String</code> tendrá la siguiente estructura:
     * </p>
     * <ol>
     * <li>Un inicio de bloque o llave (carácter '{') junto con un espacio;</li>
     * <li>La etiqueta "NS: " junto con el número de serie y a continuación un punto y coma (";");</li>
     * <li>La fecha de adquisición de la bici, en formato dd/mm/aaaa.</li>
     * <li>La etiqueta "fw: " y a continuación la versión y revisión del firmware
     * separadas por un punto y a continuación un punto y coma;</li>
     * <li>Si la bici está o no alquilada indicándolo con el texto "alquilada" si 
     * lo está y "no alquilada" si no lo está, y a continuación un punto y coma;</li>
     * <li>Cantidad de kilómetros totales recorridos por la bici hasta el momento, 
     * con dos decimales, e indicando la unidad "km" y la palabra "totales", y 
     * a continuación un punto y coma;</li>
     * <li>Información sobre el alquiler actual, que incluirá la etiqueta 
     * "Alquiler actual: " junto con el registro de la fecha y hora de inicio 
     * del alquiler actual (en formato "dd/mm/aaaa hh:mm:ss" si está alquilada o 
     * bien la cadena "---" si no lo está) y los kilómetros recorridos durante 
     * ese alquiler hasta el momento (con dos decimales e indicando la unidad "km"), 
     * y terminando en punto y coma;</li>
     * <li>Información sobre el último alquiler realizado, que incluirá la etiqueta 
     * "Último alquiler: " junto con los registros de fecha y hora de inicio y 
     * fin de ese alquiler y los kilómetros realizados durante el mismo (con dos 
     * decimales e indicando la unidad en "km"). Cada uno de esos registros irá 
     * separado por comas. En cuanto al formato de fecha, se utilizará, en ambos 
     * casos, formato "dd/mm/aaaa hh:mm:ss" o bien la cadena "---" (para ambos 
     * registros) si aún no ha sido alquilada y devuelta. En tal caso, su registro 
     * de distancia recorrida será, obviamente, 0,00.</li>
     * <li>Un fin de bloque o llave (un espacio más el carácter '}').</li>
     * </ol>
     * 
     * @return Cadena que representa el estado actual de la bici.
     */
    @Override
    public String toString(){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
        return String.format("{ NS: %d; %s; fw: %d.%d; %s; %.2f km totales; "
                + "Alquiler actual: %s, %.2f km; Último alquiler: %s, %.2f km }",
                
                this.numeroSerie, 
                this.fechaAdquisicion.format(formatoFecha), 
                this.biciVersion, 
                this.biciRevision, 
                this.biciAlquilada ? "alquilada" : "no alquilada",
                this.biciKilometros, 
                this.biciAlquilada ? this.alquilerInicio.format(formatoFechaHora) : "---",
                this.alquilerKilometros, 
                this.finUltimoAlquiler == null ? "---, ---" : this.inicioUltimoAlquiler.format(formatoFechaHora) 
                + ", "+ this.finUltimoAlquiler.format(formatoFechaHora), 
                this.kilometrosUltimoAlquiler);
    }
    
    
    
}   

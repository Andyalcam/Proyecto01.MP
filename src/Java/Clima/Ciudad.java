package Java.Clima;

/**
* @author Alfonso Mondragon Segoviano
* @author Andrea Alvarado Camacho
* @author Abner Elias Velazquez Rosas
* @author Jose Luis Almanza Torres
* @version 1.0 Octubre 2021.
* @since Modelado y Programacion 2022-1. Proyecto 01.
*/

public class Ciudad{
    private final String nombre, latitud, longitud;
    private Double temperatura, minimo, maximo, sensacion;
    private Long humedad;

    /**
     *Constructor de objeto tipo Ciudad  
     * @param nombre almacena el nombre de la ciudad
     * @param latitud almacena la latitud
     * @param longitud almacena la longitud
     */
    public Ciudad(String nombre, String latitud, String longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.temperatura = 0.0;
    }

    /**
     * Accede a la informacion del nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Accede a la informacion de la temperatura
     * @return temperatura
     */
    public double getTemperatura() {
        return temperatura;
    }

    /**
     * Permite cambiar la temperatura
     * @param temperatura
     * @return temperatura
     */
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * Accede a la informacion de la latitud 
     * @return latitud
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * Accede a la informacion de la longitud 
     * @return longitud
     */
    public String getLongitud() {
        return longitud;
    }
    
    /**
     * Accede a la informacion de la temperatura minima
     * @return minimo
     */
    public Double getMinimo() {
        return minimo;
    }

    /**
     * Permite cambiar la temperatura minima
     * @param minimo
     * @return minimo
     */
    public void setMinimo(Double minimo) {
        this.minimo = minimo;
    }

    /**
     * Accede a la informacion de la sensacion termica
     * @return sensacion
     */
    public Double getSensacion() {
        return sensacion;
    }

    /**
     * Permite cambiar la sensacion termica
     * @param sensacion
     * @return sensacion
     */
    public void setSensacion(Double sensacion) {
        this.sensacion = sensacion;
    }
    
    /**
     * Accede a la informacion de la temperatura maxima
     * @return maximo
     */
    public Double getMaximo() {
        return maximo;
    }
    
    /**
     * Permite cambiar la temperatura maxima
     * @param maximo
     * @return maximo
     */
    public void setMaximo(Double maximo) {
        this.maximo = maximo;
    }

    /**
     * Accede a la informacion de la humedad
     * @return humedad
     */
    public Long getHumedad() {
        return humedad;
    }

    /**
     * Permite cambiar la humedad
     * @param humedad
     * @return humedad
     */
    public void setHumedad(Long humedad) {
        this.humedad = humedad;
    }
}

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
    private double temperatura;

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
     * Da una cadena con los elementos contenidos en la lista.
     * @return una representación de la lista.
     */
    public String toString(){
        return "Nombre de la ciudad: " + this.getNombre() + "\n" + "Temperatura: " + this.getTemperatura();
    }

}

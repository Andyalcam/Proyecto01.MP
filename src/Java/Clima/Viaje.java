package Java.Clima;

/**
* @author Alfonso Mondragon Segoviano
* @author Andrea Alvarado Camacho
* @author Abner Elias Velazquez Rosas
* @author Jose Luis Almanza Torres
* @version 1.0 Octubre 2021.
* @since Modelado y Programacion 2022-1. Proyecto 01.
*/

public class Viaje {

    private int numeroDeViaje;
    private Ciudad ciudadOrigen, ciudadDestino;

    /**
     * Constructor de objeto tipo Viaje
     * @param numeroDeViaje almacena el numero de viaje
     * @param ciudadOrigen almacena la ciudad de origen
     * @param ciudadDEstino almacena la ciudad de destino
     */
    public Viaje(int numeroDeViaje, Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        this.numeroDeViaje = numeroDeViaje;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }

    /**
     *Accede a la informacion de numero de viaje
     * @return numeroDeViaje 
     */
    public int getNumeroDeViaje() {
        return numeroDeViaje;
    }

    /**
     *Accede a la informacion de la ciudad de origen
     * @return ciudadOrigen 
     */
    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    /**
     *Accede a la informacion de la ciudad de destino
     * @return ciudadDestino
     */
    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    /**
     * Da una cadena con los elementos contenidos en la lista.
     * @return una representación de la lista.
     */
    public String toString(){
        return "Numero de viaje: " + this.getNumeroDeViaje() + " Ciudad Origen:" + this.getCiudadOrigen().getNombre() + ", Temperatura: " + this.getCiudadOrigen().getTemperatura() + "\t - \t Ciudad Destino: " + this.getCiudadDestino().getNombre() + " Temperatura: " + this.getCiudadDestino().getTemperatura();
    }
}

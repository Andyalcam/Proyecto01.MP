package Java.Clima;

public class Viaje {

    private int numeroDeViaje;
    private Ciudad ciudadOrigen, ciudadDestino;

    public Viaje(int numeroDeViaje, Ciudad ciudadOrigen, Ciudad ciudadDestino) {
        this.numeroDeViaje = numeroDeViaje;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }

    public int getNumeroDeViaje() {
        return numeroDeViaje;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public String toString(){
        return "Numero de viaje: " + this.getNumeroDeViaje() + " Ciudad Origen:" + this.getCiudadOrigen().getNombre() + ", Temperatura: " + this.getCiudadOrigen().getTemperatura() + "\t - \t Ciudad Destino: " + this.getCiudadDestino().getNombre() + " Temperatura: " + this.getCiudadDestino().getTemperatura();
    }
}

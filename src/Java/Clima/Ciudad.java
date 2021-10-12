package Java.Clima;

public class Ciudad{
    private final String nombre, latitud, longitud;
    private double temperatura;

    public Ciudad(String nombre, String latitud, String longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.temperatura = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String toString(){
        return "Nombre de la ciudad: " + this.getNombre() + "\n" + "Temperatura: " + this.getTemperatura();
    }

}

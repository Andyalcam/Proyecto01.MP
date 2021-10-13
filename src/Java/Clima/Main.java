package Java.Clima;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.ParseException;

/**
* @author Alfonso Mondragon Segoviano
* @author Andrea Alvarado Camacho
* @author Abner Elias Velazquez Rosas
* @author Jose Luis Almanza Torres
* @version 1.0 Octubre 2021.
* @since Modelado y Programacion 2022-1. Proyecto 01.
*/

public class Main {
    protected static List<String> ciudadesNombres = new ArrayList<>();
    protected static List<Ciudad> ciudades = new ArrayList<>();
    protected static List<Viaje> viajes = new ArrayList<>();
    private static Double temperatura, minimo, maximo, sensacion ;
    private static Long humedad;


    public static void main(String[] args) {
        
        Aeropuerto ventana = new Aeropuerto();
        leerCSV(viajes);
        ventana.setVisible(true);

    }

    /**
     * Realiza la llamada a la API para obtener la temperatura de la ciudad
     * @param ciudad almacena los datos de la ciudad 
     * @return 0
     */
    public static double busquedaTemperatura(Ciudad ciudad) throws ParseException{
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat="+ciudad.getLatitud()+"&lon="+ciudad.getLongitud()+"&appid=4b342a6371f1424c8693cb762d8c41c4");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.setRequestProperty("Accept","application/json");
            conexion.connect();
            if(conexion.getResponseCode() != 200)
                throw new RuntimeException("Fallo http " + conexion.getResponseCode() + "");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String salida;
            StringBuilder aux= new StringBuilder();
            while((salida = bufferedReader.readLine()) != null){
                aux.append(salida);
            }
            JSONParser parser = new JSONParser();
            Object objeto = parser.parse(aux.toString());
            JSONObject jsonObject = (JSONObject) objeto;
            JSONObject jsonObjectMain = (JSONObject)jsonObject.get("main");
            
            Main.temperatura = (double)jsonObjectMain.get("temp");
            Main.minimo = (double)jsonObjectMain.get("temp_min");
            Main.maximo = (double)jsonObjectMain.get("temp_max");
            Main.humedad = (long)jsonObjectMain.get("humidity");
            Main.sensacion = (double)jsonObjectMain.get("feels_like");
            
  
        } catch (IOException | RuntimeException | ParseException e) {
            System.out.println(e);
        }
        return 0.0;
    }

    /**
     * Almacena temporalmente la informacion de clima de la ciudad
     * @param nombre almacena el nombre de la ciudad
     * @return null 
     */
    public static Ciudad infoCiudad(String nombre){
        for(int i = 0; i < ciudadesNombres.size(); i++){
            if(ciudadesNombres.get(i).equals(nombre)){
                return ciudades.get(i);
            }
        }
        return null;
    }


    /**
     * Lee los datos del archivo CSV
     * @param viajes
     */
    public static void leerCSV(List<Viaje> viajes){
        int contador=0;
        String csv = "src/Java/Clima/dataset1.csv";
        BufferedReader bufferedReader = null;
        String fila;
        try {
            bufferedReader = new BufferedReader(new FileReader(csv));
            while ((fila = bufferedReader.readLine()) != null || contador < 2) {
                if(contador>0 & fila != null){
                    try {
                        String[] datos = fila.split(",");
                        Ciudad cdOrigen = null;
                        Ciudad cdDestino = null;

                        if(!ciudadesNombres.contains(datos[0])){
                            cdOrigen = new Ciudad(datos[0], datos[2], datos[3]);
                            busquedaTemperatura(cdOrigen);
                            cdOrigen.setTemperatura(Main.temperatura);
                            cdOrigen.setMinimo(Main.minimo);
                            cdOrigen.setMaximo(Main.maximo);
                            cdOrigen.setHumedad(Main.humedad);
                            cdOrigen.setSensacion(Main.sensacion);
                           
                            ciudades.add(cdOrigen);
                            ciudadesNombres.add(datos[0]);
                        }
                        if(!ciudadesNombres.contains(datos[1])){
                            cdDestino = new Ciudad(datos[1], datos[4], datos[5]);
                            busquedaTemperatura(cdDestino);
                            cdDestino.setTemperatura(Main.temperatura);
                            cdDestino.setMinimo(Main.minimo);
                            cdDestino.setMaximo(Main.maximo);
                            cdDestino.setHumedad(Main.humedad);
                            cdDestino.setSensacion(Main.sensacion);
                            
                            ciudades.add(cdDestino);
                            ciudadesNombres.add(datos[1]);
                        }

                        cdOrigen = infoCiudad(datos[0]);
                        cdDestino = infoCiudad(datos[1]);

                        viajes.add(new Viaje(contador, cdOrigen, cdDestino));
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }
                contador++;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

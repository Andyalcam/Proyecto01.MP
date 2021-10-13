package Java.Clima;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import static Java.Clima.Main.leerCSV;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.parser.ParseException;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author Poncho Mondragon
 */
public class Tests {
    
    Ciudad ciudadCorrecta = new Ciudad("MTY","19.3371","-99.566");
    Ciudad ciudadIncorrecta = new Ciudad("MEX", "1500", "1500");
    
    @Test
    public void testCode400() throws ParseException{
        assertEquals("400", busquedaTemperatura(ciudadIncorrecta));
    }
    
    @Test
    public void testCode200() throws ParseException{
        assertEquals("200", busquedaTemperatura(ciudadCorrecta));
    }
    
    @Test
    public void listaViajes(){
        List<Viaje> viajes = new ArrayList<>();
        leerCSV(viajes);
        assertEquals(3000, viajes.size());
    }
    
    
    public static String busquedaTemperatura(Ciudad ciudad) throws ParseException{
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat="+ciudad.getLatitud()+"&lon="+ciudad.getLongitud()+"&appid=4b342a6371f1424c8693cb762d8c41c4");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.setRequestProperty("Accept","application/json");
            conexion.connect();
            if(conexion.getResponseCode() != 200){
                return conexion.getResponseCode()+"";
            }
            return "200";
        }catch(IOException | RuntimeException e) {
            System.out.println(e);
        }
        return null;
    }
        
    
}

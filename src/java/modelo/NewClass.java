/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author busqu
 */
public class NewClass {

    public static void main(String[] args) {

        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("https://farm3.sat.gob.gt/retencion-liberacion-ws/rest/privado/retencionLiberacion/consultar")
                    .header("Authorization", "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr")
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .header("Cookie", "visid_incap_2112329=0xk+tVssSjegRxb6moVvoquKumAAAAAAQUIPAAAAAABebEr5ELkke+K1Kp+CTHG/")
                    .body("{\r\n    \"noContenedor\": \"BSIU9115899\"\r\n}")
                    .asString();

            System.err.println("Hola" + response);
        } catch (UnirestException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

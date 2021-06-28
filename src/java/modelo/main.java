/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author kcordon
 */
import com.mashape.unirest.http.*;
public class main {
		public static void main(String []args) throws Exception{
				Unirest.setTimeouts(0, 0);
				Unirest.setHttpClient(org.apache.http.impl.client.HttpClients.custom()
						.disableRedirectHandling()
						.build());
				HttpResponse<String> response = Unirest.post("https://farm3.sat.gob.gt/retencion-liberacion-ws/rest/privado/retencionLiberacion/consultar")
						.header("Authorization", "Basic MzEzMzIyMjpFbXBvcm5hYzIwMTUr")
						.header("Content-Type", "application/json")
						.header("Accept", "application/json;charset=utf-8")                                        
						.header("Cookie", "visid_incap_2112329=0xk+tVssSjegRxb6moVvoquKumAAAAAAQUIPAAAAAABebEr5ELkke+K1Kp+CTHG/")
						.body("{\r\n    \"noContenedor\": \"BSIU9115899\"\r\n}")
						.asString();
				
				System.out.println(response.getStatus());
				System.out.println(response.getBody());                           
                                              
		}
}

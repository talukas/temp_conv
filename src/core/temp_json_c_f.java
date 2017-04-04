package core;

import java.text.DecimalFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/json")

public class temp_json_c_f {
	DecimalFormat df = new DecimalFormat("####0.00");
       @GET
       @Path("c=>f/{input}")
       @Produces("application/json")
       public String convertCtoFfromInput(@PathParam("input") Double input) {
              
              Double celsius = input;
              Double fahrenheit = ((celsius * 9) / 5) + 32;
              String f = df.format(fahrenheit).toString();
              String c = df.format(celsius).toString();
             return "{\n\t\"calc\": {\n\t\" celsius\":" + c + ", \n\t\" fahrenheit\":" + f + "\n\t}\n}";
      }
       
       @GET
       @Path("f=>c/{input}")
       @Produces("application/json")
       public String convertFtoCfromInput(@PathParam("input") Double input) {
              
              Double fahrenheit = input;
              Double celsius = (fahrenheit -32) / 1.8;
              String f = df.format(fahrenheit).toString();
              String c = df.format(celsius).toString();

              return "{\n\t\"calc\": {\n\t\" fahrenheit\":" + f + ", \n\t\" celsius\":" + c + "\n\t}\n}";
      }

}

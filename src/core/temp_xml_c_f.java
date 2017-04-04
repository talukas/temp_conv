package core;

import java.text.DecimalFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")

public class temp_xml_c_f {
	 DecimalFormat df = new DecimalFormat("####0.00");
       @GET
       @Path("xml/c=>f/{input}")
       @Produces("application/xml")
       public String convertCtoFfromInput(@PathParam("input") Double input) {
             
              Double celsius = input;
              Double fahrenheit = ((celsius * 9) / 5) + 32;
              String f = df.format(fahrenheit).toString();
              String c = df.format(celsius).toString();

              return "<calc>" + "<celsius>" + c + "</celsius>" + "<fahrenheit>" + f + "</fahrenheit>" + "</calc>";
      }

       
           @GET
           @Path("xml/f=>c/{input}")
           @Produces("application/xml")
           public String convertFtoCfromInput(@PathParam("input") Double input) {
                  
                  Double fahrenheit = input;
                  Double celsius = (fahrenheit -32) / 1.8;
                  String f = df.format(fahrenheit).toString();
                  String c = df.format(celsius).toString();

                  return "<calc>" + "<fahrenheit>" + f + "</fahrenheit>" + "<celsius>" + c + "</celsius>" + "</calc>";
          }
}

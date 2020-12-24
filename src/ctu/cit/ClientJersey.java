package ctu.cit;

import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.logging.LoggingFeature;
 
public class ClientJersey {
 
    public static final String API_URL = "http://localhost:8080/DSBaoHongServiceProject/rest/WebService";
 
    public static void main(String[] args) {
        // (1) Create client config
        ClientConfig clientConfig = new ClientConfig();
 
        // Config logging for client side
        clientConfig.register( //
                new LoggingFeature( //
                        Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), //
                        Level.INFO, //
                        LoggingFeature.Verbosity.PAYLOAD_ANY, //
                        10000));
 
        // (2) Create basic authentication
        HttpAuthenticationFeature authDetails = HttpAuthenticationFeature.basic("ql001", "ql001");
 
        // (3) Create jersey client with authentication
        Client client = ClientBuilder.newClient(clientConfig);
        client.register(authDetails);
 
        // (4) Call API
        WebTarget target = client.target(API_URL).path("GetDSBaoHong");
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
        final Response response = invocationBuilder.get();
 
        // (5) Handle result
        System.out.println("Call API successful with the result: " + response.readEntity(String.class));
    }
}
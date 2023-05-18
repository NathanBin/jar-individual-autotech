package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class SlackApi {
    
    private static HttpClient client = HttpClient.newHttpClient();
    private static final String webhook = "https://hooks.slack.com/services/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";

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(webhook))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
        
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        //System.out.println(String.format("Status: %s", response.statusCode()));
        //System.out.println(String.format("Response: %s", response.body()));
        
    }
    
}

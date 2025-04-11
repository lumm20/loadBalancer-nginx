package itson.empresariales;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    private static HttpClient client;
    private static String nombre;

    public Main(){
        client = HttpClient.newHttpClient();
    }

    public static void main(String[] args) {
        new Main();

        try (Scanner scanner = new Scanner(System.in);) {
            System.out.println("Escribe tu nombre:");
            nombre = scanner.nextLine();
            for(int i = 0; i < 10; i++) {
                pedirSaludo(nombre);
                Thread.sleep(700);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Algo ha salido mal!!!");
        }
        
    }

    private static void pedirSaludo(String nombre){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8005/greeting?name="+nombre))
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                System.out.println(response.body());
            }else{
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
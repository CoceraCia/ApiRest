import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    // Base URL of the API
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    // HTTP client instance
    private final HttpClient client;

    // Constructor - initializes the HTTP client
    public ApiService() {
        this.client = HttpClient.newHttpClient();
    }

    // performs a fetch request to get a post by ID
    public void getPost(int postId) {
        try {
            // Build the GET request with the post endpoint URL
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/posts/" + postId))
                    .GET() // HTTP GET method
                    .build();

            // Send the request and receive the response as a string
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            // Display the results
            System.out.println("=== GET Request ===");
            System.out.println("Status Code: " + response.statusCode());

            System.out.println("\n=== HTTP Headers ===");
            response.headers().map().forEach((key, values) -> System.out.println(key + ": " + values));

            System.out.println("\n=== Response Body (JSON) ===");
            System.out.println(response.body());

        } catch (Exception e) {
            // Handle and display any errors that occur
            System.err.println("Error during GET request: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Performs a POST request to create a new post
    public void createPost(Post post) {
        try {
            // Convert the Post object to JSON string
            String jsonBody = "{" +
                    "\"userId\": " + post.getUserId() + "," +
                    "\"title\": \"" + post.getTitle() + "\"," +
                    "\"body\": \"" + post.getBody() + "\"" +
                    "}";

            // Build the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/posts"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            // Send the request and receive the response as a string
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            // Display the information
            System.out.println("=== POST Request ===");
            System.out.println("Status Code: " + response.statusCode());

            System.out.println("\n=== HTTP Headers ===");
            response.headers().map().forEach((key, values) -> System.out.println(key + ": " + values));

            System.out.println("\n=== Response Body (JSON) ===");
            System.out.println(response.body());

        } catch (Exception e) {
            System.err.println("Error during POST request: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Performs a GET request to fetch all posts
    public void getAllPosts() {
        try {
            // Build the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + "/posts"))
                    .GET()
                    .build();

            // Send the request and receive the response as a string
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            // Display information
            System.out.println("=== GET All Posts ===");
            System.out.println("Status Code: " + response.statusCode());

            // Count the number of posts received
            String body = response.body();
            int postCount = body.split("\\{").length - 1;
            System.out.println("Posts received: " + postCount);

            // Display the HTTP headers
            System.out.println("\n=== HTTP Headers ===");
            response.headers().map().forEach((key, values) -> System.out.println(key + ": " + values));

            // Display the first 500 characters of the response body
            System.out.println("\n=== Response Body (first 1000 chars) ===");
            System.out.println(body.substring(0, Math.min(1000, body.length())));
        } catch (Exception e) {
            System.err.println("Error during GET request: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
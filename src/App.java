import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApiService apiService = new ApiService();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    getPostById(apiService, scanner);
                    break;

                case "2":
                    apiService.getAllPosts();
                    break;

                case "3":
                    createPost(apiService, scanner);
                    break;

                case "4":
                    System.out.println("Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=".repeat(20));
        System.out.println("1. Get a post by ID");
        System.out.println("2. Get all posts");
        System.out.println("3. Create a new post");
        System.out.println("4. Exit");
        System.out.println("=".repeat(20));
        System.out.print("Select an option (1-4): ");
    }

    private static void getPostById(ApiService apiService, Scanner scanner) {
        System.out.print("Enter post ID: ");
        String idInput = scanner.nextLine();
        int postId = 1;
        try {
            postId = Integer.parseInt(idInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID, using default (1)");
        }
        apiService.getPost(postId);
    }

    private static void createPost(ApiService apiService, Scanner scanner) {
        System.out.print("Enter user ID: ");
        int userId = 1;
        try {
            userId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid user ID, using default (1)");
        }

        System.out.print("Enter post title: ");
        String title = scanner.nextLine();

        System.out.print("Enter post body: ");
        String body = scanner.nextLine();

        // Create the post object with user input
        Post newPost = new Post(userId, title, body);
        apiService.createPost(newPost);
    }
}
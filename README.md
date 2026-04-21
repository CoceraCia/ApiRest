# REST API Client - JSONPlaceholder

A Java HTTP client application that consumes a REST API using the JSONPlaceholder public API.

## Project Context

This project is part of the **DAM** course (Programación de servicios y procesos - UT4), specifically **Activity 2**: "Desarrollo de un cliente HTTP en Java para consumir una API REST".

The objective is to understand:
- How to make HTTP requests from Java code
- How to interpret JSON responses and HTTP status codes
- The difference between GET and POST methods
- The client-server communication flow

## What It Does

This application connects to the **JSONPlaceholder API** (https://jsonplaceholder.typicode.com) and performs:

1. **GET requests**: Fetch posts by ID or get all posts
2. **POST requests**: Create new posts with custom data

For each request, it displays:
- HTTP status code
- HTTP headers
- Response body (JSON format)

## Project Structure

```
src/
├── App.java        # Main class with menu interface
├── ApiService.java # HTTP client service
└── Post.java      # Data model for posts
```

## Requirements

- **Java 11 or higher** (uses `java.net.http.HttpClient`)

## How to Run

```bash
cd src
javac *.java
java App
```

## Menu Options

When running the application, you will see:

```
1. Get a post by ID      - Fetch a single post by its ID
2. Get all posts       - Fetch all posts from the API
3. Create a new post  - Create a new post with custom data
4. Exit               - Close the application
```

## Example Output

### GET Request (post ID 1)
```
=== GET Request ===
Status Code: 200

=== HTTP Headers ===
content-type: [application/json; charset=utf-8]
...

=== Response Body (JSON) ===
{
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati...",
  "body": "quia et suscipit..."
}
```

### POST Request (create post)
```
=== POST Request ===
Status Code: 201

=== Response Body (JSON) ===
{
  "userId": 1,
  "title": "My First Post",
  "body": "This is my post content!",
  "id": 101
}
```

## Key Concepts

### GET vs POST
- **GET**: Retrieves data from the server (read-only)
- **POST**: Sends data to the server to create a new resource

### HTTP Status Codes
- **200 OK**: Request successful
- **201 Created**: Resource successfully created
- **400 Bad Request**: Invalid request
- **404 Not Found**: Resource not found
- **500 Internal Server Error**: Server error

### JSON (JavaScript Object Notation)
A lightweight data format used for data exchange between client and server. Example:
```json
{
  "userId": 1,
  "title": "My Post",
  "body": "Content here"
}
```

## Testing with Postman

For comparison, you can test the same API endpoints in Postman:

1. **GET** `https://jsonplaceholder.typicode.com/posts/1`
2. **GET** `https://jsonplaceholder.typicode.com/posts`
3. **POST** `https://jsonplaceholder.typicode.com/posts`

For POST, add body as raw JSON:
```json
{
  "userId": 1,
  "title": "My Post",
  "body": "Content"
}
```

## References

- [JSONPlaceholder API Docs](https://jsonplaceholder.typicode.com/)
- [Java HttpClient Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/package-summary.html)
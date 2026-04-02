package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTest {

    @Test
    public void getUsers() {
        RestAssured
                .given()
                .log().all()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .log().all()
                .statusCode(200);
    }

    // 1. Get a single user
    @Test
    public void getSingleUser() {
        given()
                .log().all()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .then()
                .log().all()
                .statusCode(200);
    }

    // 2. Get posts
    @Test
    public void getPosts() {
        given()
                .log().all()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .log().all()
                .statusCode(200);
    }

    // 3. Get a single post
    @Test
    public void getSinglePost() {
        given()
                .log().all()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .log().all()
                .statusCode(200);
    }

    // 4. Create a new post
    @Test
    public void createPost() {
        String body = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .log().all()
                .statusCode(201);
    }

    // 5. Update a post (PUT)
    @Test
    public void updatePost() {
        String body = "{ \"id\": 1, \"title\": \"updated title\", \"body\": \"updated body\", \"userId\": 1 }";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .log().all()
                .statusCode(200);
    }

    // 6. Partial update a post (PATCH)
    @Test
    public void patchPost() {
        String body = "{ \"title\": \"patched title\" }";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .patch("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .log().all()
                .statusCode(200);
    }

    // 7. Delete a post
    @Test
    public void deletePost() {
        given()
                .log().all()
                .when()
                .delete("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .log().all()
                .statusCode(200);
    }

    // 8. Get comments of a post
    @Test
    public void getPostComments() {
        given()
                .log().all()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1/comments")
                .then()
                .log().all()
                .statusCode(200);
    }

    // 9. Filter posts by userId
    @Test
    public void getPostsByUserId() {
        given()
                .log().all()
                .queryParam("userId", 1)
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .log().all()
                .statusCode(200);
    }

    // 10. Get todos
    @Test
    public void getTodos() {
        given()
                .log().all()
                .when()
                .get("https://jsonplaceholder.typicode.com/todos")
                .then()
                .log().all()
                .statusCode(200);
    }

    // 11. Get a single todo
    @Test
    public void getSingleTodo() {
        given()
                .log().all()
                .when()
                .get("https://jsonplaceholder.typicode.com/todos/1")
                .then()
                .log().all()
                .statusCode(200);
    }
}
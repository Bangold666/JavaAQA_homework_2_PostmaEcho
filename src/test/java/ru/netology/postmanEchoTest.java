package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class postmanEchoTest {

    @Test
    void shouldPostmanEchoApiFirstTest() {
        given()
                .baseUri("https://postman-echo.com")
                //.body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
                .body("ru.netology.api.postman")
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                //.body(/* --> ваша проверка здесь <-- */)
                .body("data", equalTo("ru.netology.api.postman"))
        ;
    }

    @Test
    void shouldPostmanEchoApiSecondTest() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Я спросил:,\n" +
                        "С чего начать прикажете?,\n" +
                        "В качестве жениха - с того кто вы такой, откуда? \n" +
                        "Зовусь Магометом я.")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Я спросил:,\n" +
                        "С чего начать прикажете?,\n" +
                        "В качестве жениха - с того кто вы такой, откуда? \n" +
                        "Зовусь Магометом я."))
        ;
    }
}

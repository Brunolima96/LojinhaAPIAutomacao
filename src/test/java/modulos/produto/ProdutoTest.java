package modulos.produto;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do modulo de Produto")
public class ProdutoTest {

    private String token;

    @BeforeEach
    public void beforeach() {

        //Configurando os dados da API Rest da Lojinha
        baseURI = "http://165.227.93.41";
        // port = 8080
        basePath = "/lojinha";
        //Obter o token do usuario admin
        this.token = given()
                .contentType(ContentType.JSON).body("{\n" +
                        "  \"usuarioLogin\": \"admin\",\n" +
                        "  \"usuarioSenha\": \"admin\"\n" +
                        "}")
                .when()
                .post("/v2/login")
                .then()
                .extract()
                .path("data.token");

    }

    @Test
    @DisplayName("Validar o limite 0 para o valor do produto")
    public void testValidarLimitesProibidoZerodovalordoProduto() {


        // Tentar inserir um produto com valor 0.00 e validar que a mensagem de erro foi apresentada eo
        // Status code retornado foi 422
        given().
                contentType(ContentType.JSON).
                header("token", this.token).
                body("{\n" +
                        "  \"produtoNome\": \"Playstation 5\",\n" +
                        "  \"produtoValor\": 0.00,\n" +
                        "  \"produtoCores\": [\n" +
                        "    \"Preto\"\n" +
                        "  ],\n" +
                        "  \"produtoUrlMock\": \"string\",\n" +
                        "  \"componentes\": [\n" +
                        "    {\n" +
                        "      \"componenteNome\": \"Controle\",\n" +
                        "      \"componenteQuantidade\": 2\n" +
                        "    },\n" +
                        "     {\n" +
                        "      \"componenteNome\": \"Jogo de futebol\",\n" +
                        "      \"componenteQuantidade\": 2\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}").
                post("/v2/produtos").
                then().
                assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);

    }

    // Tentar inserir um produto com valor 7000.01 e validar que a mensagem de erro foi apresentada eo
    // Status code retornado foi 422
    @Test
    @DisplayName("Validar o limite 7001 para o valor do produto")
    public void testValidarLimitesProibidoMaiorqueSeteMildoProduto() {
        given().
                contentType(ContentType.JSON).
                header("token", this.token).
                body("{\n" +
                        "  \"produtoNome\": \"Playstation 5\",\n" +
                        "  \"produtoValor\": 7000.01,\n" +
                        "  \"produtoCores\": [\n" +
                        "    \"Preto\"\n" +
                        "  ],\n" +
                        "  \"produtoUrlMock\": \"string\",\n" +
                        "  \"componentes\": [\n" +
                        "    {\n" +
                        "      \"componenteNome\": \"Controle\",\n" +
                        "      \"componenteQuantidade\": 2\n" +
                        "    },\n" +
                        "     {\n" +
                        "      \"componenteNome\": \"Jogo de futebol\",\n" +
                        "      \"componenteQuantidade\": 2\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}").
                post("/v2/produtos").
                then().
                assertThat().
                body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00")).
                statusCode(422);
    }

    // Tentar inserir um produto com valor 0.01 e validar que a mensagem  foi apresentada eo
    // Status code retornado foi 201
    @Test
    @DisplayName("Validar o valor 0,01 para o produto")
    public void testValidarValorOAceitoMaiorQueZero() {
        given().
                contentType(ContentType.JSON).
                header("token", this.token).
                body("{\n" +
                        "  \"produtoNome\": \"Playstation 5\",\n" +
                        "  \"produtoValor\": 0.01,\n" +
                        "  \"produtoCores\": [\n" +
                        "    \"Preto\"\n" +
                        "  ],\n" +
                        "  \"produtoUrlMock\": \"string\",\n" +
                        "  \"componentes\": [\n" +
                        "    {\n" +
                        "      \"componenteNome\": \"Controle\",\n" +
                        "      \"componenteQuantidade\": 2\n" +
                        "    },\n" +
                        "     {\n" +
                        "      \"componenteNome\": \"Jogo de futebol\",\n" +
                        "      \"componenteQuantidade\": 2\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}").
                post("/v2/produtos").
                then().
                assertThat().
                body("message", equalTo("Produto adicionado com sucesso"
                )).statusCode(201);

    }

    // Tentar inserir um produto com valor 7000.00 e validar que a mensagem  foi apresentada eo
    // Status code retornado foi 201
    @Test
    @DisplayName("Validar o valor 7000,00 para o produto")
    public void testValidaroValorIgualASeteMil() {
        given().
                contentType(ContentType.JSON).
                header("token", this.token).
                body("{\n" +
                        "  \"produtoNome\": \"Playstation 5\",\n" +
                        "  \"produtoValor\": 7000.00,\n" +
                        "  \"produtoCores\": [\n" +
                        "    \"Preto\"\n" +
                        "  ],\n" +
                        "  \"produtoUrlMock\": \"string\",\n" +
                        "  \"componentes\": [\n" +
                        "    {\n" +
                        "      \"componenteNome\": \"Controle\",\n" +
                        "      \"componenteQuantidade\": 2\n" +
                        "    },\n" +
                        "     {\n" +
                        "      \"componenteNome\": \"Jogo de futebol\",\n" +
                        "      \"componenteQuantidade\": 2\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}").
                post("/v2/produtos").
                then().
                assertThat().
                body("message", equalTo("Produto adicionado com sucesso")).
                statusCode(201);
    }

}

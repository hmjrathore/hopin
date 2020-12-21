import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HopinApiTest {

    static String getCompanySize(int employees) {
        if(employees <= 10)
            return "Small";
        else if(employees <= 1000)
            return "Medium";
        else
            return "Big";
    }

    @Test
    public void testCompanySize() {
        SoftAssert softAssert = new SoftAssert();
        List<Customer> customers =
           given()
                .baseUri("http://localhost")
                .port(3001)
                .contentType(ContentType.JSON)
                .body("{\"name\": \"Hopin\"}")
            .when()
                .post()
            .then()
                .assertThat()
                    .statusCode(200)
                    .body("name", is(equalTo("Hopin")))
                    .extract().response().jsonPath().getList("customers", Customer.class);

        assertThat(customers.size(), is(equalTo(6)));

        for(Customer customer : customers) {
            softAssert.assertEquals(customer.getSize(), getCompanySize(customer.getEmployees()), "Company size for " + customer.getName() + " is");
        }
        softAssert.assertAll();
    }
}

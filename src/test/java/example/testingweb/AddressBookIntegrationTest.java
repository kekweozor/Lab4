package example.testingweb;


import org.example.AccessingDataApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes= AccessingDataApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressBookIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getAddressBooks_shouldReturnOk() {
        String url = "http://localhost:" + port + "/addressbooks";

        ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).contains("addressbook"); // adjust to your expected content
    }
}

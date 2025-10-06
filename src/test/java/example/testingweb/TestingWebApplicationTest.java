package example.testingweb;

import org.example.AccessingDataApplication;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes= AccessingDataApplication.class)
class TestingWebApplicationTest {

    @Test
    void contextLoads() {}
}

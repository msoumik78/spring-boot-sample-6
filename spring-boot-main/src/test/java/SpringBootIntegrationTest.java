import lombok.extern.slf4j.Slf4j;
import org.example.BankCustomer;
import org.example.BankCustomersStarter;
import org.example.dao.DataHolder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;


@ExtendWith(MockitoExtension.class)
@Import(BankCustomersTestConfiguration.class)
@SpringBootTest(classes = BankCustomersStarter.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class SpringBootIntegrationTest {

    @LocalServerPort
    private int port = 0;

    @Autowired
    private RestTemplate restTemplate;

    @BeforeAll
    public static void setup(){
        BankCustomer bankCustomer1 = new BankCustomer("name1", 40, "kolkata", "wb", "developer");
        BankCustomer bankCustomer2 = new BankCustomer("name2", 42, "mumbai", "maharashtra", "developer");
        DataHolder.bankCustomerSimpleHashMap.put(bankCustomer1.name(), bankCustomer1);
        DataHolder.bankCustomerSimpleHashMap.put(bankCustomer2.name(), bankCustomer2);
    }

    @Test
    public void testIfContextLoads() {
        log.info("context loaded successfully with port = "+port);
    }

    @Test
    public void getCustomer() {
        BankCustomer bankCustomer =
                restTemplate.getForObject("http://localhost:" + port + "/api/1/bank-customers/name1",
                        BankCustomer.class);
        Assertions.assertEquals(bankCustomer.age(),40);
    }
}

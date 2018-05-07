package ru.tinkoff.demoproject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tinkoff.demoproject.entity.Client;
import ru.tinkoff.demoproject.entity.ClientResponseDto;
import ru.tinkoff.demoproject.entity.Products;
import ru.tinkoff.demoproject.exceptions.ClientNotFoundException;
import ru.tinkoff.demoproject.repository.ClientRepository;
import ru.tinkoff.demoproject.repository.ProductRepository;
import ru.tinkoff.demoproject.service.ClientService;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoProjectApplicationTests {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    @Qualifier("service")
    private ClientService service;

    private final Logger log = Logger.getLogger("DemoProjectApplicationTests");

    @Test
    public void testGetClientById() {
        Client client = clientRepository.findById(1L).get();
        Assert.assertEquals("User2", client.getName());
    }

    @Test
    public void testGetProductByClientId() {
        List<Products> productsByClientId = productRepository.findProductsByClientId(1);
        Assert.assertEquals(2, productsByClientId.size());
    }

    @Test(expected = ClientNotFoundException.class)
    public void testClientNotFound() throws ClientNotFoundException {
        service.getByContactId(5);
    }

    @Test(expected = RuntimeException.class)
    public void testProductNotFound() throws ClientNotFoundException {
        service.getByContactId(4);
    }

    @Test
    public void testService() throws ClientNotFoundException{
        ClientResponseDto dto = service.getByContactId(3L);
        Assert.assertEquals("2018-05-30T11:55:00", dto.getDateCreated().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        /*String content = "{\"contactId\":3,\"applicationId\":6,\"dateCreated\":\"2018-05-30T11:55:00\",\"productName\":\"Валютные услуги\"}";
        ClientResponseDto dto = service.getByContactId(3L);
        ClientResponseDto dto = service.getByContactId(3L);

        ObjectMapper mapper = new ObjectMapper();
        String actual = mapper.writeValueAsString(dto);
        log.info("Actual json: " + actual);
        JSONAssert.assertEquals(content, actual, false);*/

    }

}

package ru.tinkoff.demoproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.tinkoff.demoproject.exceptions.ClientNotFoundException;
import ru.tinkoff.demoproject.entity.Client;
import ru.tinkoff.demoproject.entity.ClientResponseDto;
import ru.tinkoff.demoproject.entity.Products;
import ru.tinkoff.demoproject.repository.ClientRepository;
import ru.tinkoff.demoproject.repository.ProductRepository;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@Service(value = "service")
public class ClientServiceImpl implements ClientService {
    private static final Logger LOG = Logger.getLogger("ClientServiceImpl");

    @Autowired
    ClientRepository repository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public ClientResponseDto getByContactId(long contactId) throws ClientNotFoundException {
        LOG.info("Get last product for contact with id: " + contactId);

        Client client = repository.findById(contactId).orElseThrow(() ->
                new ClientNotFoundException("Client with contactId = " + contactId + " not found."));

        List<Products> products = productRepository.findProductsByClientId(contactId);
        if (products.isEmpty()) {
            throw new RuntimeException("Client with contactId = " + contactId + " hasn't any products.");
        }

        Products order = products.stream().max(Comparator.comparing(Products::getDateCreated)).get();

        ClientResponseDto clientResponseDto = new ClientResponseDto();
        clientResponseDto.setContactId(client.getContactId());
        clientResponseDto.setApplicationId(order.getApplicationId());
        clientResponseDto.setDateCreated(order.getDateCreated());
        clientResponseDto.setProductName(order.getProductName());

        return clientResponseDto;
    }
}

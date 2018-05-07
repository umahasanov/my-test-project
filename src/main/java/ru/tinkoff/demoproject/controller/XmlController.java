package ru.tinkoff.demoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.demoproject.exceptions.ClientNotFoundException;
import ru.tinkoff.demoproject.entity.ClientResponseDto;
import ru.tinkoff.demoproject.service.ClientService;

@RestController
@RequestMapping("xml")
public class XmlController {

    @Autowired
    @Qualifier("service")
    private ClientService service;

    @GetMapping(value = "/getLastClientProduct/{contactId}",
            produces = {MediaType.APPLICATION_XML_VALUE})
    public ClientResponseDto getLastClientProduct(@PathVariable("contactId") Long contactId) throws ClientNotFoundException {
        return service.getByContactId(contactId);
    }


}

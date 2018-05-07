package ru.tinkoff.demoproject.service;

import org.springframework.stereotype.Service;
import ru.tinkoff.demoproject.exceptions.ClientNotFoundException;
import ru.tinkoff.demoproject.entity.ClientResponseDto;

@Service
public interface ClientService {
    ClientResponseDto getByContactId(long contactId) throws ClientNotFoundException;
}

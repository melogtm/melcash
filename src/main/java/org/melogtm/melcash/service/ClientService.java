package org.melogtm.melcash.service;

import org.melogtm.melcash.domain.Client;
import org.melogtm.melcash.domain.dto.ClientRequest;
import org.melogtm.melcash.enums.ClientType;
import org.melogtm.melcash.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Optional<Client> getClientById(Long id) {
        return repository.findClientById(id);
    }

    public void createClient(ClientRequest clientRequest) {
        String clientType = clientRequest.type().toUpperCase();

        if (!clientType.equals("INDIVIDUAL") && !clientType.equals("STORE")) {
            throw new IllegalArgumentException("Invalid client type");
        }

        ClientType myType = ClientType.valueOf(clientType);

        Client client = new Client(
                clientRequest.name(),
                clientRequest.cpf(),
                clientRequest.email(),
                clientRequest.password(),
                myType,
                clientRequest.cash()
        );

        repository.save(client);
    }

    public void addCash(Client client, Double value) {
        repository.addCash(client.getId(), value);
    }

    public void removeCash(Client client, Double value) {
        repository.removeCash(client.getId(), value);
    }
}

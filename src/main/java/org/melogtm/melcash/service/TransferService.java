package org.melogtm.melcash.service;

import org.melogtm.melcash.domain.Client;
import org.melogtm.melcash.enums.ClientType;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class TransferService {

    private final ClientService clientService;
    private final AuthService auth;

    public TransferService(ClientService clientService, AuthService auth) {
        this.clientService = clientService;
        this.auth = auth;
    }

    public void transfer(Long id_payer, Long id_payee, Double value) {
        if (Objects.equals(id_payer, id_payee) || value <= 0) throw new IllegalArgumentException("Invalid transfer");

        Optional<Client> payer = clientService.getClientById(id_payer);
        Optional<Client> payee = clientService.getClientById(id_payee);

        if (payer.isEmpty() || payee.isEmpty() || payer.get().getType() == ClientType.STORE)
            throw new IllegalArgumentException("One of the clients was not found or is a store");

        if (payer.get().getCash() < value) throw new IllegalArgumentException("Insufficient funds");

        clientService.removeCash(payer.get(), value);
        clientService.addCash(payee.get(), value);

        if (auth.isAuthorized()) {
            System.out.println("Professional DEBUG: (TRANSFER) Transfer successful");
        } else {
            System.out.println("Professional DEBUG: (TRANSFER) Transfer failed");
            clientService.addCash(payer.get(), value);
            clientService.removeCash(payee.get(), value);
        }
    }
}

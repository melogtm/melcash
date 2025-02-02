package org.melogtm.melcash.controller;

import org.melogtm.melcash.domain.Client;
import org.melogtm.melcash.domain.Transfer;
import org.melogtm.melcash.domain.dto.ClientRequest;
import org.melogtm.melcash.service.ClientService;
import org.melogtm.melcash.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class ClientController {

    final private ClientService clientService;
    final private TransferService transferService;

    public ClientController(ClientService clientService, TransferService transferService) {
        this.clientService = clientService;
        this.transferService = transferService;
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        Optional<Client> client = clientService.getClientById(id);

        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping("/create/client")
    public ResponseEntity<?> createClient(@ModelAttribute ClientRequest clientRequest) {

        clientService.createClient(clientRequest);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody Transfer transfer) {

        transferService.transfer(
                transfer.getPayer(),
                transfer.getPayee(),
                transfer.getValue()
        );

    }


}

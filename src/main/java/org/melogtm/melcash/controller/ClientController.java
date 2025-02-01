package org.melogtm.melcash.controller;

import org.melogtm.melcash.domain.Transfer;
import org.melogtm.melcash.domain.dto.ClientRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ClientController {

    @GetMapping("/client/{id}")
    public ResponseEntity<?> getClient(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create/client")
    public ResponseEntity<?> createClient(@ModelAttribute ClientRequest clientRequest0) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody Transfer transfer) {
    }


}

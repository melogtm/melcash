package org.melogtm.melcash.domain;

import lombok.NoArgsConstructor;
import org.melogtm.melcash.enums.ClientType;

@NoArgsConstructor
public class StoreClient extends AbstractClient {

    public StoreClient(String name, String cpf, String email, String password) {
        super(name, cpf, email, password, ClientType.STORE);
    }

}

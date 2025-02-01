package org.melogtm.melcash.domain;

import org.melogtm.melcash.enums.ClientType;

public class CommonClient extends AbstractClient {

    public CommonClient(String name, String cpf, String email, String password) {
        super(name, cpf, email, password, ClientType.INDIVIDUAL);
    }

}

package org.melogtm.melcash.domain;

import jakarta.persistence.*;
import lombok.*;
import org.melogtm.melcash.enums.ClientType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ClientType type;

    @Column(name = "cash")
    private Double cash;

    public Client(String name, String cpf, String email,
                  String password, ClientType type,
                  Double cash) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.type = type;
        this.cash = cash;
    }

}

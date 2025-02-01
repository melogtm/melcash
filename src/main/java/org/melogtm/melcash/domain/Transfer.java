package org.melogtm.melcash.domain;

import lombok.Data;

@Data
public class Transfer {
    private Double value;
    private Long payer;
    private Long payee;
}

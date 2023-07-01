package com.br.tracing.adapters.in.controller.responseDTO;

import com.br.tracing.application.core.model.Address;
import lombok.Data;

@Data
public class CustomerResponseDTO {
    private Long id;
    private String name;
    private String cpf;
    private String cep;
    private Address address;
}

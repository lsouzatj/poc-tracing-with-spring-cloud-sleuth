package com.br.tracing.adapters.in.controller.responseDTO;

import com.br.tracing.application.core.model.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude    (JsonInclude.Include.NON_NULL)
public class CustomerResponseDTO {
    private Long id;
    private String name;
    private String cpf;
    private String cep;
    private Address address;
}

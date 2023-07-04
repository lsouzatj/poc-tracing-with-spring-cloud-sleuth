package com.br.tracing.application.ports.out;

import com.br.tracing.application.core.model.Address;

public interface FindAddressByZipCodeOutput {
    Address findByZipCode(String zipCode);
}

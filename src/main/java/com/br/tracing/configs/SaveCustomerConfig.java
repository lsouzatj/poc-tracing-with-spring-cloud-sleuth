package com.br.tracing.configs;

import com.br.tracing.adapters.out.InsertCustomerOutputAdapter;
import com.br.tracing.adapters.out.FindAddressByZipCodeOutputAdapter;
import com.br.tracing.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveCustomerConfig {
    @Bean
    InsertCustomerUseCase saveCustomerUseCase(InsertCustomerOutputAdapter saveCustomerOutputAdapter,
                                              FindAddressByZipCodeOutputAdapter FindAddressByZipCodeOutputAdapter){
        return new InsertCustomerUseCase(saveCustomerOutputAdapter, FindAddressByZipCodeOutputAdapter);
    }
}

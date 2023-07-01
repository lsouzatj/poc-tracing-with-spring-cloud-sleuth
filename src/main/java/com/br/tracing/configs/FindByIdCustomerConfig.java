package com.br.tracing.configs;

import com.br.tracing.adapters.out.FindAddressByZipCodeOutputAdapter;
import com.br.tracing.adapters.out.FindByIdCustomerOutputAdapater;
import com.br.tracing.application.core.usecase.FindByIdCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindByIdCustomerConfig {
    @Bean
    public FindByIdCustomerUseCase findByIdCustomerUseCase(FindByIdCustomerOutputAdapater findByIdCustomerOutputAdapater,
                                                           FindAddressByZipCodeOutputAdapter findAddressByZipCodeOutputAdapter){
        return new FindByIdCustomerUseCase(findByIdCustomerOutputAdapater, findAddressByZipCodeOutputAdapter);
    }
}

package com.br.tracing.configs;

import com.br.tracing.adapters.out.FindAddressByZipCodeOutputAdapter;
import com.br.tracing.adapters.out.FindAllCustomerOutputAdapter;
import com.br.tracing.application.core.usecase.FindAllCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllCustomerConfig {
    @Bean
    public FindAllCustomerUseCase findAllCustomerUseCase(FindAllCustomerOutputAdapter findAllCustomerOutputAdapter,
                                                         FindAddressByZipCodeOutputAdapter findAddressByZipCodeOutputAdapter){
        return new FindAllCustomerUseCase(findAllCustomerOutputAdapter, findAddressByZipCodeOutputAdapter);
    }
}

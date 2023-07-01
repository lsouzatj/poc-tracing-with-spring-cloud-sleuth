package com.br.tracing.configs;

import com.br.tracing.adapters.out.SendKafkaCustomerOutputAdapter;
import com.br.tracing.adapters.out.UpdateCustomerOutputAdapter;
import com.br.tracing.application.core.usecase.FindByIdCustomerUseCase;
import com.br.tracing.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {
    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(UpdateCustomerOutputAdapter updateCustomerOutputAdapter,
                                                       FindByIdCustomerUseCase findByIdCustomerUseCase,
                                                       SendKafkaCustomerOutputAdapter sendKafkaCustomerOutputAdapter) {
        return new UpdateCustomerUseCase(updateCustomerOutputAdapter, findByIdCustomerUseCase, sendKafkaCustomerOutputAdapter);
    }
}

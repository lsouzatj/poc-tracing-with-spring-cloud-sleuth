package com.br.tracing.configs;

import com.br.tracing.adapters.out.DeleteByIdCustomerOutputAdapter;
import com.br.tracing.application.core.usecase.DeleteByIdCustomerUserCase;
import com.br.tracing.application.core.usecase.FindByIdCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteByIdCustomerConfig {
    @Bean
    public DeleteByIdCustomerUserCase deleteByIdCustomerUserCase(DeleteByIdCustomerOutputAdapter deleteByIdCustomerOutputAdapter,
                                                                 FindByIdCustomerUseCase findByIdCustomerUseCase){
        return new DeleteByIdCustomerUserCase(deleteByIdCustomerOutputAdapter, findByIdCustomerUseCase);
    }
}

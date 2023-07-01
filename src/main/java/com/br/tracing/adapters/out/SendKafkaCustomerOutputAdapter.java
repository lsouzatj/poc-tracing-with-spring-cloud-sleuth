package com.br.tracing.adapters.out;

import com.br.tracing.adapters.out.producer.SendKafkaCustomer;
import com.br.tracing.application.core.model.Customer;
import com.br.tracing.application.ports.out.SendKafkaCustomerOuputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendKafkaCustomerOutputAdapter implements SendKafkaCustomerOuputPort {

    private final SendKafkaCustomer sendKafkaCustomer;

    @Override
    public void send(Customer customer) {
        sendKafkaCustomer.send(customer);
    }
}

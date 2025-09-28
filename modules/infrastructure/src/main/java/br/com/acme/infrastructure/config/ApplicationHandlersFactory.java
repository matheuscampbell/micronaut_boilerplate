package br.com.acme.infrastructure.config;

import br.com.acme.application.customer.CreateCustomerHandler;
import br.com.acme.application.customer.GetCustomerHandler;
import br.com.acme.application.ports.CustomerReadModel;
import br.com.acme.application.ports.EmailUniquenessChecker;
import br.com.acme.domain.customer.CustomerRepository;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class ApplicationHandlersFactory {

  @Singleton
  CreateCustomerHandler createCustomerHandler(
      CustomerRepository repository, EmailUniquenessChecker emailChecker) {
    return new CreateCustomerHandler(repository, emailChecker);
  }

  @Singleton
  GetCustomerHandler getCustomerHandler(CustomerReadModel readModel) {
    return new GetCustomerHandler(readModel);
  }
}

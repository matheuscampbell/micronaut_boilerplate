package br.com.acme.infrastructure.config;

import br.com.acme.application.cqrs.CommandBus;
import br.com.acme.application.cqrs.QueryBus;
import br.com.acme.application.cqrs.inmem.InMemoryCommandBus;
import br.com.acme.application.cqrs.inmem.InMemoryQueryBus;
import br.com.acme.application.customer.CreateCustomerCommand;
import br.com.acme.application.customer.CreateCustomerHandler;
import br.com.acme.application.customer.GetCustomerHandler;
import br.com.acme.application.customer.GetCustomerQuery;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
public class CqrsConfiguration {

  @Singleton
  CommandBus commandBus(CreateCustomerHandler createCustomerHandler) {
    var bus = new InMemoryCommandBus();
    bus.register(CreateCustomerCommand.class, createCustomerHandler);
    return bus;
  }

  @Singleton
  QueryBus queryBus(GetCustomerHandler getCustomerHandler) {
    var bus = new InMemoryQueryBus();
    bus.register(GetCustomerQuery.class, getCustomerHandler);
    return bus;
  }
}

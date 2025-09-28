package br.com.acme.infrastructure.readmodel.memory;

import br.com.acme.application.customer.CustomerView;
import br.com.acme.application.ports.CustomerReadModel;
import br.com.acme.infrastructure.support.InMemoryCustomerStore;
import jakarta.inject.Singleton;

@Singleton
public class InMemoryCustomerReadModel implements CustomerReadModel {
  private final InMemoryCustomerStore store;

  public InMemoryCustomerReadModel(InMemoryCustomerStore store) {
    this.store = store;
  }

  @Override
  public CustomerView findById(String id) {
    var customer = store.customers().get(id);
    if (customer == null) {
      throw new IllegalArgumentException("Customer not found: " + id);
    }
    return new CustomerView(id, customer.name(), customer.email());
  }
}

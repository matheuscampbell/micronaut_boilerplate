package br.com.acme.infrastructure.persistence.memory;

import br.com.acme.domain.customer.Customer;
import br.com.acme.domain.customer.CustomerId;
import br.com.acme.domain.customer.CustomerRepository;
import br.com.acme.infrastructure.support.InMemoryCustomerStore;
import jakarta.inject.Singleton;
import java.util.Optional;

@Singleton
public class InMemoryCustomerRepository implements CustomerRepository {
  private final InMemoryCustomerStore store;

  public InMemoryCustomerRepository(InMemoryCustomerStore store) {
    this.store = store;
  }

  @Override
  public void save(Customer customer) {
    store.customers().put(customer.id().toString(), customer);
  }

  @Override
  public Optional<Customer> findById(CustomerId id) {
    return Optional.ofNullable(store.customers().get(id.toString()));
  }

  @Override
  public boolean existsByEmail(String email) {
    return store.customers().values().stream()
        .anyMatch(customer -> customer.email().equalsIgnoreCase(email));
  }
}

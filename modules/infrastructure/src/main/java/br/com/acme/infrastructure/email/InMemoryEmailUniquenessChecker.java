package br.com.acme.infrastructure.email;

import br.com.acme.application.ports.EmailUniquenessChecker;
import br.com.acme.infrastructure.support.InMemoryCustomerStore;
import jakarta.inject.Singleton;

@Singleton
public class InMemoryEmailUniquenessChecker implements EmailUniquenessChecker {
  private final InMemoryCustomerStore store;

  public InMemoryEmailUniquenessChecker(InMemoryCustomerStore store) {
    this.store = store;
  }

  @Override
  public void ensureAvailable(String email) {
    boolean exists = store.customers().values().stream()
        .anyMatch(customer -> customer.email().equalsIgnoreCase(email));
    if (exists) {
      throw new IllegalArgumentException("Email already in use: " + email);
    }
  }
}

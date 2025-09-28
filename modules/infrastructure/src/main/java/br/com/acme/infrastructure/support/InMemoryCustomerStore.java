package br.com.acme.infrastructure.support;

import br.com.acme.domain.customer.Customer;
import jakarta.inject.Singleton;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class InMemoryCustomerStore {
  private final Map<String, Customer> customers = new ConcurrentHashMap<>();

  public Map<String, Customer> customers() {
    return customers;
  }
}

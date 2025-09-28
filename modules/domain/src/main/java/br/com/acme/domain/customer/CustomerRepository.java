package br.com.acme.domain.customer;

import java.util.Optional;

public interface CustomerRepository {
  void save(Customer customer);

  Optional<Customer> findById(CustomerId id);

  boolean existsByEmail(String email);
}

package br.com.acme.domain.customer;

import java.util.Objects;

public record Customer(CustomerId id, String name, String email) {
  public Customer {
    Objects.requireNonNull(id, "id");
    Objects.requireNonNull(name, "name");
    Objects.requireNonNull(email, "email");
  }

  public static Customer create(String name, String email) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("name must not be blank");
    }
    if (email == null || email.isBlank()) {
      throw new IllegalArgumentException("email must not be blank");
    }
    return new Customer(CustomerId.newId(), name, email);
  }
}

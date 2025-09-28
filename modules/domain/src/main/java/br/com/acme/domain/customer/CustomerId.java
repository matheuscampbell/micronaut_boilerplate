package br.com.acme.domain.customer;

import java.util.UUID;

public record CustomerId(UUID value) {
  public static CustomerId newId() {
    return new CustomerId(UUID.randomUUID());
  }

  @Override
  public String toString() {
    return value.toString();
  }
}

package br.com.acme.api.customer;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public record CreatedCustomerResponse(String id) {}

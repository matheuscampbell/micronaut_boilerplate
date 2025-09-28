package br.com.acme.api.customer;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public record CustomerResponse(String id, String name, String email) {}

package br.com.acme.api.customer;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Serdeable.Deserializable
public record CreateCustomerRequest(@NotBlank String name, @NotBlank @Email String email) {}

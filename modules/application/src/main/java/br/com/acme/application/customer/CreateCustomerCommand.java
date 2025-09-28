package br.com.acme.application.customer;

import br.com.acme.application.cqrs.Command;

public record CreateCustomerCommand(String name, String email) implements Command {}

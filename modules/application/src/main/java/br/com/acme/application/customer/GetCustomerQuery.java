package br.com.acme.application.customer;

import br.com.acme.application.cqrs.Query;

public record GetCustomerQuery(String id) implements Query<CustomerView> {}

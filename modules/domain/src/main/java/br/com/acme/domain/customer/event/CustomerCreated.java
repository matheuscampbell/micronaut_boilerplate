package br.com.acme.domain.customer.event;

public record CustomerCreated(String id, String name, String email) {}

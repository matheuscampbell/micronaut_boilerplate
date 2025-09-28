package br.com.acme.application.cqrs;

public interface CommandBus {
  <C extends Command, R> R dispatch(C command);
}

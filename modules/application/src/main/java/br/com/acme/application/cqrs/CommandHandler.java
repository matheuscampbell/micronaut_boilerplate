package br.com.acme.application.cqrs;

@FunctionalInterface
public interface CommandHandler<C extends Command, R> {
  R handle(C command);
}

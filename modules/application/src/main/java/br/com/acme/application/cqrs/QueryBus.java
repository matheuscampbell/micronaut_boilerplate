package br.com.acme.application.cqrs;

public interface QueryBus {
  <Q extends Query<R>, R> R ask(Q query);
}

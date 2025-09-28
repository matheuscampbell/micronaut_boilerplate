package br.com.acme.application.cqrs;

@FunctionalInterface
public interface QueryHandler<Q extends Query<R>, R> {
  R handle(Q query);
}

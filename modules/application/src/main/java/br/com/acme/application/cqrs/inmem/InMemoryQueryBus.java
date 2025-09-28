package br.com.acme.application.cqrs.inmem;

import br.com.acme.application.cqrs.Query;
import br.com.acme.application.cqrs.QueryBus;
import br.com.acme.application.cqrs.QueryHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryQueryBus implements QueryBus {
  private final Map<Class<?>, QueryHandler<?, ?>> handlers = new ConcurrentHashMap<>();

  public <Q extends Query<R>, R> void register(Class<Q> type, QueryHandler<Q, R> handler) {
    handlers.put(type, handler);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <Q extends Query<R>, R> R ask(Q query) {
    var handler = (QueryHandler<Q, R>) handlers.get(query.getClass());
    if (handler == null) {
      throw new IllegalStateException("No handler registered for query " + query.getClass());
    }
    return handler.handle(query);
  }
}

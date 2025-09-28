package br.com.acme.application.cqrs.inmem;

import br.com.acme.application.cqrs.Command;
import br.com.acme.application.cqrs.CommandBus;
import br.com.acme.application.cqrs.CommandHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class InMemoryCommandBus implements CommandBus {
  private final Map<Class<?>, CommandHandler<?, ?>> handlers = new ConcurrentHashMap<>();

  public <C extends Command, R> void register(Class<C> type, CommandHandler<C, R> handler) {
    handlers.put(type, handler);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <C extends Command, R> R dispatch(C command) {
    var handler = (CommandHandler<C, R>) handlers.get(command.getClass());
    if (handler == null) {
      throw new IllegalStateException("No handler registered for command " + command.getClass());
    }
    return handler.handle(command);
  }
}

package br.com.acme.application.customer;

import br.com.acme.application.cqrs.QueryHandler;
import br.com.acme.application.ports.CustomerReadModel;

public final class GetCustomerHandler implements QueryHandler<GetCustomerQuery, CustomerView> {
  private final CustomerReadModel readModel;

  public GetCustomerHandler(CustomerReadModel readModel) {
    this.readModel = readModel;
  }

  @Override
  public CustomerView handle(GetCustomerQuery query) {
    return readModel.findById(query.id());
  }
}

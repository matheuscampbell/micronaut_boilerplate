package br.com.acme.application.customer;

import br.com.acme.application.cqrs.CommandHandler;
import br.com.acme.application.ports.EmailUniquenessChecker;
import br.com.acme.domain.customer.Customer;
import br.com.acme.domain.customer.CustomerId;
import br.com.acme.domain.customer.CustomerRepository;

public final class CreateCustomerHandler implements CommandHandler<CreateCustomerCommand, CustomerId> {
  private final CustomerRepository repository;
  private final EmailUniquenessChecker emailChecker;

  public CreateCustomerHandler(CustomerRepository repository, EmailUniquenessChecker emailChecker) {
    this.repository = repository;
    this.emailChecker = emailChecker;
  }

  @Override
  public CustomerId handle(CreateCustomerCommand command) {
    emailChecker.ensureAvailable(command.email());
    var customer = Customer.create(command.name(), command.email());
    repository.save(customer);
    return customer.id();
  }
}

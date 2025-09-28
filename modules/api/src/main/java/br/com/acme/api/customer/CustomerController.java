package br.com.acme.api.customer;

import br.com.acme.application.cqrs.CommandBus;
import br.com.acme.application.cqrs.QueryBus;
import br.com.acme.application.customer.CreateCustomerCommand;
import br.com.acme.application.customer.CustomerView;
import br.com.acme.application.customer.GetCustomerQuery;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/v1/customers")
@Tag(name = "Customers")
public class CustomerController {
  private final CommandBus commandBus;
  private final QueryBus queryBus;

  public CustomerController(CommandBus commandBus, QueryBus queryBus) {
    this.commandBus = commandBus;
    this.queryBus = queryBus;
  }

  @Operation(summary = "Cria um cliente")
  @Post
  public HttpResponse<CreatedCustomerResponse> create(@Body @Valid CreateCustomerRequest request) {
    var id = commandBus.dispatch(new CreateCustomerCommand(request.name(), request.email()));
    return HttpResponse.created(new CreatedCustomerResponse(id.toString()));
  }

  @Operation(summary = "Busca cliente por ID")
  @Get("/{id}")
  public CustomerResponse getById(@PathVariable String id) {
    CustomerView view = queryBus.ask(new GetCustomerQuery(id));
    return new CustomerResponse(view.id(), view.name(), view.email());
  }
}

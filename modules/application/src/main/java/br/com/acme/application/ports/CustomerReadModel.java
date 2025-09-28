package br.com.acme.application.ports;

import br.com.acme.application.customer.CustomerView;

public interface CustomerReadModel {
  CustomerView findById(String id);
}

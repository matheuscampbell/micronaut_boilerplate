package br.com.acme.application.ports;

public interface EmailUniquenessChecker {
  void ensureAvailable(String email);
}

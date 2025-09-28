package br.com.acme.common;

public sealed interface Result<T> permits Result.Ok, Result.Err {
  record Ok<T>(T value) implements Result<T> {}

  record Err<T>(String message, String code) implements Result<T> {}
}

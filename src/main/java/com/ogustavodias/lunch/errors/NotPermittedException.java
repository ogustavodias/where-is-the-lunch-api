package com.ogustavodias.lunch.errors;

public class NotPermittedException extends RuntimeException {
   public NotPermittedException(String message) {
      super(message);
   }
}

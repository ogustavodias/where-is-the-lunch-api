package com.ogustavodias.lunch.errors;

public class EntityNotFoundException extends RuntimeException {
   public EntityNotFoundException(String message) {
      super(message);
   }
}

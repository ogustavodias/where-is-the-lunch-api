package com.ogustavodias.lunch.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SurveyTest {

   private Survey survey;

   @BeforeEach
   void setUp() {
      Instant createdAt = LocalDateTime.of(2026, 01, 31, 11, 0).toInstant(ZoneOffset.UTC);
      this.survey = new Survey();
      this.survey.setCreatedAt(createdAt);
      this.survey.calcExpiresAt();
   }

   @Test
   void shouldExpireSameDayAtMiddayWhenCreatedBeforeNoon() {
      Instant expiresAt = this.survey.getExpiresAt();
      Instant expected = LocalDateTime.of(2026, 01, 31, 12, 0).toInstant(ZoneOffset.UTC);
      assertEquals(expiresAt, expected);
   }

}

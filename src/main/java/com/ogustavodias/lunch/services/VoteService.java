package com.ogustavodias.lunch.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.ogustavodias.lunch.errors.EntityNotFoundException;
import com.ogustavodias.lunch.errors.NotPermittedException;
import com.ogustavodias.lunch.models.Vote;
import com.ogustavodias.lunch.repositories.VoteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class VoteService {

   private final VoteRepository repository;

   public Vote searchVote(Long id) {
      String notFoundMessage = String.format("Participant with id %s not found", id);
      return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(notFoundMessage));
   }

   public Vote registerVote(Vote vote) {
      Instant now = LocalDateTime.now().toInstant(ZoneOffset.UTC);
      Instant noon = LocalDate.now().atTime(LocalTime.NOON).toInstant(ZoneOffset.UTC);
      
      if (now.compareTo(noon) >= 0)
         throw new NotPermittedException("Não é permitido votar após o horário do almoço");

      return null;
   }

}

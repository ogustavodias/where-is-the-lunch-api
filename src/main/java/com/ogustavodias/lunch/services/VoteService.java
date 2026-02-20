package com.ogustavodias.lunch.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.ogustavodias.lunch.errors.EntityNotFoundException;
import com.ogustavodias.lunch.errors.NotPermittedException;
import com.ogustavodias.lunch.models.Participant;
import com.ogustavodias.lunch.models.Vote;
import com.ogustavodias.lunch.repositories.VoteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class VoteService {

   private final VoteRepository repository;
   private final WinnerService winnerService;

   public Vote searchVote(Long id) {
      String notFoundMessage = String.format("Vote with id %s not found", id);
      return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(notFoundMessage));
   }

   public Vote registerVote(Vote vote) {
      /*
       * if (isAfterNoon())
       * throw new
       * NotPermittedException("Não é permitido votar após o horário do almoço");
       */

      if (hasVotedToday(vote.getParticipant()))
         throw new NotPermittedException("Não é permitido votar mais de uma vez ao dia");

      if (winnerService.alreadyWonThisWeek(vote.getRestaurant(), LocalDate.now()))
         throw new NotPermittedException("Não é permitido votar em um restaurante que já venceu na semana vigente");

      return repository.save(vote);
   }

   public boolean hasVotedToday(Participant participant) {
      LocalDate now = LocalDate.now();
      return repository.existsByParticipantAndVoteDate(participant, now);
   }

   public boolean isAfterNoon() {
      Instant now = LocalDateTime.now().toInstant(ZoneOffset.UTC);
      Instant noon = LocalDate.now().atTime(LocalTime.NOON).toInstant(ZoneOffset.UTC);
      return now.compareTo(noon) >= 0;
   }

}
package com.ogustavodias.lunch.services;

import org.springframework.stereotype.Service;

import com.ogustavodias.lunch.errors.EntityNotFoundException;
import com.ogustavodias.lunch.models.Vote;
import com.ogustavodias.lunch.repositories.VoteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VoteService {

      private final VoteRepository repository;

      public Vote searchVote(Long id) {
            String notFoundMessage = String.format("Participant with id %s not found", id);
            return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(notFoundMessage));
      }

}

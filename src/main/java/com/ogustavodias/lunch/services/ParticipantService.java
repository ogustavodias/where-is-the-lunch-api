package com.ogustavodias.lunch.services;

import org.springframework.stereotype.Service;

import com.ogustavodias.lunch.errors.EntityNotFoundException;
import com.ogustavodias.lunch.models.Participant;
import com.ogustavodias.lunch.repositories.ParticipantRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ParticipantService {

   private final ParticipantRepository repository;

   public Participant findParticipant(Long id) {
      String notFoundMessage = String.format("Participant with id %s not found", id);
      return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(notFoundMessage));
   }

}

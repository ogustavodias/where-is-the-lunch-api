package com.ogustavodias.lunch.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ogustavodias.lunch.models.Participant;
import com.ogustavodias.lunch.services.ParticipantService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("participants")
public class ParticipantController {

   private final ParticipantService service;

   @GetMapping("/{id}")
   public Participant searchParticipant(@PathVariable Long id) {
      return service.findParticipant(id);
   }

}

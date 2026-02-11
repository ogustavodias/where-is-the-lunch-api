package com.ogustavodias.lunch.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ogustavodias.lunch.models.Vote;
import com.ogustavodias.lunch.services.VoteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("votes")
public class VoteController {

   private final VoteService service;

   @GetMapping("/{id}")
   public Vote searchVote(@PathVariable Long id) {
      return service.searchVote(id);
   }

   @PostMapping
   public void registerVote() {
      service.registerVote(null);
   }

}

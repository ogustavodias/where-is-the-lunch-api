package com.ogustavodias.lunch.controllers;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ogustavodias.lunch.models.Participant;
import com.ogustavodias.lunch.models.Restaurant;
import com.ogustavodias.lunch.models.Vote;
import com.ogustavodias.lunch.services.ParticipantService;
import com.ogustavodias.lunch.services.RestaurantService;
import com.ogustavodias.lunch.services.VoteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("votes")
public class VoteController {

   private final VoteService voteService;
   private final RestaurantService restaurantService;
   private final ParticipantService participantService;

   @GetMapping("/{id}")
   public Vote searchVote(@PathVariable Long id) {
      return voteService.searchVote(id);
   }

   @PostMapping
   public void registerVote(@RequestBody Vote request) {
/*       Restaurant restaurant = restaurantService.findRestaurant(null);
      Participant participant = participantService.findParticipant(null);
      LocalDate voteDate = LocalDate.now();
      Vote vote = Vote.builder().restaurant(restaurant).participant(participant).voteDate(voteDate).build(); */
      voteService.registerVote(request);
   }

}

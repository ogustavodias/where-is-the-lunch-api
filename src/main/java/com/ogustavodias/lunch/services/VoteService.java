package com.ogustavodias.lunch.services;

import org.springframework.stereotype.Service;

import com.ogustavodias.lunch.dtos.VoteRequestDto;
import com.ogustavodias.lunch.errors.EntityNotFoundException;
import com.ogustavodias.lunch.models.Participant;
import com.ogustavodias.lunch.models.Restaurant;
import com.ogustavodias.lunch.models.Survey;
import com.ogustavodias.lunch.models.Vote;
import com.ogustavodias.lunch.repositories.ParticipantRepository;
import com.ogustavodias.lunch.repositories.RestaurantRepository;
import com.ogustavodias.lunch.repositories.SurveyRepository;
import com.ogustavodias.lunch.repositories.VoteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VoteService {

   private final VoteRepository voteRepository;
   private final SurveyRepository surveyRepository;
   private final ParticipantRepository participantRepository;
   private final RestaurantRepository restaurantRepository;

   public void registerVote(VoteRequestDto request) {
      Survey survey = surveyRepository.findById(request.surveyId())
            .orElseThrow(() -> new EntityNotFoundException("Survey not found"));
      Participant participant = participantRepository.findById(request.participantId())
            .orElseThrow(() -> new EntityNotFoundException("Participant not found"));
      Restaurant restaurant = restaurantRepository.findById(request.restaurantId())
            .orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));

      Vote vote = Vote.builder().survey(survey).participant(participant).restaurant(restaurant).build();
      voteRepository.save(vote);
   }

}

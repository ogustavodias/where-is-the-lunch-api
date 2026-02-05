package com.ogustavodias.lunch.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ogustavodias.lunch.models.Restaurant;
import com.ogustavodias.lunch.models.Vote;

public class SurveyResultService {

      public static Optional<Restaurant> calculateWinner(List<Vote> votes) {
            return votes.isEmpty() ? Optional.empty()
                        : votes.stream()
                                    .collect(Collectors.groupingBy(
                                                Vote::getRestaurant,
                                                Collectors.counting()))
                                    .entrySet()
                                    .stream()
                                    .max(Map.Entry.comparingByValue())
                                    .map(Map.Entry::getKey);
      }

}

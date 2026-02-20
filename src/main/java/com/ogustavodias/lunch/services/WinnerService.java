package com.ogustavodias.lunch.services;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ogustavodias.lunch.models.Restaurant;
import com.ogustavodias.lunch.models.Vote;
import com.ogustavodias.lunch.repositories.WinnerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class WinnerService {

      private final WinnerRepository repository;

      public Optional<Restaurant> calculateWinner(List<Vote> votes) {
            return votes.stream()
                        .collect(Collectors.groupingBy(Vote::getRestaurant))
                        .entrySet()
                        .stream()
                        .map(entry -> {
                              Restaurant restaurant = entry.getKey();
                              List<Vote> restaurantVotes = entry.getValue();

                              int totalVotes = restaurantVotes.size();
                              Instant firstVoteTime = restaurantVotes.stream()
                                          .map(Vote::getCreatedAt)
                                          .min(Instant::compareTo)
                                          .orElseThrow();

                              return new WinnerCandidate(restaurant, firstVoteTime, totalVotes);
                        })
                        .max(Comparator
                                    .comparingLong(WinnerCandidate::totalVotes)
                                    .thenComparing(WinnerCandidate::firstVoteTime, Comparator.reverseOrder()))
                        .map(WinnerCandidate::restaurant);
      }

      public boolean alreadyWonThisWeek(Restaurant restaurant, LocalDate today) {
            LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
            LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
            return repository.existsByWinnerAndDateBetween(restaurant, startOfWeek, endOfWeek);
      }

      private record WinnerCandidate(Restaurant restaurant, Instant firstVoteTime, int totalVotes) {
      }

}

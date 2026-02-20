package com.ogustavodias.lunch.data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ogustavodias.lunch.models.Participant;
import com.ogustavodias.lunch.models.Restaurant;
import com.ogustavodias.lunch.models.Winner;
import com.ogustavodias.lunch.repositories.ParticipantRepository;
import com.ogustavodias.lunch.repositories.RestaurantRepository;
import com.ogustavodias.lunch.repositories.WinnerRepository;

@Configuration
@Profile("dev")
public class DataInitializer {

      @Bean
      CommandLineRunner loadData(
                  ParticipantRepository participantRepository,
                  RestaurantRepository restaurantRepository,
                  WinnerRepository winnerRepository) {
            return args -> {
                  participantRepository.saveAll(List.of(
                              Participant.builder().name("Gustavo").build(),
                              Participant.builder().name("Kawan").build(),
                              Participant.builder().name("Daniel").build()));

                  restaurantRepository.saveAll(List.of(
                              Restaurant.builder().name("Dom Carmel").build(),
                              Restaurant.builder().name("Coco Bambu").build(),
                              Restaurant.builder().name("Carlinhos").build()));

                  winnerRepository.saveAll(List.of(
                              Winner.builder()
                                          .winner(restaurantRepository.findById(1L).orElse(null))
                                          .date(LocalDate.now()
                                                      .with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY)))
                                          .build()));

            };
      }

}

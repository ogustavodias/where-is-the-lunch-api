package com.ogustavodias.lunch.data;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ogustavodias.lunch.models.Participant;
import com.ogustavodias.lunch.models.Restaurant;
import com.ogustavodias.lunch.repositories.ParticipantRepository;
import com.ogustavodias.lunch.repositories.RestaurantRepository;

@Configuration
@Profile("dev")
public class DataInitializer {

      @Bean
      CommandLineRunner loadData(
                  ParticipantRepository participantRepository,
                  RestaurantRepository restaurantRepository) {
            return args -> {
                  participantRepository.saveAll(List.of(
                              Participant.builder().name("Gustavo").build(),
                              Participant.builder().name("Kawan").build(),
                              Participant.builder().name("Daniel").build()));

                  restaurantRepository.saveAll(List.of(
                              Restaurant.builder().name("Dom Carmel").build(),
                              Restaurant.builder().name("Coco Bambu").build(),
                              Restaurant.builder().name("Carlinhos").build()));
            };
      }

}

package com.ogustavodias.lunch.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ogustavodias.lunch.models.Participant;
import com.ogustavodias.lunch.models.Restaurant;
import com.ogustavodias.lunch.models.Survey;
import com.ogustavodias.lunch.repositories.ParticipantRepository;
import com.ogustavodias.lunch.repositories.RestaurantRepository;
import com.ogustavodias.lunch.repositories.SurveyRepository;

@Configuration
public class DataInitializer {

   @Bean
   CommandLineRunner loadData(
         ParticipantRepository participantRepository,
         RestaurantRepository restaurantRepository,
         SurveyRepository surveyRepository) {
      return args -> {
         Survey survey = surveyRepository.save(
               new Survey());

         Participant p1 = participantRepository.save(
               Participant.builder().name("Gustavo").build());

         Participant p2 = participantRepository.save(
               Participant.builder().name("Kawan").build());

         Participant p3 = participantRepository.save(
               Participant.builder().name("Daniel").build());

         Restaurant r1 = restaurantRepository.save(
               Restaurant.builder().name("Dom Carmel").build());

         Restaurant r2 = restaurantRepository.save(
               Restaurant.builder().name("Coco Bambu").build());

         Restaurant r3 = restaurantRepository.save(
               Restaurant.builder().name("Carlinhos").build());

      };
   }

}

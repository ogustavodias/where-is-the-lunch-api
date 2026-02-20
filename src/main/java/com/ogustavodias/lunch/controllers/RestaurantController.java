package com.ogustavodias.lunch.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ogustavodias.lunch.models.Restaurant;
import com.ogustavodias.lunch.services.RestaurantService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("restaurants")
public class RestaurantController {

   private final RestaurantService service;

   @GetMapping("/{id}")
   public Restaurant searchRestaurant(@PathVariable Long id) {
      return service.findRestaurant(id);
   }

}

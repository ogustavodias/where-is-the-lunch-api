package com.ogustavodias.lunch.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ogustavodias.lunch.services.VoteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/votes")
public class VoteController {

   private final VoteService service;

}

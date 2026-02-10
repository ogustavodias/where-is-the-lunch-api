package com.ogustavodias.lunch.services;

import org.springframework.stereotype.Service;

import com.ogustavodias.lunch.repositories.VoteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VoteService {

      private final VoteRepository voteRepository;
      
}

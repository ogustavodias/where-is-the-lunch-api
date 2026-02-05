package com.ogustavodias.lunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogustavodias.lunch.models.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}

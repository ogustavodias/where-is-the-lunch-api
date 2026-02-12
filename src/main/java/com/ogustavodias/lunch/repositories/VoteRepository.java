package com.ogustavodias.lunch.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogustavodias.lunch.models.Participant;
import com.ogustavodias.lunch.models.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

   boolean existsByParticipantAndVoteDate(Participant participant, LocalDate voteDate);

}

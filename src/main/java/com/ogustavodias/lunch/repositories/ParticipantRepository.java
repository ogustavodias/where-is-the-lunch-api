package com.ogustavodias.lunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogustavodias.lunch.models.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}

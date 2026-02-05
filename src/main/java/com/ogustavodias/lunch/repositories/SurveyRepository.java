package com.ogustavodias.lunch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ogustavodias.lunch.models.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}

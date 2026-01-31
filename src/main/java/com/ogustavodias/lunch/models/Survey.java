package com.ogustavodias.lunch.models;

import java.util.List;

import com.ogustavodias.lunch.enums.SurveyStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_surveys")
public class Survey {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;

   @Enumerated(EnumType.STRING)
   @Column(nullable = false)
   private SurveyStatus status = SurveyStatus.OPEN;

   @OneToMany(mappedBy = "survey")
   private List<Vote> votes;
}

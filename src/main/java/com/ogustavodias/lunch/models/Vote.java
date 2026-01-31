package com.ogustavodias.lunch.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_votes", uniqueConstraints = { @UniqueConstraint(columnNames = { "survey_id", "participant_id" }) })
public class Vote {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;

   @ManyToOne(optional = false)
   @JoinColumn(name = "survey_id")
   private Survey survey;

   @ManyToOne(optional = false)
   @JoinColumn(name = "participant_id")
   private Participant participant;

   @ManyToOne(optional = false)
   @JoinColumn(name = "restaurant_id")
   private Restaurant restaurant;
}

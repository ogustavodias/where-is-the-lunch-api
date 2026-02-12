package com.ogustavodias.lunch.models;

import java.time.Instant;
import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "tb_votes", uniqueConstraints = { @UniqueConstraint(columnNames = { "participant_id", "vote_date" }) })
public class Vote {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;

   @ManyToOne(optional = false)
   @JoinColumn(name = "participant_id")
   private Participant participant;

   @ManyToOne(optional = false)
   @JoinColumn(name = "restaurant_id")
   private Restaurant restaurant;

   @CreatedDate
   @Column(nullable = false, updatable = false)
   private Instant createdAt;

   @CreatedDate
   @Column(nullable = false, updatable = false)
   private LocalDate voteDate;
}

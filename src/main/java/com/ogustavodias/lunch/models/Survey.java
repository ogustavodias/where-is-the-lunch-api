package com.ogustavodias.lunch.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ogustavodias.lunch.enums.SurveyStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
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

   @ManyToOne
   @JoinColumn(name = "winner_id", nullable = true)
   private Restaurant winner;

   @CreatedDate
   @Column(nullable = false, updatable = false)
   private Instant createdAt;

   @Column(nullable = false, updatable = false)
   private Instant expiresAt;

   @PrePersist
   public void calcExpiresAt() {
      LocalDateTime createdDateTime = LocalDateTime.ofInstant(createdAt, ZoneOffset.UTC);
      LocalDateTime midday = createdDateTime.toLocalDate().atTime(12, 0);
      LocalDateTime expirationDateTime = createdDateTime.isBefore(midday) ? midday : midday.plusDays(1);

      this.expiresAt = expirationDateTime.toInstant(ZoneOffset.UTC);
   }

   public void closeWithWinner(Restaurant winner) {
      this.winner = winner;
      this.status = SurveyStatus.CLOSED;
   }

}

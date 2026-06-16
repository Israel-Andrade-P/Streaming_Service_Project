package com.zeldev.streaming_service.model;

import com.zeldev.streaming_service.enumeration.AccountType;
import com.zeldev.streaming_service.enumeration.AgeRestriction;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    private Integer durationMins;
    private Integer releaseYear;
    @Enumerated(EnumType.STRING)
    private AgeRestriction ageRestriction;
    @Enumerated(EnumType.STRING)
    private AccountType requiredAccountType;
    @Column(name = "description", nullable = false)
    private String description;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;
}

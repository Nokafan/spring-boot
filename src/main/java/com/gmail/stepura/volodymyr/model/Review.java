package com.gmail.stepura.volodymyr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "review_id")
    private Long reviewId;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "helpfulnessNumerator")
    private Long helpfulnessNumerator;

    @Column(name = "helpfulnessDenominator")
    private Long helpfulnessDenominator;

    @Column(name = "score")
    private Long score;

    @Column(name = "time")
    private Long time;

    @Column(name = "summary")
    private String summary;

    @Lob
    @Column(name = "text")
    private String text;
}

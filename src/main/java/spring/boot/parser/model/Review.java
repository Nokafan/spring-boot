package spring.boot.parser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "helpfulness_numerator")
    private Long helpfulnessNumerator;

    @Column(name = "helpfulness_denominator")
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

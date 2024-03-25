package com.project.colochub.Models.Entities.App;

import com.project.colochub.Models.Entities.Users.Searcher;
import com.project.colochub.Models.Enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    @Id
    private Integer id;
    @NotEmpty
    private PaymentStatus paymentStatus;
    private Date start_date;
    private Date end_date;

    //RelationShips
    @ManyToOne
    private Searcher searcher;
    @ManyToOne
    private Offer offer;
}

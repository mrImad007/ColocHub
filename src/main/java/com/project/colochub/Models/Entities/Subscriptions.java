package com.project.colochub.Models.Entities;

import com.project.colochub.Models.Enums.PaymentStatus;
import com.project.colochub.Security.Model.Entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private Date start_date;
    private Date end_date;

    //RelationShips
    @ManyToOne
    private User searcher;
    @ManyToOne
    private Offer offer;

    @Override
    public String toString() {
        return "Subscriptions{" +
                "id=" + id +
                ", paymentStatus=" + paymentStatus +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}

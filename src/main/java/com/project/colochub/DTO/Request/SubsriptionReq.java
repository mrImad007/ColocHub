package com.project.colochub.DTO.Request;

import com.project.colochub.Models.Entities.Offer;
import com.project.colochub.Models.Entities.Subscriptions;
import com.project.colochub.Models.Enums.PaymentStatus;
import com.project.colochub.Security.Model.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubsriptionReq {
    private Integer id;
    private PaymentStatus paymentStatus;
    private Date start_date;
    private Date end_date;
    private Integer searcher_id;
    private Integer offer_id;

    public Subscriptions toModel() {
        User searcher = User.builder().id(this.searcher_id).build();
        Offer offer = Offer.builder().id(this.offer_id).build();
        return Subscriptions.builder()
                .id(this.id)
                .paymentStatus(this.paymentStatus)
                .start_date(this.start_date)
                .end_date(this.end_date)
                .searcher(searcher)
                .offer(offer)
                .build();
    }
}

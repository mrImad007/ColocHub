package com.project.colochub.DTO.Response;

import com.project.colochub.Models.Enums.PaymentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionDto {
    private Integer id;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private Date start_date;
    private Date end_date;
    private UserDto searcher;
}

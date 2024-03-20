package com.project.colochub.Models.Entities.App;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;
    @NotEmpty
    private Double monthly_price;
}

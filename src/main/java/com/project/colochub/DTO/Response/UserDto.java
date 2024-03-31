package com.project.colochub.DTO.Response;

import com.project.colochub.Security.Model.Enums.Role;
import com.project.colochub.Security.Model.Enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Phone is mandatory")
    private String phone;
    @NotBlank(message = "Adress is mandatory")
    private String address;
    private Date membership_date;
    @Enumerated(EnumType.STRING)
    private Role role;
}

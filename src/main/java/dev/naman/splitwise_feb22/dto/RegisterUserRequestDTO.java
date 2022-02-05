package dev.naman.splitwise_feb22.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDTO {
    private String name;
    private String phoneNumber;
    private String password;
}

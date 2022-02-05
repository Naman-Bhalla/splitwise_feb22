package dev.naman.splitwise_feb22.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class UpdateProfileRequestDto {
    private Long userId;
    private String newPassword;
}

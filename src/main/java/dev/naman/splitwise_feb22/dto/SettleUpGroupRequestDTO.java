package dev.naman.splitwise_feb22.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettleUpGroupRequestDTO {
    private Long userId;
    private Long groupId;
}

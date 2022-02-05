package dev.naman.splitwise_feb22.controllers;

import dev.naman.splitwise_feb22.dto.*;
import dev.naman.splitwise_feb22.models.User;
import dev.naman.splitwise_feb22.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public ResponseDTO<RegisterUserResponseDTO>
    registerUser(RegisterUserRequestDTO request) {
        User user = userService.registerUser(
                request.getName(),
                request.getPhoneNumber(),
                request.getPassword()
        );

        ResponseDTO<RegisterUserResponseDTO> response = new ResponseDTO<>();

        if (user == null) {
            response.setStatusCode(ResponseStatusCode.FAILURE);
            return response;
        }

        response.setStatusCode(ResponseStatusCode.SUCCESS);
        RegisterUserResponseDTO responseDTO = new RegisterUserResponseDTO();
        responseDTO.setUserId(user.getId());
        response.setData(responseDTO);
        return response;
    }

    public ResponseDTO<UpdateProfileResponseDto> updateProfile(
            UpdateProfileRequestDto requestDto
    ) {
        userService.updatePassword(requestDto.getUserId(),
                requestDto.getNewPassword());
        ResponseDTO<UpdateProfileResponseDto> res = new ResponseDTO<>();
        res.setStatusCode(ResponseStatusCode.SUCCESS);
        return res;
    }

}


// controller
// take request
// unmarshall parameters
// send those to a relevant service
// get response from the service
// construct appropriate response object
// secde
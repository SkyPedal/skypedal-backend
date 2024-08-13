package com.skypedal.skypedal_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "reward not available to redeem")
public class RewardNotAvailableException extends RuntimeException{
}

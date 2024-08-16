package com.skypedal.skypedal_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED, reason = "You do not have enough points to redeem this reward")
public class UserIsTooPoorException extends RuntimeException{
}

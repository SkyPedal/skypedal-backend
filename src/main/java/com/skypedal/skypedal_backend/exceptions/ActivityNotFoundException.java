package com.skypedal.skypedal_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "no activity found with that data")
public class ActivityNotFoundException extends RuntimeException {
}

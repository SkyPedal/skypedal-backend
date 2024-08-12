package com.skypedal.skypedal_backend.utils;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AuthenticationRequest {

    @NotNull
    @Size(max = 255)
    private String login;

    @NotNull
    @Size(max = 255)
    private String password;

    public @NotNull @Size(max = 255) String getLogin() {
        return login;
    }

    public void setLogin(@NotNull @Size(max = 255) String login) {
        this.login = login;
    }

    public @NotNull @Size(max = 255) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(max = 255) String password) {
        this.password = password;
    }
}

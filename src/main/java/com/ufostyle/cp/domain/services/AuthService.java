package com.ufostyle.cp.domain.services;

import com.ufostyle.cp.infrastructure.controllers.models.AuthResponse;
import com.ufostyle.cp.infrastructure.controllers.models.AuthenticationRequest;
import com.ufostyle.cp.infrastructure.controllers.models.RegisterRequest;

public interface AuthService {

    AuthResponse register (RegisterRequest registerRequest);

    AuthResponse authenticate (AuthenticationRequest authenticationRequest);
}

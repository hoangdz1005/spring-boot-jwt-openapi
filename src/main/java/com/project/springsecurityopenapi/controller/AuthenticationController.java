package com.project.springsecurityopenapi.controller;
import com.project.springsecurityopenapi.enums.Role;
import com.project.springsecurityopenapi.model.AuthenticationRequest;
import com.project.springsecurityopenapi.model.RegisterRequest;
import com.project.springsecurityopenapi.model.StandardResponse;
import com.project.springsecurityopenapi.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @Operation(summary = "User register", description = "Register to use api service", tags={ "auth" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Register successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponse.class), examples = @ExampleObject(value = "{\"code\":\"200\",\"message\":\"Done\",\"data\":{\"id\":1,\"firstname\":\"James\",\"lastname\":\"Bone\",\"email\":\"nnh10052002@gmail.com\",\"address\":\"Chicago, US\",\"mobileNumber\":\"0123456789\",\"role\":\"USER\"}}"))),
    })
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<StandardResponse> register(@io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = @ExampleObject(value = "{\n  \"firstname\": \"James\",\n  \"lastname\": \"Bone\",\n  \"email\": \"nnh10052002@gmail.com\",\n  \"password\": \"123456\",\n  \"address\": \"Chicago, US\",\n  \"mobileNumber\": \"0123456789\",\n  \"role\": \"USER\" }")), required = true)  @Valid @RequestBody RegisterRequest request) {
        return new ResponseEntity<>(new StandardResponse("200", "Done", service.register(request)), HttpStatus.OK);
    }

    @Operation(summary = "Authenticate user", description = "Authenticate user login", tags={ "auth" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authenticate successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponse.class), examples = @ExampleObject(value = "{\"code\":\"200\",\"message\":\"Done\",\"data\":{\"access_token\":\"eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiVVNFUiIsInN1YiI6ImphbWVzdXMxOTk4QGdtYWlsLmNvbSIsImlhdCI6MTcwMjI3MTU3MCwiZXhwIjoxNzAyMzU3OTcwfQ.ROfOXjmIifjUQiRuoOe6gld7QADEnU7WO75BCK6ycFA\",\"refresh_token\":\"eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiVVNFUiIsInN1YiI6ImphbWVzdXMxOTk4QGdtYWlsLmNvbSIsImlhdCI6MTcwMjI3MTU3MCwiZXhwIjoxNzAyODc2MzcwfQ._eJuIWoRlxkGWvawaIFU1MgoF91dgrF57R2Sw7zD9ao\"}}"))),
    })
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<StandardResponse> authenticate(@io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(examples = @ExampleObject(value = "{\n  \"email\": \"nnh10052002@gmail.com\",\n  \"password\": \"12345678\"}")), required = true) @RequestBody AuthenticationRequest request) {
        return new ResponseEntity<>(new StandardResponse("200", "Done", service.authenticate(request)), HttpStatus.OK);
    }

    @Operation(summary = "Refresh token", description = "Refresh token to have access token", tags={ "auth" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponse.class), examples = @ExampleObject(value = "{\"code\":\"200\",\"message\":\"Done\",\"data\":{\"access_token\":\"eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiVVNFUiIsInN1YiI6ImphbWVzdXMxOTk4QGdtYWlsLmNvbSIsImlhdCI6MTcwMjI3MTU3MCwiZXhwIjoxNzAyMzU3OTcwfQ.ROfOXjmIifjUQiRuoOe6gld7QADEnU7WO75BCK6ycFA\"}}"))),
    })
    @RequestMapping(value = "/refresh-token", method = RequestMethod.POST)
    public ResponseEntity<StandardResponse> refreshToken(HttpServletRequest request) throws IOException {
        return new ResponseEntity<>(new StandardResponse("200", "Done", service.refreshToken(request)), HttpStatus.OK);
    }

}

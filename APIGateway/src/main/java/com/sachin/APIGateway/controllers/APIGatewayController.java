package com.sachin.APIGateway.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class APIGatewayController
{
    @GetMapping("/check")
    public String status()
    {
        return "API Gateway Working.";
    }
}

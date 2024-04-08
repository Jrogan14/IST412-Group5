package com.auth0.example;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main {
    public static void main(String[] args) throws IOException, 
    URISyntaxException, ServletException
    {

        String signInUrl = "http://localhost:3000/portal/home";
        String registerAccountUrl = "http://localhost:3000/portal/register"; 

        try {
            // Creates the instances for HttpServletRequest and HttpServletResponse
            HttpServletRequest request = (HttpServletRequest) new Object();
            HttpServletResponse response = (HttpServletResponse) new Object();
            FilterChain chain = (FilterChain) new Object();
            // Creates the instances of Auth0Filter and calls the filterRequest method
            Auth0Filter auth0Filter = new Auth0Filter();
            auth0Filter.doFilter(request, response, chain);
            // Open the register account page
            Desktop.getDesktop().browse(new URI(registerAccountUrl));
            // Open the sign-in page in the default browser
            Desktop.getDesktop().browse(new URI(signInUrl));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
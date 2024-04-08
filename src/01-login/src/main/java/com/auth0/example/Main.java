package com.auth0.example;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {

        String signInUrl = "http://localhost:3000/portal/home"; 

        try {
            // Open the sign-in page in the default browser
            Desktop.getDesktop().browse(new URI(signInUrl));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
package com.mycompany.dvdstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class AboutUsController {

    @RequestMapping("/about-us")
    public String displayFullDetails(){

        System.out.println("Tentative d'affichage de l'a-propos");

        return "";
    }
}

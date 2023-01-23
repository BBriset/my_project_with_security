package com.wildcodeschool.my_project_with_security.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShieldController {

  @GetMapping("/")
  public String hello() {
    return "Welcome to the SHIELD";
  }

  @GetMapping("/avengers/assemble")
  public String champion() {
    return "Avengers... Assemble";
  }

  @GetMapping("/secret-bases")
  public static ArrayList secretBases() {

    List<String> secretBases = new ArrayList<String>();

    secretBases.add("Biarritz");
    secretBases.add("Bordeaux");
    secretBases.add("La Loupe");
    secretBases.add("Lille");
    secretBases.add("Lyon");
    secretBases.add("Nantes");
    secretBases.add("Orléans");
    secretBases.add("Paris");
    secretBases.add("Reims");
    secretBases.add("Strasbourg");
    secretBases.add("Toulouse");

    return (ArrayList) secretBases;

  }
}
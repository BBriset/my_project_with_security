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
  public static String secretBases() {

    List<String> secretBases = new ArrayList<String>();

    Vector<String> base = new Vector<String>();
    base.add("Biarritz");
    base.add("Bordeaux");
    base.add("La Loupe");
    base.add("Lille");
    base.add("Lyon");
    base.add("Nantes");
    base.add("Orléans");
    base.add("Paris");
    base.add("Reims");
    base.add("Strasbourg");
    base.add("Toulouse");
    Enumeration<String> e = base.elements();
    secretBases = Collections.list(e);
    return "Returned list: " + secretBases;

  }
}
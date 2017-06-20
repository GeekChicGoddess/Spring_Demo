package com.codeup.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

import static java.lang.Math.random;

@Controller
public class RollDiceController {


    @GetMapping("/roll-dice")
    public String displayGuess(Model model){
        model.addAttribute("diceSides", new String[]{"1","2","3","4","5","6"});
        return "roll-dice";
    }


    @RequestMapping(value = "/roll-dice/{side}")
    public String displayGuess1(Model model,@PathVariable("side") String side){
        model.addAttribute("side", side);
        int sideInt = Integer.valueOf(side);
        Random rand = new Random();
        int roll = rand.nextInt(6)+1;
        model.addAttribute("roll", roll);
        if (roll == sideInt){
            model.addAttribute("match", true);
        }
        else {
            model.addAttribute("match", false);
        }
        return "roll-dice";
    }


}

package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by melodytempleton on 6/19/17.
 */
@Controller

public class MathController {

    @RequestMapping(path = "/add/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int add2number(@PathVariable int x, @PathVariable int y) {
        return x+y ;
    }

    @RequestMapping(path = "/subtract/{x}/from/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int subtract2Numbrs(@PathVariable int x, @PathVariable int y) {
        return y-x ;
    }

      @RequestMapping(path = "/multiply/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int multiply4and5(@PathVariable int x, @PathVariable int y) {
        return x*y ;
    }

         @RequestMapping(path = "/divide/{x}/by/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int divide6by3(@PathVariable int x, @PathVariable int y) {
        return x/y ;
    }


    public static void main(String[] args) {

    }
}

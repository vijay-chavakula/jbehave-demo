package com.calculator.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CalculatorController {

    @RequestMapping(value = "/calculate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDataFeed(@RequestParam(value = "principle", required = false) Float principle,
                              @RequestParam(value = "years", required = false) Float years,
                              @RequestParam(value = "roi", required = false) Float rateOfInterest,HttpServletRequest request,
                              HttpServletResponse response) {
        double simpleInterest = 0.0;
        try {
            if(principle != null && years !=null && rateOfInterest != null) {
                simpleInterest = (principle * years * rateOfInterest) / 100;
            }
        } catch (Exception e) {
            response.setStatus(500);
            logAndReturnErrorMessage(response, e, "Exception while invoking calculate api. error message:");
        }
        return String.valueOf(simpleInterest);
    }

    private void logAndReturnErrorMessage(HttpServletResponse response, Exception e, String message) {
        response.setContentType("text/plain");
        try {
            response.getWriter().write(message + e.getMessage());
        } catch (Exception ignore) {
            //ignore
        }
        //logger.error(message, e);
    }
}

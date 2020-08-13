package com.mlondi.tempertureconversion.Controllers;

import com.mlondi.tempertureconversion.Models.OutputMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MilesKilometers {
    @RequestMapping(value = "/conversion/mtok", method = RequestMethod.GET)
    @ResponseBody
    public String homePage(HttpServletRequest request){

        Double input = Double.parseDouble(request.getParameter("input"));
        String output =null;
            if (input == null) {
                output = "Enter an input on your endpoint";
            } else {
                output = OutputMessage.getKilometers(input);
            }

        return "<h1>"+output+"</h1>" ;
    }
}

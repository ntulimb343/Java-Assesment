package com.mlondi.tempertureconversion.Controllers;

import com.mlondi.tempertureconversion.Models.OutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CelsiusKelvin {
    @RequestMapping(value = "/conversion/ctok", method = RequestMethod.GET)
    @ResponseBody
    public String homePage(HttpServletRequest request, Model model){

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

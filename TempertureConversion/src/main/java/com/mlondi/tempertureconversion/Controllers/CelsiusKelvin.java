package com.mlondi.tempertureconversion.Controllers;

import com.mlondi.tempertureconversion.Models.OutputMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CelsiusKelvin {
    @RequestMapping(value = "/conversion/ctok", method = RequestMethod.GET)
    @ResponseBody
    public String homePage(HttpServletRequest request, Model model){

        Double input = Double.parseDouble(request.getParameter("input"));
        String output =null;
            if (input == null || input.equals("")) {
                return "Enter an input on your endpoint";
            } else {
                model.addAttribute("input",OutputMessage.getKelvin(input));
                return "Display" ;
            }
    }
}

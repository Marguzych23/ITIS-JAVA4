package ru.kpfu.springcontrollers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.springcontrollers.models.CalculateModel;
import ru.kpfu.springcontrollers.services.interfaces.CalculateService;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    private CalculateService calculateService;

    @Autowired
    public CalculatorController(@Qualifier("calculateServiceImplementation") CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        CalculateModel calculateModel = new CalculateModel();
        model.addAttribute("calculateModel", calculateModel);
        return "calculator";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String calculate(
            @ModelAttribute("calculateModel") CalculateModel calculateModel,
            ModelMap map) {

        double result = calculateService.calculate(calculateModel);
        map.put("result", result);

        return "calculator";
    }
}

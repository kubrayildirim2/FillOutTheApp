package be.intecbrussel.zoo.controllers.interfaces;

import be.intecbrussel.zoo.data.Country;
import be.intecbrussel.zoo.services.interfaces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CountryControllerImpl implements CountryController {

    private CountryService countryService;

    @Autowired
    public CountryControllerImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    @GetMapping("/countries")
    public String showAllCountries(Model model) {


        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("newcountry", new Country());
        return "countries";
    }

    @Override
    public String createCountry(Country country) {
        return null;
    }

    @Override
    @PostMapping("/addCountry")
    public String createCountry(@ModelAttribute Country country, Model model) {

        countryService.createCountry(country);
        return "redirect:/countries";
    }
}
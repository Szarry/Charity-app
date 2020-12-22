package pl.coderslab.charity.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Donation.DonationRepository;
import pl.coderslab.charity.Institution.Institution;
import pl.coderslab.charity.Institution.InstitutionRepository;
import pl.coderslab.charity.User.AppUser;
import pl.coderslab.charity.User.UserService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final UserService userService;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository
            , UserService userService
    ) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.userService = userService;
    }

    @ModelAttribute("institutionList")
    public List<Institution> getInstitutionsList() {
        List<Institution> inst = new ArrayList<>();
        inst.addAll(institutionRepository.getRandomInstitutionList());
        return inst;
    }

    @ModelAttribute("donationsSum")
    public Integer getTotalDonation() {
        Integer donations = donationRepository.countId();
        return donations;
    }

    @ModelAttribute("donationsBagsQty")
    public Integer getDonationBags() {
        Integer donationsBags = donationRepository.sumQuantity();
        return donationsBags;
    }


    @GetMapping("")
    public String homeAction() {

        return "index";
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("AppUser", new AppUser());
        return "/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("AppUser") @Valid AppUser appUser, BindingResult result, Model model,
                               @RequestParam String password2) {

        if (result.hasErrors()) {
            System.out.println("BŁEDY" + result);
            System.out.println(appUser);
            return "/register";
        }
        AppUser userByEmail = userService.findByEmail(appUser.getEmail());

        if (userByEmail == null) {
            if (appUser.getPassword().equals(password2)) {
                userService.saveUser(appUser);
                return "redirect:/login";
            } else {
                String error = "hasła nie są takie same!";
                model.addAttribute("messagePass", error);
                return "/register";
            }
        } else {
            String error = "e-mail zajęty!";
            model.addAttribute("messageEmail", error);
            return "/register";
        }
    }


}


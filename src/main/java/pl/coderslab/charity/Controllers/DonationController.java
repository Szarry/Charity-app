package pl.coderslab.charity.Controllers;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.Category.CategoryRepository;
import pl.coderslab.charity.Donation.Donation;
import pl.coderslab.charity.Donation.DonationRepository;
import pl.coderslab.charity.Institution.InstitutionRepository;
import pl.coderslab.charity.User.AppUser;
import pl.coderslab.charity.User.CurrentUser;


@Controller
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }


    @GetMapping("/user/form")
    public String showForm(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("donation", new Donation());
        return "/user/form";
    }


    @PostMapping("/user/form")
    public String saveDonationForm(Donation donation, BindingResult result,
                                   @AuthenticationPrincipal CurrentUser customUser) {
        if (result.hasErrors()) {
            System.out.println(result);
            return "/user/form";
        } else {
            AppUser entityUser = customUser.getAppUser();
            donation.setUser(entityUser);
            donationRepository.save(donation);
            return "redirect:/user/confirmation";
        }
    }


    @GetMapping("/user/confirmation")
    public String showConfirmationForm() {
        return "/user/confirmationForm";
    }


}

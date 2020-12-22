package pl.coderslab.charity.Controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Institution.Institution;
import pl.coderslab.charity.Institution.InstitutionRepository;
import pl.coderslab.charity.User.AppUser;
import pl.coderslab.charity.User.CurrentUser;
import pl.coderslab.charity.User.UserRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final InstitutionRepository institutionRepository;
    private final UserRepository userRepository;

    public AdminController(InstitutionRepository institutionRepository, UserRepository userRepository) {
        this.institutionRepository = institutionRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public String showAdminIndex(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        AppUser user = customUser.getAppUser();
        model.addAttribute("userName", user.getFirstname());
        return "/admin/adminIndex";
    }

    @GetMapping("/institutionList")
    public String showInstitutionList(Model model) {
        model.addAttribute("institutionList", institutionRepository.findAll());

        return "admin/institutionList";
    }

    @GetMapping("/institutionEdit/{id}")
    public String showInstitutionEditForm(@PathVariable long id, Model model) {
        Institution institutionById = institutionRepository.findById(id);
        model.addAttribute("institution", institutionById);
        return "/admin/institutionEdit";
    }

    @PostMapping("/institutionEdit/{id}")
    public String performEditInstitution(@Valid Institution institution, BindingResult result, @PathVariable long id) {

        if (result.hasErrors()) {
            return "admin/institutionEdit";
        } else {
            institution.setId(id);
            institutionRepository.save(institution);
        }
        return "redirect:/admin/institutionList";
    }

    @GetMapping("/institutionDelete/{id}")
    public String performInstitutionDelete(@PathVariable int id) {

        Institution institution = institutionRepository.findById(id);
        institutionRepository.delete(institution);

        return "redirect:/admin/institutionList";
    }

    @GetMapping("/institutionAdd")
    public String showInstitutionAddForm(Model model) {
        model.addAttribute("institution", new Institution());
        return "admin/institutionAdd";
    }

    @PostMapping("/institutionAdd")
    public String performInstitutionAdd(@Valid Institution institution, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/institutionAdd";
        } else {
            institutionRepository.save(institution);
        }
        return "redirect:/admin/institutionList";
    }

    @GetMapping("/adminList")
    public String showUserList(Model model) {

        model.addAttribute("admins", userRepository.findAllByRolesIdIn(Collections.singletonList(2)));
        return "admin/adminList";
    }

}

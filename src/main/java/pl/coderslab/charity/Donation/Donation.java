package pl.coderslab.charity.Donation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.Category.Category;
import pl.coderslab.charity.Institution.Institution;
import pl.coderslab.charity.User.AppUser;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private String city;
    private String street;
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Category> categories;

    @ManyToOne(cascade = CascadeType.ALL)
    private Institution institution;

    @ManyToOne
    private AppUser user;

    public Donation(int quantity, String city, String street, String zipCode, LocalDate pickUpDate, LocalTime pickUpTime,
                    String pickUpComment, String phoneNumber, List<Category> categories, Institution institution, AppUser user) {
        this.quantity = quantity;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
        this.phoneNumber = phoneNumber;
        this.categories = categories;
        this.institution = institution;
        this.user = user;
    }
}

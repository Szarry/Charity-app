package pl.coderslab.charity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByEmail(String email);

    AppUser findByUsername(String username);

    AppUser findByEmailAndPassword(String email, String password);


//    @Query (value = "SELECT app_user_id FROM `charity-donation`.user_roles WHERE roles_id = 1", nativeQuery = true)
//    List <Long> findAllByRole ();

    List<AppUser> findAllByRolesIdIn(Collection<Integer> id);

}

package sk.bavaria.bavaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sk.bavaria.bavaria.model.User;
import sk.bavaria.bavaria.repository.UserRepository;

import javax.annotation.PostConstruct;

/**
 * Created by martin.cuchran on 12/14/2017.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        User u = new User();
        u.setUsername("Admin");
        u.setPassword(passwordEncoder.encode("admin"));

        User u1 = new User();
        u1.setUsername("Admin1");
        u1.setPassword(passwordEncoder.encode("admin1"));

        userRepository.save(u);
        userRepository.save(u1);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final User byUsername = userRepository.findByUsername(s);
        if (byUsername == null) {
            throw new UsernameNotFoundException("User not found for username:" + s);
        }
        return byUsername;


    }
}

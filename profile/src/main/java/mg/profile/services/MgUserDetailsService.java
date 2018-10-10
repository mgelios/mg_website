package mg.profile.services;

import mg.profile.dbentities.UserDBEntity;
import mg.profile.models.LocalUser;
import mg.profile.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MgUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDBEntity> user = userRepository.findByUsername(username);
        if (!user.isPresent()){
            throw new UsernameNotFoundException(username);
        }
        return new LocalUser();
    }

}


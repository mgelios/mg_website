package mg.profile.service;

import lombok.AllArgsConstructor;
import mg.profile.converter.UserEntityToDto;
import mg.profile.entity.User;
import mg.profile.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BasicUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserEntityToDto userEntityToDTO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()){
            throw new UsernameNotFoundException(username);
        }
        return userEntityToDTO.convert(user.get());
    }
}


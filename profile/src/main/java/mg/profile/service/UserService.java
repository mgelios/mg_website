package mg.profile.service;

import lombok.AllArgsConstructor;
import mg.profile.converter.UserDtoToEntity;
import mg.profile.converter.UserEntityToDto;
import mg.profile.entity.User;
import mg.profile.dto.LocalUserDto;
import mg.profile.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserEntityToDto userEntityToDTO;
    private final UserDtoToEntity userDTOToEntity;

    public List<LocalUserDto> getUsersList() {
        List<LocalUserDto> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            users.add(userEntityToDTO.convert(user));
        });
        return users;
    }

    public LocalUserDto findUserByEmail(String email) {
        Optional<User> dbUser = userRepository.findByEmail(email);
        return dbUser.map(userEntityToDTO::convert).orElse(null);
    }

    public void saveUser(LocalUserDto user) {
        User dbUser = userDTOToEntity.convert(user);
        userRepository.save(dbUser);
    }

    public LocalUserDto mergeUpdatedUser(LocalUserDto userUpdated, LocalUserDto oldUser){
        oldUser.setEmail(userUpdated.getEmail());
        oldUser.setFirstName(userUpdated.getFirstName());
        oldUser.setLastName(userUpdated.getLastName());
        User dbUser = userDTOToEntity.convert(oldUser);
        userRepository.save(dbUser);
        return oldUser;
    }
}

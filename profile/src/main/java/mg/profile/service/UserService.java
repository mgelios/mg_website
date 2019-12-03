package mg.profile.service;

import mg.profile.converter.UserDtoToEntity;
import mg.profile.converter.UserEntityToDto;
import mg.profile.entity.User;
import mg.profile.dto.LocalUserDto;
import mg.profile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityToDto userEntityToDTO;

    @Autowired
    private UserDtoToEntity userDTOToEntity;

    public List<LocalUserDto> getUsersList() {
        List<LocalUserDto> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            users.add(userEntityToDTO.convert(user));
        });
        return users;
    }

    public LocalUserDto findUserByEmail(String email) {
        Optional<User> dbUser = userRepository.findByEmail(email);
        if (dbUser.isPresent()){
            return userEntityToDTO.convert(dbUser.get());
        } else return null;
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

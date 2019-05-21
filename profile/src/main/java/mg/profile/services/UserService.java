package mg.profile.services;

import mg.profile.converters.UserDTOToEntity;
import mg.profile.converters.UserEntityToDTO;
import mg.profile.dbentities.UserDBEntity;
import mg.profile.models.LocalUser;
import mg.profile.repositories.UserRepository;
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
    UserEntityToDTO userEntityToDTO;

    @Autowired
    UserDTOToEntity userDTOToEntity;

    public List<LocalUser> getUsersList() {
        List<LocalUser> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            users.add(userEntityToDTO.convert(user));
        });
        return users;
    }

    public LocalUser findUserByEmail(String email) {
        Optional<UserDBEntity> dbUser = userRepository.findByEmail(email);
        if (dbUser.isPresent()){
            return userEntityToDTO.convert(dbUser.get());
        } else return null;
    }

    public void saveUser(LocalUser user) {
        UserDBEntity dbUser = userDTOToEntity.convert(user);
        userRepository.save(dbUser);
    }

    public LocalUser mergeUpdatedUser(LocalUser userUpdated, LocalUser oldUser){
        oldUser.setEmail(userUpdated.getEmail());
        oldUser.setFirstName(userUpdated.getFirstName());
        oldUser.setLastName(userUpdated.getLastName());
        UserDBEntity dbUser = userDTOToEntity.convert(oldUser);
        userRepository.save(dbUser);
        return oldUser;
    }
}

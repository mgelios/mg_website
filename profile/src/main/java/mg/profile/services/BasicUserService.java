package mg.profile.services;

import mg.profile.converters.LocalUserToUserDBEntity;
import mg.profile.converters.UserDBEntityToLocalUser;
import mg.profile.dbentities.UserDBEntity;
import mg.profile.models.LocalUser;
import mg.profile.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BasicUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserDBEntityToLocalUser userDBEntityToLocalUser;

    @Autowired
    LocalUserToUserDBEntity localUserToUserDBEntity;

    @Override
    public List<LocalUser> getUsersList() {
        List<LocalUser> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            users.add(userDBEntityToLocalUser.convert(user));
        });
        return users;
    }

    @Override
    public LocalUser findUserByEmail(String email) {
        Optional<UserDBEntity> dbUser = userRepository.findByEmail(email);
        if (dbUser.isPresent()){
            return userDBEntityToLocalUser.convert(dbUser.get());
        }
        //TODO: trow custom exception or whatever...
        return null;
    }

    @Override
    public void saveUser(LocalUser user) {
        UserDBEntity dbUser = localUserToUserDBEntity.convert(user);
        userRepository.save(dbUser);
    }

    @Override
    public LocalUser mergeUpdatedUser(LocalUser userUpdated, LocalUser oldUser){
        oldUser.setEmail(userUpdated.getEmail());
        oldUser.setFirstName(userUpdated.getFirstName());
        oldUser.setLastName(userUpdated.getLastName());
        UserDBEntity dbUser = localUserToUserDBEntity.convert(oldUser);
        userRepository.save(dbUser);
        return oldUser;
    }
}

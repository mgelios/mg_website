package mg.profile.services;

import mg.profile.models.LocalUser;

import java.util.List;

public interface UserService {

    public List<LocalUser> getUsersList();

    public LocalUser findUserByEmail(String email);

    public void saveUser(LocalUser user);

    public LocalUser mergeUpdatedUser(LocalUser userUpdated, LocalUser oldUser);
}

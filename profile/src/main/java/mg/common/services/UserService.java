package mg.common.services;

import mg.common.models.LocalUser;

import java.util.List;

public interface UserService {

    public List<LocalUser> getUsersList();

    public LocalUser findUserByEmail(String email);

    public void saveUser(LocalUser user);

    public LocalUser mergeUpdatedUser(LocalUser userUpdated, LocalUser oldUser);
}

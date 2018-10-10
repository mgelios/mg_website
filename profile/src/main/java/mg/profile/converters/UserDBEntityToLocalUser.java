package mg.profile.converters;

import mg.profile.dbentities.UserDBEntity;
import mg.profile.models.LocalUser;
import mg.profile.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDBEntityToLocalUser implements Converter<UserDBEntity, LocalUser> {

    @Autowired
    RoleDBEntityToRole roleConverter;

    @Override
    public LocalUser convert(UserDBEntity source) {
        LocalUser target = new LocalUser();
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setPassword(source.getPassword());
        target.setEmail(source.getEmail());
        target.setEnabled(source.isEnabled());
        Set<Role> targetRoles =  source.getRoles().stream()
                .map(sourceRole -> roleConverter.convert(sourceRole))
                .collect(Collectors.toSet());
        target.setRoles(targetRoles);
        return target;
    }
}

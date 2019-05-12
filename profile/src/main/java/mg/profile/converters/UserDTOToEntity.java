package mg.profile.converters;

import mg.profile.dbentities.RoleDBEntity;
import mg.profile.dbentities.UserDBEntity;
import mg.profile.models.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDTOToEntity implements Converter<LocalUser, UserDBEntity> {

    @Autowired
    RoleDTOToEntity roleConverter;

    @Override
    public UserDBEntity convert(LocalUser source) {
        UserDBEntity target = new UserDBEntity();
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setPassword(source.getPassword());
        target.setEmail(source.getEmail());
        target.setEnabled(source.isEnabled());
        Set<RoleDBEntity> targetRoles = source.getRoles().stream()
                .map(sourceRole -> roleConverter.convert(sourceRole))
                .collect(Collectors.toSet());
        target.setRoles(targetRoles);
        return target;
    }
}

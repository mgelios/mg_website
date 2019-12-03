package mg.profile.converter;

import mg.profile.entity.Role;
import mg.profile.entity.User;
import mg.profile.dto.LocalUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDtoToEntity implements Converter<LocalUserDto, User> {

    @Autowired
    RoleDtoToEntity roleConverter;

    @Override
    public User convert(LocalUserDto source) {
        User target = new User();
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setPassword(source.getPassword());
        target.setEmail(source.getEmail());
        target.setEnabled(source.isEnabled());
        Set<Role> targetRoles = source.getRoles().stream()
                .map(sourceRole -> roleConverter.convert(sourceRole))
                .collect(Collectors.toSet());
        target.setRoles(targetRoles);
        return target;
    }
}

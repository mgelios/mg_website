package mg.profile.converter;

import mg.profile.entity.User;
import mg.profile.dto.LocalUserDto;
import mg.profile.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserEntityToDto implements Converter<User, LocalUserDto> {

    @Autowired
    RoleEntityToDto roleConverter;

    @Override
    public LocalUserDto convert(User source) {
        LocalUserDto target = new LocalUserDto();
        target.setId(source.getId());
        target.setUsername(source.getUsername());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setPassword(source.getPassword());
        target.setEmail(source.getEmail());
        target.setEnabled(source.isEnabled());
        Set<RoleDto> targetRoles =  source.getRoles().stream()
                .map(sourceRole -> roleConverter.convert(sourceRole))
                .collect(Collectors.toSet());
        target.setRoles(targetRoles);
        return target;
    }
}

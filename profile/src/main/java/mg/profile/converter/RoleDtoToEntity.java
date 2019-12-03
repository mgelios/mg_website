package mg.profile.converter;

import mg.profile.entity.Role;
import mg.profile.dto.RoleDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleDtoToEntity implements Converter<RoleDto, Role> {

    @Override
    public Role convert(RoleDto source) {
        Role target = new Role();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}

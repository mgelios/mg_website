package mg.profile.converter;

import mg.profile.entity.Role;
import mg.profile.dto.RoleDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleEntityToDto implements Converter<Role, RoleDto> {

    @Override
    public RoleDto convert(Role source) {
        RoleDto target = new RoleDto();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}

package mg.profile.converters;

import mg.profile.dbentities.RoleDBEntity;
import mg.profile.models.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToRoleDBEntity implements Converter<Role, RoleDBEntity> {

    @Override
    public RoleDBEntity convert(Role source) {
        RoleDBEntity target = new RoleDBEntity();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}

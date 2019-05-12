package mg.profile.converters;

import mg.profile.dbentities.RoleDBEntity;
import mg.profile.models.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleEntityToDTO implements Converter<RoleDBEntity, Role> {

    @Override
    public Role convert(RoleDBEntity source) {
        Role target = new Role();
        target.setId(source.getId());
        target.setName(source.getName());
        return target;
    }
}

package pe.upc.limapathsbackend.iam.interfaces.rest.transform;

import pe.upc.limapathsbackend.iam.domain.model.aggregates.User;
import pe.upc.limapathsbackend.iam.domain.model.entities.Role;
import pe.upc.limapathsbackend.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity){
        var roles = entity.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(entity.getId(), entity.getUsername(), roles);
    }
}
//Long id, String username, List<String> roles, String hashedPassword
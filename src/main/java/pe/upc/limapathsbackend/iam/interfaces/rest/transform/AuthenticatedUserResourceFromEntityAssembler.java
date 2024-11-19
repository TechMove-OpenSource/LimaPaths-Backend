package pe.upc.limapathsbackend.iam.interfaces.rest.transform;

import org.apache.commons.lang3.tuple.ImmutablePair;
import pe.upc.limapathsbackend.iam.domain.model.aggregates.User;
import pe.upc.limapathsbackend.iam.domain.model.entities.Role;
import pe.upc.limapathsbackend.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {

    public static AuthenticatedUserResource toResourceFromEntity(ImmutablePair<User, String> authenticatedUser) {
        var user = authenticatedUser.getLeft(); // Obtener el User
        var token = authenticatedUser.getRight(); // Obtener el token (String)
        var roles = user.getRoles().stream().map(Role::getStringName).toList();
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), roles, token);
    }

}


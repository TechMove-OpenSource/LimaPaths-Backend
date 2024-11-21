package pe.upc.limapathsbackend.iam.interfaces.rest.transform;

import org.apache.commons.lang3.tuple.ImmutablePair;
import pe.upc.limapathsbackend.iam.domain.model.aggregates.User;
import pe.upc.limapathsbackend.iam.domain.model.entities.Role;
import pe.upc.limapathsbackend.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {

    public static AuthenticatedUserResource toResourceFromEntity(User user, String token){
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}



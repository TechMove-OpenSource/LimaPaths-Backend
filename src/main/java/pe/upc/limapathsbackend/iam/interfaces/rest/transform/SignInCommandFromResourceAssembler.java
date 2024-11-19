package pe.upc.limapathsbackend.iam.interfaces.rest.transform;

import pe.upc.limapathsbackend.iam.domain.model.commands.SignInCommand;
import pe.upc.limapathsbackend.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {

    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password());
    }
}

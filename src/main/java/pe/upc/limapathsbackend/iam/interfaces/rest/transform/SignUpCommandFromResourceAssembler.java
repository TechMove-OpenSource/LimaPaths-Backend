package pe.upc.limapathsbackend.iam.interfaces.rest.transform;

import pe.upc.limapathsbackend.iam.domain.model.commands.SignUpCommand;
import pe.upc.limapathsbackend.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {

    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(resource.username(), resource.password(), resource.roles());
    }
}

package pe.upc.limapathsbackend.iam.domain.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.iam.domain.model.commands.SeedRolesCommand;

@Service

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}

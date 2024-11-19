package pe.upc.limapathsbackend.iam.domain.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.iam.domain.model.entities.Role;
import pe.upc.limapathsbackend.iam.domain.model.queries.GetAllRolesQuery;
import pe.upc.limapathsbackend.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

@Service

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);
    Optional<Role> handle(GetRoleByNameQuery query);
}

package pe.upc.limapathsbackend.iam.domain.model.queries;

import pe.upc.limapathsbackend.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles roleName) {
}

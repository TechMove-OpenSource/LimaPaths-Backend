package pe.upc.limapathsbackend.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, String token) {
}

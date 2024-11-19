package pe.upc.limapathsbackend.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, java.util.List<String> roles, String token) {
}

package pe.upc.limapathsbackend.iam.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;  // Importa ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.limapathsbackend.iam.domain.services.UserCommandService;
import pe.upc.limapathsbackend.iam.interfaces.rest.resources.UserResource;
import pe.upc.limapathsbackend.iam.interfaces.rest.resources.SignUpResource;
import pe.upc.limapathsbackend.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import pe.upc.limapathsbackend.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;

@RestController
@RequestMapping(value = "/api/v1/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Authentication", description = "Authentication Endpoint")
public class AuthenticationController {
    private final UserCommandService userCommandService;

    public AuthenticationController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResource> signUp(@RequestBody SignUpResource signUpResource) {
        // Cifrar la contraseña utilizando BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = passwordEncoder.encode(signUpResource.password());

        // Crear un nuevo recurso SignUpResource con la contraseña cifrada
        var updatedSignUpResource = new SignUpResource(signUpResource.username(), encryptedPassword, signUpResource.roles());

        // Convertir el recurso a un comando de sign-up
        var signUpCommand = SignUpCommandFromResourceAssembler.toCommandFromResource(updatedSignUpResource);

        // Procesar el comando de sign-up
        var user = userCommandService.handle(signUpCommand);

        // Si no se puede crear el usuario, devolver un error 400
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Convertir el usuario a un recurso para la respuesta
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());

        // Devolver la respuesta con código 201 y el recurso de usuario
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

}

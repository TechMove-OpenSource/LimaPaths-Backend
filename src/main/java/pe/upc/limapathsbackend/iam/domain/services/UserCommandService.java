package pe.upc.limapathsbackend.iam.domain.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.iam.domain.model.aggregates.User;
import pe.upc.limapathsbackend.iam.domain.model.commands.SignInCommand;
import pe.upc.limapathsbackend.iam.domain.model.commands.SignUpCommand;

import java.util.Optional;
@Service

public interface UserCommandService {
    Optional<User> handle(SignUpCommand command);
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
}

package pe.upc.limapathsbackend.iam.domain.services;

import org.springframework.stereotype.Service;
import pe.upc.limapathsbackend.iam.domain.model.aggregates.User;
import pe.upc.limapathsbackend.iam.domain.model.queries.GetAllUsersQuery;
import pe.upc.limapathsbackend.iam.domain.model.queries.GetUserByIdQuery;
import pe.upc.limapathsbackend.iam.domain.model.queries.GetUserByUsernameQuery;
import pe.upc.limapathsbackend.iam.domain.model.aggregates.User;
import pe.upc.limapathsbackend.iam.domain.model.queries.GetAllUsersQuery;
import pe.upc.limapathsbackend.iam.domain.model.queries.GetUserByIdQuery;
import pe.upc.limapathsbackend.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;
@Service

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);
}

package in.bushansirgur.expensetrackerapi.service;

import in.bushansirgur.expensetrackerapi.entity.User;
import in.bushansirgur.expensetrackerapi.entity.UserModel;

public interface UserService {

    User createUser(UserModel user);
    User readUser(Long id);

    User updateUser(UserModel user, Long id);
    void deleteUser(Long id);


}

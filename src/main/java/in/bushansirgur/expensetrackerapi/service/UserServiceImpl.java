package in.bushansirgur.expensetrackerapi.service;

import in.bushansirgur.expensetrackerapi.entity.User;
import in.bushansirgur.expensetrackerapi.entity.UserModel;
import in.bushansirgur.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User createUser(UserModel uModel){
        User user = new User();
        BeanUtils.copyProperties(uModel, user);
        return userRepo.save(user);

//        BeanUtils.copyProperties(source, target);
//        source : 원본 객체
//        target :  복사 대상 객체
    }


}

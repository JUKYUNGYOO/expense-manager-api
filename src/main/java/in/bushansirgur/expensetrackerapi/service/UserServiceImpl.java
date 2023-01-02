package in.bushansirgur.expensetrackerapi.service;

import in.bushansirgur.expensetrackerapi.entity.User;
import in.bushansirgur.expensetrackerapi.entity.UserModel;
import in.bushansirgur.expensetrackerapi.exceptions.ItemExistsException;
import in.bushansirgur.expensetrackerapi.exceptions.ResourceNotFoundException;
import in.bushansirgur.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public User createUser(UserModel uModel){
        if(userRepo.existsByEmail(uModel.getEmail())){
            throw new ItemExistsException("User is already register with email" +
                    uModel.getEmail());
        }
        User newUser = new User();
        BeanUtils.copyProperties(uModel, newUser);
        newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
        return userRepo.save(newUser);

//        BeanUtils.copyProperties(source, target);
//        source : 원본 객체
//        target :  복사 대상 객체
    }
    @Override
    public User readUser(Long id){
        return userRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User not found for the id:" + id));

    }

    @Override
    public User updateUser(UserModel user, Long id) {
        User existingUser = readUser(id);
        existingUser.setName(user.getName() != null ? user.getName():existingUser.getName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail():existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ? bcryptEncoder.encode(user.getPassword()):existingUser.getPassword());
        existingUser.setAge(user.getAge() != null ? user.getAge():existingUser.getAge());
        return userRepo.save(existingUser);
    }
    @Override
    public void deleteUser(Long id){
        User existingUser = readUser(id);
        userRepo.delete(existingUser);

    }


}

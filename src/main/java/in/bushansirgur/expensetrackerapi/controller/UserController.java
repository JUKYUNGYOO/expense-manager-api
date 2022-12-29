package in.bushansirgur.expensetrackerapi.controller;

import in.bushansirgur.expensetrackerapi.entity.User;
import in.bushansirgur.expensetrackerapi.entity.UserModel;
import in.bushansirgur.expensetrackerapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    전달값 UserMode, 반환값 ResponseEntity
    @PostMapping("/register")
    public ResponseEntity<User> save(@RequestBody UserModel user)
    {
        return new ResponseEntity<User>(userService.createUser(user),
                HttpStatus.CREATED);
//        ResponseEntity - http 응답으로 변환 될 정보를 객체로 반환.

    }
}

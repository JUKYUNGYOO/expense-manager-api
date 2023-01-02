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

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(){
        return new ResponseEntity<String>("User is logged in", HttpStatus.OK);
    }
    //    전달값 UserMode, 반환값 ResponseEntity
    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel user)
    {
        return new ResponseEntity<User>(userService.createUser(user),
                HttpStatus.CREATED);
//        ResponseEntity - http 응답으로 변환 될 정보를 객체로 반환.

    }
}

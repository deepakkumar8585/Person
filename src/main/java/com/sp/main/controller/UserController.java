package com.sp.main.controller;


import com.sp.main.entity.User;
import com.sp.main.payload.UserDto;
import com.sp.main.service.UserKycService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserKycService userKycService;

    public UserController(UserKycService userKycService) {
        this.userKycService = userKycService;
    }
    //http://localhost:8282/api/v1/user/user

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
      UserDto userDto1 =  userKycService.createUser(userDto);
      return  new ResponseEntity<>(userDto1 , HttpStatus.CREATED);
   }
    @GetMapping("/user/{id}")
   public ResponseEntity<UserDto> getUserById(@PathVariable("id") long id ){
      UserDto userDto = userKycService.getUserById(id);
      return new ResponseEntity<>(userDto, HttpStatus.OK);
   }

   @GetMapping("/users")
   public ResponseEntity<List<User>> getAllUser(
           @RequestParam(name="pageSize"  , required = false , defaultValue ="0" ) int pageSize ,
           @RequestParam(name="pageNumber"  , required = false , defaultValue ="3" ) int pageNumber,
           @RequestParam(name="sortBy"  , required = false , defaultValue ="id" ) String sortBy,
           @RequestParam(name="sortDir"  , required = false , defaultValue ="asc" ) String sortDir

   ) {
      List<User> allUser =  userKycService.getAllUser(pageSize , pageNumber,sortBy , sortDir);
       return new ResponseEntity<>(allUser , HttpStatus.OK);
   }
}

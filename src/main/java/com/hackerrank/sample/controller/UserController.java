package com.hackerrank.sample.controller;

import com.hackerrank.sample.dto.Response;
import com.hackerrank.sample.dto.UserRequestDto;
import com.hackerrank.sample.services.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/endpoint")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/insert")
    public ResponseEntity<Response> createUser(@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>
                (new Response("Successfull", HttpStatus.CREATED,userService.createUser(userRequestDto)),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateUser(@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>
                (new Response("Update Successfull", HttpStatus.OK,userService.updateUser(userRequestDto)),HttpStatus.ACCEPTED);
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Response> getSingleUser(@PathVariable Long id){

        return new ResponseEntity<>
                (new Response("Record Fetched Successfully",HttpStatus.OK,userService.getSingleUser(id)),HttpStatus.OK);
    }

    @GetMapping("/select")
    public ResponseEntity<Response> getAllUsers(@RequestParam(value = "page") int page,
                                                @RequestParam(value = "pageSize") int pageSize){
        return new ResponseEntity<>
                (new Response("Record Fetched Successfully",HttpStatus.OK,userService.getAllUsers(PageRequest.of(page, pageSize))),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    protected ResponseEntity<Response> deleteUser(@PathVariable Long id){

        return new ResponseEntity<>
                (new Response("Delete Operation Successfull", HttpStatus.ACCEPTED,userService.removeAUser(id)) ,HttpStatus.ACCEPTED);
    }
}

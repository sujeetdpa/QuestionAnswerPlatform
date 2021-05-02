package question.answer.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import question.answer.platform.model.Topic;
import question.answer.platform.model.User;
import question.answer.platform.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/all")
    public List<User> getUser(){
        return userService.getUsers();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return  userService.addUser(user);
    }

    @PutMapping("/update/{id}")
    public User updateTopic(@PathVariable Long id,@RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTopic(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}

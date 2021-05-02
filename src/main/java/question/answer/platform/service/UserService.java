package question.answer.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import question.answer.platform.dao.UserRepository;
import question.answer.platform.model.Topic;
import question.answer.platform.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(()->new IllegalStateException("User not found with id: "+id));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
    @Transactional
    public User updateUser(Long id, User user) {
        User user1=findById(id);
        user1.setName(user.getName());
        return user1;
    }

    public String deleteUser(Long id) {
        User user=findById(id);
        userRepository.delete(user);
        return String.format("Successfuly deleted User: %s of id: %s",user.getName(),user.getId());
    }
}

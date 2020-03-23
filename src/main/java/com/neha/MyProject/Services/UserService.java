package com.neha.MyProject.Services;

import com.neha.MyProject.modal.User;
import com.neha.MyProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public void saveMyUser(User user){
        System.out.println(">>>> "+user.getUsername());
        System.out.println(">>>> "+user.getFirstname());
        System.out.println(">>>> "+user.getLastname());
        System.out.println(">>>> "+user.getPassword());
        System.out.println(">>>> "+user.getAge());
        System.out.println(">>>> "+user.getId());
        userRepository.save(user);
    }

    public List<User> showAllUsers(){
        List<User> users=new LinkedList<>();
        for(User user:userRepository.findAll()){
            users.add(user);
        }
        return users;
    }

    public void deleteMyUser(int id){
        userRepository.deleteById(id);
    }

/*
    public Optional<User> editMyUser(int id){
       return userRepository.findById(id);
    }
*/


}

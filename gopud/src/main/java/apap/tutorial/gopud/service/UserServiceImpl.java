package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user){
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel getUser(String username) {
        return userDB.findByUsername(username);
    }

    @Override
    public boolean checkPassword(String oldPassword, String input) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(input,oldPassword);
    }

    @Override
    public void updatePassword(String username, String newPass) {
        UserModel user = userDB.findByUsername(username);
        String newPassword = encrypt(newPass);
        user.setPassword(newPassword);
        userDB.save(user);
    }

}

package teksystems.casestudy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teksystems.casestudy.database.dao.UserDAO;

@Slf4j

@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    // if you have some more complex logic then you can move it into
    // this class and run it from the controller
    public boolean changePasswordValidator(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            log.info("New passwords match.");
            return true;
        } else {
            log.info("New passwords don't match.");
            return false;

        }
    }
}

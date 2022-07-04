package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.UserRole;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(@Param("userId") Integer userId);
}


// 1) create user_role table
// 2) create entity
// 3) create dao
// 4) create login.jsp
// 5) create login controller
// 6) make sure spring starts and you can get to your login page
// 7) add spring security to pom
// 8) Create a spring configuration class for security
// 9) Copy boiler plate code for security config and adjust as needed
// 10) Include the bcrypt encoder in the security config
// 11) use a website to bcrypt a plain text password and store the encrypted password in the database
// 12) create the UserDetailsServiceImpl class
// 13) add the UserDetailsServiceImpl to the SecurityConfig

package com.capgemini.app.repositery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.app.entity.User;
@Repository
public interface UserRepositery extends JpaRepository<User,String>{

}

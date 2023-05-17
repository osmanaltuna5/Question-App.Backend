package com.osmanaltunay.questApp.repos;

import com.osmanaltunay.questApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}

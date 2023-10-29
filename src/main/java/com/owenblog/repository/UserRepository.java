package com.owenblog.repository;

import com.owenblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by owen on 2023/10/29.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}

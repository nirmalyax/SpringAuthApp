// -----------------------------------------------------------------------------
//             Developed by Nirmalya Mondal | SpringAuthApp Project
//   GitHub: https://github.com/nirmalyax   |   © 2025 All rights reserved
// -----------------------------------------------------------------------------

package com.nirmalya.springauthapp.repository;

import com.nirmalya.springauthapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long>{

    Optional<User>findByEmail(String email);
    boolean existsByEmail(String email);
}

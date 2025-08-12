package org.schedulerdevelop.Repository;

import org.schedulerdevelop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

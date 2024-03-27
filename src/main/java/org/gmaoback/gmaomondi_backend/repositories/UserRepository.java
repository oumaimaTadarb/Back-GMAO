package org.gmaoback.gmaomondi_backend.repositories;
import org.gmaoback.gmaomondi_backend.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
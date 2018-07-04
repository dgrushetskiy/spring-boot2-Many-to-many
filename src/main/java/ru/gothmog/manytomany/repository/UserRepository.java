package ru.gothmog.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gothmog.manytomany.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(int id);

    User findBySsoId(String ssoId);

    @Transactional
    void deleteBySsoId(String ssoId);
}

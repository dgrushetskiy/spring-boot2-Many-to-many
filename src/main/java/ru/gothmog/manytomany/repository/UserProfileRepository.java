package ru.gothmog.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gothmog.manytomany.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

    UserProfile findByType(String type);

    UserProfile findById(int id);
}

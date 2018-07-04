package ru.gothmog.manytomany.service;

import ru.gothmog.manytomany.model.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();
}

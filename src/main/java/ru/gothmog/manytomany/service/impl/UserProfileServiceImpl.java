package ru.gothmog.manytomany.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gothmog.manytomany.model.UserProfile;
import ru.gothmog.manytomany.repository.UserProfileRepository;
import ru.gothmog.manytomany.service.UserProfileService;

import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;

    public UserProfile findById(int id) {
        return userProfileRepository.findById(id);
    }

    public UserProfile findByType(String type){
        return userProfileRepository.findByType(type);
    }

    public List<UserProfile> findAll() {
        return userProfileRepository.findAll();
    }
}

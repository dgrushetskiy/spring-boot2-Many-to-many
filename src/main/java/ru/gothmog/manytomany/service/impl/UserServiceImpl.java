package ru.gothmog.manytomany.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gothmog.manytomany.model.User;
import ru.gothmog.manytomany.repository.UserRepository;
import ru.gothmog.manytomany.service.UserService;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
   private UserRepository userRepository;

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public User findBySSO(String sso) {
        User user = userRepository.findBySsoId(sso);
        return user;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(User user) {
        int id = user.getId();
        User entity = userRepository.findById(id);
        if(entity!=null){
            entity.setSsoId(user.getSsoId());
            entity.setPassword(user.getPassword());
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            entity.setUserProfiles(user.getUserProfiles());
        }
    }


    public void deleteUserBySSO(String sso) {
       userRepository.deleteBySsoId(sso);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public boolean isUserSSOUnique(Integer id, String sso) {
        User user = findBySSO(sso);
        return ( user == null || ((id != null) && (user.getId() == id)));
    }
}

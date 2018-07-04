package ru.gothmog.manytomany.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.gothmog.manytomany.model.UserProfile;
import ru.gothmog.manytomany.service.UserProfileService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {

    @Autowired
    UserProfileService userProfileService;

    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public UserProfile convert(Object element) {
        Integer id = Integer.valueOf((String)element);
        UserProfile profile= userProfileService.findById(id);
        System.out.println("Profile : " + profile);
        return profile;
    }

    private Integer getInteger(String str) {
        if (str != null) {
            return Integer.parseInt(str);
        } else {
            return new Integer(0);
        }
    }
}

package com.straus.fullscore.service;

import com.straus.fullscore.model.AppUser;
import com.straus.fullscore.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    /**
     * Method to fetch a user by their uuid
     *
     * @param uuid The unique uuid to identify the user
     * @return The user object
     */
    @Override
    public AppUser fetchUserByUuid(String uuid) {
        return appUserRepository.findById(uuid).orElse(null);
    }

    /**
     * Method to save a user object
     *
     * @param user The user object to save
     * @return The updated user object
     */
    @Override
    public AppUser saveAppUser(AppUser user) {
        return appUserRepository.save(user);
    }
}

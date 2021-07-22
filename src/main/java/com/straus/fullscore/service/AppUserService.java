package com.straus.fullscore.service;

import com.straus.fullscore.model.AppUser;

public interface AppUserService {
    /**
     * Method to fetch a user by their uuid
     *
     * @param uuid The unique uuid to identify the user
     * @return The user object
     */
    AppUser fetchUserByUuid(String uuid);

    /**
     * Method to save a user object
     *
     * @param user The user object to save
     * @return The updated user object
     */
    AppUser saveAppUser(AppUser user);
}

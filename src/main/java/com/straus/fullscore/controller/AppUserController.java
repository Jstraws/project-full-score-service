package com.straus.fullscore.controller;

import com.straus.fullscore.model.AppUser;
import com.straus.fullscore.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AppUserController {
    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping(value = "/uuid/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUser> fetchUserByUuid(@PathVariable String uuid) {
        return new ResponseEntity<>(appUserService.fetchUserByUuid(uuid), HttpStatus.OK);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        return new ResponseEntity<>(appUserService.saveAppUser(user), HttpStatus.OK);
    }
}

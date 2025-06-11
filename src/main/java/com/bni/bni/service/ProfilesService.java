package com.bni.bni.service;

import com.bni.bni.entity.Profiles;
import com.bni.bni.repository.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilesService {

    @Autowired
    private ProfilesRepository profilesRepository;

    public Profiles createProfile(Profiles profile) {
        return profilesRepository.save(profile);
    }

    public List<Profiles> getProfilesByUserId(Long userId) {
    return profilesRepository.findAllByUserId(userId);
    }

    public Profiles updateProfile(Profiles profile) {
        return profilesRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        profilesRepository.deleteById(id);
    }
}

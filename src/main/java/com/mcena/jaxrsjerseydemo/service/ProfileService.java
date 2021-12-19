package com.mcena.jaxrsjerseydemo.service;



import com.mcena.jaxrsjerseydemo.database.DatabaseClass;
import com.mcena.jaxrsjerseydemo.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {
    private Map<String, Profile> profileMap = DatabaseClass.getProfiles();

    public ProfileService() {
        profileMap.put("Marco", new Profile(1, "marcocena", "Marco", "Cena"));
        profileMap.put("Baldo", new Profile(2, "baldocena", "Baldo", "zoid"));
    }

    public List<Profile> getProfiles() {
        return new ArrayList<Profile>(profileMap.values());
    }

    public Profile getProfile(String profileName) {
        return profileMap.get(profileName);
    }

    public Profile addProfile(Profile profile) {
        profile.setId(profileMap.size() + 1);
        profileMap.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if(profile.getProfileName().isEmpty()) {
            return null;
        }
        profileMap.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return profileMap.remove(profileName);
    }
}

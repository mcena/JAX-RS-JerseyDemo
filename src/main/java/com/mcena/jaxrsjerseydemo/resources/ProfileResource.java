package com.mcena.jaxrsjerseydemo.resources;


import com.mcena.jaxrsjerseydemo.model.Profile;
import com.mcena.jaxrsjerseydemo.service.ProfileService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/profiles")
public class ProfileResource {


    ProfileService profileService = new ProfileService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getProfiles() {
        return profileService.getProfiles();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName) {
        return profileService.getProfile(profileName);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Profile addProfile(Profile profile) {
        return profileService.addProfile(profile);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
        profile.setProfileName(profileName);
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteProfile(@PathParam("profileName") String profileName) {
        profileService.removeProfile(profileName);
        return "profile removed!";
    }
}

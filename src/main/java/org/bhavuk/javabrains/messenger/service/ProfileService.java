package org.bhavuk.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bhavuk.javabrains.messenger.database.DatabaseClass;
import org.bhavuk.javabrains.messenger.model.Profile;


public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		
		profiles.put("bhavuk", new Profile(1L, "thor", "Bhavuk", "Sharma"));
	}
	
	public List<Profile> getAllprofiles()
	{
		return new ArrayList<Profile>(profiles.values()); 
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profile.setCreated(new Date()); //added date automatically when created, so no need to specify in JSON
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profile.setCreated(new Date()); //added date automatically when updated, so no need to specify in JSON
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}

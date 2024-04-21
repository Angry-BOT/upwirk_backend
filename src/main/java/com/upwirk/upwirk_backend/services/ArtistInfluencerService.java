package com.upwirk.upwirk_backend.services;

import java.util.ArrayList;
import java.util.List;

import com.upwirk.upwirk_backend.models.User;
import com.upwirk.upwirk_backend.models.SearchCriteria;


public interface ArtistInfluencerService {
    List<User> search(SearchCriteria criteria);
    List<User> viewAllArtist(SearchCriteria criteria);
    void generateUserList();
}

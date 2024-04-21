package com.upwirk.upwirk_backend.implementation;

import com.upwirk.upwirk_backend.services.ArtistInfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import com.upwirk.upwirk_backend.models.SearchCriteria;
import org.springframework.stereotype.Service;
import com.upwirk.upwirk_backend.models.User;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistInfluencerServiceImpl implements ArtistInfluencerService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> search(SearchCriteria criteria) {
        List filteredArtist;
        filteredArtist = this.entityManager.createQuery("SELECT u.name, u.email, r.pricingModel, r.rate," +
                                                        "s.platform, s.username, s.followerCount FROM Rates r " +
                                                        "INNER JOIN SocialMediaProfiles s " +
                                                        "ON r.user = s.user " +
                                                        "INNER JOIN r.user u " +
                                                        "WHERE u.userType = :user_type " +
                                                        //"WHERE u.location = :location " +
                                                        "AND r.pricingModel = :pricing_model " +
                                                        "AND r.rate >= :min_price " +
                                                        "AND r.rate <= :max_price " +
                                                        "AND s.followerCount >= :min_count " +
                                                        "AND s.followerCount <= :max_count")
                             .setParameter("user_type", criteria.getArtistCategory())
                             //.setParameter("location", criteria.getLocation())
                             .setParameter("pricing_model",criteria.getPricingModel())
                             .setParameter("min_price",criteria.getMinPrice())
                             .setParameter("max_price",criteria.getMaxPrice())
                             .setParameter("min_count",criteria.getMinFollowers())
                             .setParameter("max_count",criteria.getMaxFollowers())
                             .getResultList();
        return filteredArtist;
    }

    @Override
    public List<User> viewAllArtist(SearchCriteria criteria) {
        List allArtist;
        allArtist = this.entityManager.createQuery("SELECT u.name, u.email, r.pricingModel, r.rate," +
                        "s.platform, s.username, s.followerCount FROM Rates r " +
                        "INNER JOIN SocialMediaProfiles s " +
                        "ON r.user = s.user " +
                        "INNER JOIN r.user u " +
                        "WHERE u.userType = :user_type")
                .setParameter("user_type", criteria.getArtistCategory())
                .getResultList();
        return allArtist;
    }

    @Override
    public void generateUserList() {

    }
}

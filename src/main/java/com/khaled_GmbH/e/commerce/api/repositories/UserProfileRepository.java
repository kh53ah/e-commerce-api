package com.khaled_GmbH.e.commerce.api.repositories;

import com.khaled_GmbH.e.commerce.api.entities.UserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository <UserProfile, Long> {
}

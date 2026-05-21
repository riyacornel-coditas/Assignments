package com.project.second.repository;

import com.project.second.entity.RestaurantBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantBranchRepository extends JpaRepository<RestaurantBranch, Integer> {
}

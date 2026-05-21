package com.project.second.service;

import com.project.second.dtos.TableRequest;
import com.project.second.entity.Chef;
import com.project.second.entity.Restaurant;
import com.project.second.entity.RestaurantBranch;
import com.project.second.entity.RestaurantTable;
import com.project.second.exception.*;
import com.project.second.repository.ChefRepository;
import com.project.second.repository.RestaurantBranchRepository;
import com.project.second.repository.RestaurantRepository;
import com.project.second.repository.RestaurantTableRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TableService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableRepository restaurantTableRepository;
    private final ChefRepository chefRepository;
    private final RestaurantBranchRepository restaurantBranchRepository;

    @Transactional
    public String addTables(TableRequest request)
    {
        if (request == null) {
            throw new InvalidTableException("Table request cannot be null");
        }

        if (request.getRestaurant_id() == null) {
            throw new InvalidTableException("Restaurant ID is required");
        }

        if (request.getBranch_id() == null) {
            throw new InvalidTableException("Branch ID is required");
        }

        if (request.getTable_no() == null) {
            throw new InvalidTableException("Table number is required");
        }

        try {
            Restaurant restaurant = restaurantRepository.findById(request.getRestaurant_id())
                    .orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));

            RestaurantBranch restaurantBranch = restaurantBranchRepository.findById(request.getBranch_id())
                    .orElseThrow(() -> new RestaurantBranchNotFoundException("Branch not found"));

            RestaurantTable table = new RestaurantTable();

            table.setTable_no(request.getTable_no());
            table.setStatus("PENDING");
            table.setTable_type(request.getTable_type());

            table.setRestaurant(restaurant);
            table.setRestaurantBranch(restaurantBranch);

            if (request.getChef_id() != null) {
                Chef chef = chefRepository.findById(request.getChef_id())
                        .orElseThrow(() -> new ChefNotFoundException("Chef not found"));

                table.setChef(chef);
            }

            restaurantTableRepository.save(table);

            return "Table successfully added";
        }
        catch (Exception e)
        {
            throw new TableProcessingException("failed to add table");
        }
    }

    public String approveTable(Integer tableId) {

        if (tableId == null) {
            throw new InvalidTableException("Table ID cannot be null");
        }

        try {
            RestaurantTable table = restaurantTableRepository.findById(tableId)
                    .orElseThrow(() -> new TableNotFoundException("Table not found"));

            table.setStatus("APPROVED");

            restaurantTableRepository.save(table);

            return "Table has been approved";
        } catch (Exception e) {
            throw new TableProcessingException("failed to approve the table");
        }

    }

    public String rejectTable(Integer tableId) {

        if (tableId == null) {
            throw new InvalidTableException("Table ID cannot be null");
        }
        try {
            RestaurantTable table = restaurantTableRepository.findById(tableId)
                    .orElseThrow(() -> new TableNotFoundException("Table not found"));

            table.setStatus("REJECTED");

            restaurantTableRepository.save(table);

            return "Table has been rejected";
        }
        catch (Exception e)
        {
            throw new TableProcessingException("failed to reject the table");
        }
    }
}

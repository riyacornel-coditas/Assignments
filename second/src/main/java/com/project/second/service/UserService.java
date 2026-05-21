package com.project.second.service;

import com.project.second.dtos.*;
import com.project.second.entity.*;
import com.project.second.enums.Role;
import com.project.second.exception.RestaurantBranchNotFoundException;
import com.project.second.exception.RestaurantNotFoundException;
import com.project.second.exception.UserRegistrationException;
import com.project.second.exception.UsernameAlreadyExistsException;
import com.project.second.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final InvitationRepository invitationRepo;

    private final UsersRepository usersRepo;

    private final RestaurantRepository restaurantRepo;

    private final RestaurantBranchRepository branchRepo;

    private final RestaurantOwnerRepository ownerRepo;

    private final ManagerRepository managerRepo;

    private final ChefRepository chefRepo;

    private final WaiterRepository waiterRepo;

    @Transactional
    public String registerOwner(OwnerRegistrationRequest request) {

        if (request == null) {
            throw new UserRegistrationException("Request cannot be null");
        }

        if (usersRepo.existsByUsername(request.getUsername())) {

            throw new UsernameAlreadyExistsException("Username already exists");
        }
        Invitation invitation =
                invitationRepo.findByToken(request.getToken())
                        .orElseThrow(() -> new RuntimeException("Invalid token"));

        if (invitation.isAccepted()) {

            throw new RuntimeException("Invitation already accepted");
        }

        try {
            Users owner = new Users();
            owner.setFirst_name(request.getOwnerFirstName());
            owner.setLast_name(request.getOwnerLastName());
            owner.setUsername(request.getUsername());
            owner.setPassword(request.getPassword());
            owner.setRole(Role.OWNER);

            usersRepo.save(owner);

            Restaurant restaurant = new Restaurant();
            restaurant.setName(request.getRestaurantName());
            restaurant.setLocation(request.getCity());
            restaurant.setOwners(List.of(owner));
            restaurant.setRegistration_no(request.getRegistrationNo());
            restaurant.setRevenue(request.getRevenue());
            restaurant.setType(request.getType());

            restaurantRepo.save(restaurant);

            RestaurantBranch branch = new RestaurantBranch();
            branch.setBranch_name(request.getBranchName());
            branch.setCity(request.getCity());
            branch.setRestaurant(restaurant);

            branchRepo.save(branch);

            invitation.setAccepted(true);

            invitationRepo.save(invitation);

            RestaurantOwner restaurantOwner = new RestaurantOwner();
            restaurantOwner.setContact_no(request.getContactNo());
            restaurantOwner.setEmail(request.getEmail());
            restaurantOwner.setFirst_name(request.getOwnerFirstName());
            restaurantOwner.setLast_name(request.getOwnerLastName());

            ownerRepo.save(restaurantOwner);


            return "Owner Registered Successfully";
        } catch (Exception e) {
            throw new UserRegistrationException("failed to register owner");
        }
    }

    public String registerManager(ManagerRequest request) {

        RestaurantBranch branch = branchRepo.findById(request.getBranch_id())
                .orElseThrow(()-> new RestaurantBranchNotFoundException("Branch not found"));

        Restaurant restaurant = restaurantRepo.findById(request.getRestaurant_id())
                .orElseThrow(()-> new RestaurantNotFoundException("Restaurant not found"));

        if(branchRepo.existsById(request.getBranch_id()))
        {
            Users user = new Users();
            user.setFirst_name(request.getFirst_name());
            user.setLast_name(request.getLast_name());
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            user.setRole(Role.MANAGER);

            usersRepo.save(user);

            Manager manager = new Manager();
            manager.setFirst_name(request.getFirst_name());
            manager.setLast_name(request.getLast_name());
            manager.setEmail(request.getEmail());
            manager.setContact_no(request.getContact_no());
            manager.setQualification(request.getQualification());
            manager.setUser(user);
            manager.setBranch(branch);
            manager.setRestaurant(restaurant);

            managerRepo.save(manager);
        }
        return "Manager registered successfully";
    }

    public String registerChef(ChefRequest request) {
        RestaurantBranch branch = branchRepo.findById(request.getBranch_id())
                        .orElseThrow(() -> new RestaurantBranchNotFoundException("Branch not found"));

        Restaurant restaurant = restaurantRepo.findById(request.getRestaurant_id())
                .orElseThrow(()-> new RestaurantNotFoundException("Restaurant not found"));

        Users user = new Users();

        user.setFirst_name(request.getFirst_name());
        user.setLast_name(request.getLast_name());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(Role.CHEF);

        usersRepo.save(user);

        Chef chef = new Chef();

        chef.setFirst_name(request.getFirst_name());
        chef.setLast_name(request.getLast_name());
        chef.setProfile_photo(request.getProfile_photo());
        chef.setSalary(request.getSalary());
        chef.setUser(user);
        chef.setBranch(branch);
        chef.setRestaurant(restaurant);
        chef.setCuisine(request.getCuisine());

        chefRepo.save(chef);

        return "Chef Added Successfully";
    }

    public String registerWaiter(WaiterRequest request) {

        RestaurantBranch branch = branchRepo.findById(request.getBranch_id())
                        .orElseThrow(() -> new RestaurantBranchNotFoundException("Branch not found"));

        Restaurant restaurant = restaurantRepo.findById(request.getRestaurant_id())
                .orElseThrow(()-> new RestaurantNotFoundException("Restaurant not found"));

        Users user = new Users();

        user.setFirst_name(request.getFirst_name());
        user.setLast_name(request.getLast_name());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(Role.WAITER);

        usersRepo.save(user);

        Waiter waiter = new Waiter();

        waiter.setFirst_name(request.getFirst_name());
        waiter.setLast_name(request.getLast_name());
        waiter.setProfile_photo(request.getProfile_photo());
        waiter.setSalary(request.getSalary());
        waiter.setUser(user);
        waiter.setBranch(branch);
        waiter.setRestaurant(restaurant);

        waiterRepo.save(waiter);

        return "Waiter Added Successfully";
    }

    public String registerAdmin(AdminRequest request) {

        Users user = new Users();
        user.setFirst_name(request.getFirst_name());
        user.setLast_name(request.getLast_name());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(Role.ADMIN);

        usersRepo.save(user);

        return "Admin created successfully";
    }
}

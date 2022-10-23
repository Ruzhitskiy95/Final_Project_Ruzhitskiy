package by.academy.controller.springdata;

import by.academy.controller.requests.UserCreateRequest;
import by.academy.domain.Gender;
import by.academy.domain.hibernate.Credentials;
import by.academy.domain.hibernate.HibernateUser;
import by.academy.repository.springdata.UserSpringDataRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.util.*;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/data/users")
public class UserController {
    private final UserSpringDataRepository userSpringDataRepository;

    @Tag(name = "Endpoint for user", description = "All methods for user")
    @Operation(summary = "Select all users", description = "Select all users")
    @GetMapping("/findAll")
    public ResponseEntity<Object> userFindAllEndpoint() {

        return new ResponseEntity<>(Collections.singletonMap("result",
                userSpringDataRepository.findAll()), HttpStatus.OK);
    }

    @Tag(name = "Endpoint for user", description = "Method findById for user")
    @Operation(summary = "Select user by id", description = "Select user by id")
    @GetMapping("/findById")
    public ResponseEntity<Object> userFindByIdEndpoint(
            @RequestParam("id") @Parameter(
                    description = "User id") Long userId)
    {

        return new ResponseEntity<>(Collections.singletonMap("result",
                userSpringDataRepository.findById(userId)), HttpStatus.OK);
    }
    @Tag(name = "Endpoint for user", description = "Method FindAllUserByGender for user")
    @Operation(summary = "Select user by gender", description = "Select user by gender")
    @GetMapping("/findByGender")
    public ResponseEntity<Object> userFindAllUserByGender(  @RequestParam ("gender") @Parameter(
            description = "User gender") String gender) {

        return new ResponseEntity<>(Collections.singletonMap("result",
                userSpringDataRepository.findUserByGender(gender)), HttpStatus.OK);
    }
    @PostMapping
    @Transactional
    public ResponseEntity<Object> createUser(@RequestBody UserCreateRequest createRequest) {

        HibernateUser user = new HibernateUser();
        user.setUserName(createRequest.getUserName());
        user.setSurName(createRequest.getSurName());
        user.setBirthDate(new Timestamp(new Date().getTime()));
        user.setCreationDate(new Timestamp(new Date().getTime()));
        user.setModificationDate(new Timestamp(new Date().getTime()));
        user.setIsDeleted(false);
        Credentials credentials = new Credentials(RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10));
//        user.setLogin(RandomStringUtils.randomAlphabetic(10));
//        user.setPassword(RandomStringUtils.randomAlphabetic(10));
        user.setGender(Gender.FEMALE);

        HibernateUser createdUser = userSpringDataRepository.save(user);

        userSpringDataRepository.createRoleRow(createdUser.getId(), userSpringDataRepository.findById(1L).get().getId());

        Map<String, Object> model = new HashMap<>();
        model.put("user", createdUser);

        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

}

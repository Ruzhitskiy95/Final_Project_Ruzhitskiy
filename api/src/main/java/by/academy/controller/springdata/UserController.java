package by.academy.controller.springdata;

import by.academy.controller.requests.UserCreateRequest;
import by.academy.domain.Gender;
import by.academy.domain.hibernate.Credentials;
import by.academy.domain.hibernate.HibernateUser;
import by.academy.repository.springdata.UserSpringDataRepository;
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

    @GetMapping
    public ResponseEntity<Object> testEndpoint() {

        return new ResponseEntity<>(Collections.singletonMap("result",
                userSpringDataRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<Object> testEndpointGender(@RequestParam("id") Long userId,
                                                     @RequestParam ("gender") String gender) {

        return new ResponseEntity<>(Collections.singletonMap("result",
                userSpringDataRepository.findByIdAndGender(userId,Gender.valueOf(gender))), HttpStatus.OK);
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

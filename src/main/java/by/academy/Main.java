package by.academy;

import by.academy.configuration.DatabaseProperties;
import by.academy.domain.User;
import by.academy.repository.UserRepository;

import java.awt.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        UserRepository userRepository = new UserRepository(new DatabaseProperties());

        List<User> all= userRepository.findAll();
        for (User user:  all ) {
            System.out.println(user);
        }
        System.out.println("findById");
        // findById
        User user = userRepository.findById(1L);
        System.out.println(user);

//        System.out.println("find By Name Or Surname");
//        UserRepository userRepositorySearch = new UserRepository(new DatabaseProperties());
//        List<User> allSearch =userRepositorySearch.findNameSurname("k");
//        for (User userSearch: allSearch
//             ) {
//            System.out.println(userSearch);
//        }
//        System.out.println("find By Name Or Surname with PrepareStatement");
//        UserRepository userRepositorySearchPrepare = new UserRepository(new DatabaseProperties());
//        List<User> allSearchPrepare =userRepositorySearchPrepare.findNameSurname("k");
//        for (User userSearch: allSearchPrepare
//        ) {
//            System.out.println(userSearch);
//        }
        //FindOne
        System.out.println("FindOne");
        System.out.println(userRepository.findOne(1L));

        //FindAllWithParams
        System.out.println("FindAllWithParams");
        List<User> allParam= userRepository.findAll(3,1);
        for (User userAllParam:  allParam ) {
            System.out.println(userAllParam);
        }
        //Create
        System.out.println("Create");
        User userInsert = new User();
        userInsert.setUserName("Slava");
        userInsert.setSurName("Maslianskiy");
        userInsert.setBirthDate(new Timestamp(new Date().getTime()));
        userInsert.setIsDeleted(false);

            System.out.println(userInsert);

            User userCreate = userRepository.create(userInsert);
        System.out.println(userCreate);

        //Update
        System.out.println("Update");
        userInsert.setId(userCreate.getId());
        userInsert.setUserName("Alexanrdra");
        userInsert.setSurName("Kozyrava");
        user.setBirthDate (new Timestamp(new Date().getTime()));
        User userUpdate = userRepository.update(userInsert);
        System.out.println(userUpdate);

        //delete
        System.out.println("delete");
        Long userDelete = userRepository.delete(38L);
        System.out.println(userDelete);
        }



}

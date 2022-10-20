package by.academy.repository.springdata;

import by.academy.domain.Gender;
import by.academy.domain.hibernate.HibernateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.LongStream;

public interface UserSpringDataRepository extends
        CrudRepository<HibernateUser, Long>, JpaRepository<HibernateUser, Long>,
        PagingAndSortingRepository<HibernateUser, Long> {
    List<HibernateUser> findByIdAndGender(Long id, Gender gender);

    List<HibernateUser> findByCredentialsLogin(String login);

//    @Query(value = "select u from HibernateUser u")
//    List<HibernateUser> findByHQLQuery();
//
//    @Query(value = "select * from carshop.users", nativeQuery = true)
//    List<HibernateUser> findByHQLQueryNative();
//
//    @Query(value = "select u from HibernateUser u where u.userLogin = :login and u.userName = :userName")
//    List<HibernateUser> findByHQLQuery(String login, @Param("userName") String name);
//
//    @Query("select u.id, u.userName from HibernateUser u")
//    List<Object[]> getPartsOfUser();

    @Modifying
    @Query(value = "insert into training_records_schema.l_role_user(user_id, role_id) values (:user_id, :role_id)", nativeQuery = true)
    int createRoleRow(@Param("user_id") Long userId, @Param("role_id") Long roleId);

}
package by.academy.repository;

import by.academy.domain.User;

import java.util.Map;

public interface UserRepositoryInterface extends CRUDRepository<Long, User> {
Map<String,String> getUserStats();
}

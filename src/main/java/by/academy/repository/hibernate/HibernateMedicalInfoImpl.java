package by.academy.repository.hibernate;

import by.academy.domain.hibernate.HibernateMedicalInfo;
import by.academy.domain.hibernate.HibernateUser;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@RequiredArgsConstructor
public class HibernateMedicalInfoImpl implements HibernateMedicalInfoInterface{

   private final SessionFactory sessionFactory;

    @Override
    public HibernateMedicalInfo findById(Long id) {
        return null;
    }

    @Override
    public Optional<HibernateMedicalInfo> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public List<HibernateMedicalInfo> findAll() {
        try (Session session = sessionFactory.openSession()) {

            return session.createQuery("select hb from HibernateMedicalInfo hb", HibernateMedicalInfo.class).getResultList();
        }
    }

    @Override
    public List<HibernateMedicalInfo> findAll(int limit, int offset) {
        return null;
    }

    @Override
    public HibernateMedicalInfo create(HibernateMedicalInfo object) {
        return null;
    }

    @Override
    public HibernateMedicalInfo update(HibernateMedicalInfo object) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}

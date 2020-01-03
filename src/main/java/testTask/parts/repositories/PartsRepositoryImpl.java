package testTask.parts.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import testTask.parts.entities.Part;

import java.util.List;

@Repository
public class PartsRepositoryImpl implements PartsRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Part> allParts(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Part").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    @Transactional
    public List<Part> allPartsSortByNeed(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Part ORDER BY needed DESC").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    @Transactional
    public List<Part> allPartsSortByUtility(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Part ORDER BY needed").setFirstResult(10 * (page - 1)).setMaxResults(10).list();
    }

    @Override
    @Transactional
    public int partsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count (*) from Part ", Number.class).getSingleResult().intValue();
    }

    @Override
    @Transactional
    public int numberOfComputers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select min(amount) from Part  where needed = true", Number.class).getSingleResult().intValue();
    }

    @Override
    @Transactional
    public void add(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(part);
    }

    @Override
    @Transactional
    public void edit(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.update(part);
    }

    @Override
    @Transactional
    public void delete(Part part) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(part);
    }

    @Override
    @Transactional
    public Part getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Part.class, id);
    }

    @Override
    @Transactional
    public List<Part> getByName(String query) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Part where title = :queryParam").setParameter("queryParam", query).list();
    }
}

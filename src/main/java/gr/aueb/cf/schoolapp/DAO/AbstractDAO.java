package gr.aueb.cf.schoolapp.DAO;

import gr.aueb.cf.schoolapp.model.IdentifiableEntity;
import gr.aueb.cf.schoolapp.service.util.JPAHelper;
import jakarta.persistence.EntityManager;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @param <T>
 */
public abstract class AbstractDAO<T extends IdentifiableEntity> implements IGenericDAO<T> {

    private Class<T> persistenceClass;

    public AbstractDAO() {

    }

    public Class<T> getPersistenceClass() {
        return persistenceClass;
    }

    public void setPersistenceClass(Class<T> persistenceClass) {
        this.persistenceClass = persistenceClass;
    }

    @Override
    public Optional<T> insert(T t) {
        EntityManager em = getEntityManager();
        em.persist(t);
        return Optional.of(t);
    }

    @Override
    public Optional<T> update(T t) {
        EntityManager em = getEntityManager();
        Optional<T> updated = getById(t.getId());
        if (updated.isPresent()) {
            em.merge(t);
            return Optional.of(t);
        }
        return Optional.empty();
    }

    @Override
    public void delete(Object id) {
        EntityManager em = getEntityManager();
        Optional<T> toDelete = getById(id);
        toDelete.ifPresent(em::remove);
    }

    @Override
    public Optional<T> getById(Object id) {
        EntityManager em = getEntityManager();
        return Optional.ofNullable(em.find(persistenceClass, id));
    }

    @Override
    public List<T> getAll() {
        return getByCriteria(getPersistenceClass(), Collections.emptyMap());
    }

    @Override
    public List<? extends T> getByCriteria(Map<String, Object> criteria) {
        return List.of();   // to do
    }

    @Override
    public <K extends T> List<K> getByCriteria(Class<K> clazz, Map<String, Object> criteria) {
        return List.of();   // to do
    }

    public EntityManager getEntityManager() {
        return JPAHelper.getEntityManager();
    }
}

package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;

public class VaxRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * This method will get the current session, and get the supportStaff by the given dni.
     * @param dni
     * @return Optional SupportStaff
     */
    public SupportStaff getSupportStaffByDni(String dni) {
        SupportStaff supportStaff;
        try {
            Session session = this.sessionFactory.getCurrentSession(); // Trae o crea sesion activa
            supportStaff = (SupportStaff) session.createQuery("FROM SupportStaff WHERE Dni = :dni").setParameter("dni", dni).uniqueResult();
        } catch (Exception e) {
            return null;
        }
        return supportStaff;
    }

    /**
     * This method will update a given object.
     * If the object do not exist in the database, it will throw an exception.
     * @param objectToUpdate
     * @return ObjectToUpdate
     * @throws VaxException
     */
    public Object update(Object objectToUpdate) throws VaxException {
        try {
            Session session = this.sessionFactory.getCurrentSession(); // Trae o crea sesion activa
            session.update(objectToUpdate);
        } catch (Exception e) {
            throw new VaxException("SOMETHING WENT WRONG"); // TODO: esto
        }
        return objectToUpdate;
    }

    /**
     * This method will save any given object.
     * If the table do not exist it will throw an exception.
     * @param objectToSave
     * @throws VaxException
     */
    public void save(Object objectToSave) throws VaxException {
        try {
            Session session = this.sessionFactory.getCurrentSession(); // Trae o crea sesion activa
            session.save(objectToSave);
            session.flush();
        } catch (Exception e) {
            Throwable t = e.getCause();
            while ((t != null) && !(t instanceof ConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof ConstraintViolationException) {
                throw new VaxException("Constraint Violation");
            } else {
                throw new VaxException("SOMETHING WENT WRONG"); // TODO: esto
            }
        }
    }
}

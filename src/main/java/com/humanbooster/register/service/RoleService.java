package com.humanbooster.register.service;

import com.humanbooster.register.models.Role;
import com.humanbooster.register.models.User;
import com.humanbooster.register.utils.HibernateUtils;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class RoleService {

    public Role getByName(String role) {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Role roleObject = session.createQuery("FROM Role r WHERE r.roleName = :role", Role.class)
                .setParameter("role", role)
                .getSingleResult();

        tx.commit();
        session.close();

        return roleObject;
    }


}

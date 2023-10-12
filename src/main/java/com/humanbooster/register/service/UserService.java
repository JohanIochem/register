package com.humanbooster.register.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.humanbooster.register.models.User;
import com.humanbooster.register.utils.HibernateUtils;

import java.util.List;

public class UserService {
    private RoleService roleService;

    public UserService() {
        this.roleService = new RoleService();
    }

    public List<User> getUserByEmail(String email) {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<User> users = session.createQuery("FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();

        tx.commit();
        session.close();

        return users;
    }


    public void registerUser(User user) {
        SessionFactory sf = HibernateUtils.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();

        user.addRole(this.roleService.getByName("USER"));

        session.persist(user);

        tx.commit();
        session.close();
    }
}


package com.humanbooster.register.servlet;

import java.io.*;

import com.humanbooster.register.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.validation.Validation;
import jakarta.validation.*;
import jakarta.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;


import java.util.Set;




@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {

    public Validator validator;


    public void init() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("confirmpassword");

        User user = new User(nom, prenom, email, password, confirmpassword);

        Set<ConstraintViolation<User>> errors = this.validator.validate(user, User.class);


    }

    public void destroy() {
    }
}
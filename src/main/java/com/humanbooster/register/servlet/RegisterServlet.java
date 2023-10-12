package com.humanbooster.register.servlet;

import java.io.*;

import com.humanbooster.register.models.User;
import com.humanbooster.register.service.RoleService;
import com.humanbooster.register.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.validation.Validation;
import jakarta.validation.*;
import jakarta.validation.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {

    private RoleService roleService;

    private UserService UserService;

    public Validator validator;


    public void init() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();

        this.roleService = new RoleService();
        this.UserService = new UserService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("confirmpassword");

        User user = new User(nom, prenom, email, password, confirmpassword);


        List<String> errorMessages = new ArrayList<>();



        if (user.getPassword() != null && user.getConfirmpassword() != null && user.getPassword().equals(user.getConfirmpassword())) {
            errorMessages.add("Les mots de passes ne sont pas identiques");
        }

        Set<ConstraintViolation<User>> errors = this.validator.validate(user);

        if (errors.isEmpty() && errorMessages.isEmpty()){
            this.UserService.registerUser(user);

            request.getRequestDispatcher("www.google.com").forward(request, response);

        }else{
            request.setAttribute("errorsHibernate", errors);
            request.setAttribute("errors", errorMessages);

            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }


    public void destroy() {
    }
}
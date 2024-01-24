package org.vaadin.example.security;

import com.vaadin.cdi.CdiVaadinServlet;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/VAADIN/*", "/*"})
@ServletSecurity(@HttpConstraint(rolesAllowed = "Everyone"))
public class MyServlet extends CdiVaadinServlet {
}
package com.example.laboratory3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.transaction.UserTransaction;

@WebServlet(name = "customerServlet", value = "/customer-servlet")
@PersistenceContext(unitName = "ejb")
public class HelloServlet extends HttpServlet {
    @Resource(lookup = "default")
    private UserTransaction utx;

    @PersistenceContext(unitName = "ejb")
    EntityManager em;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");

        switch (act) {
            case "/new":
                showNewCustomerForm(request, response);
                break;
            case "/addCustomer":
                addNewCustomer(request, response);
                break;
            case "/show":
                showAllCustomers(request, response);
                break;
            case "/exact":
                showExactCustomer(request, response);
                break;
            default:
                toIndex(request, response);
                break;
        }
    }

    private void showNewCustomerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);
    }

    private void addNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int zip, numbFax;
        String name, firstAddress, secondAddress, city;
        try {
            zip = Integer.parseInt(request.getParameter("zip"));
            name = request.getParameter("name");
            firstAddress = request.getParameter("firstAddress");
            secondAddress = request.getParameter("secondAddress");
            numbFax = Integer.parseInt(request.getParameter("numbFax"));
            city = request.getParameter("city");
            boolean n = name.equals("");
            if (zip != 0 && !name.equals("") && !firstAddress.equals("") && !secondAddress.equals("") && numbFax != 0 && !city.equals("")) {
                try {
                    utx.begin();
                    Customer testUser = new Customer(zip, name, firstAddress, secondAddress, numbFax, city);
                    em.persist(testUser);
                    utx.commit();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        toIndex(request, response);
    }

    private void showAllCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> allCustomers = new ArrayList<>();
        try {
            utx.begin();
            Query q = em.createQuery("SELECT c from Customer c");
            allCustomers = q.getResultList();
            utx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            toIndex(request, response);
        }
        request.setAttribute("allCustomers", allCustomers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("all.jsp");
        dispatcher.forward(request, response);
    }

    private void toIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }


    private void showExactCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Customer> allCustomers = new ArrayList<>();
        List<Customer> exactCustomers = new ArrayList<>();

        try {
            String numbFax = request.getParameter("numbFax");
            String zip = request.getParameter("zip");
            try {
                utx.begin();
                Query q = em.createQuery("SELECT c from Customer c");
                allCustomers = q.getResultList();
                utx.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            for (Customer cust : allCustomers) {
                if (Integer.toString(cust.getNumbFax()).equals(numbFax) && Integer.toString(cust.getZip()).equals(zip))
                    exactCustomers.add(cust);
            }
            if (numbFax.equals("") || zip.equals("") || exactCustomers.size() == 0) {
                String message = "NO SUCH PERSON";
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h3>" + message + "</h3>");
                out.println("</body></html>");
            } else {
                request.setAttribute("find", exactCustomers);
                RequestDispatcher dispatcher = request.getRequestDispatcher("find.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            toIndex(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
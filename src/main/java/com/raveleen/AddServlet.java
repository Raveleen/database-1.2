package com.raveleen;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rooms = Integer.parseInt(req.getParameter("rooms"));
        int area = Integer.parseInt(req.getParameter("area"));
        String district = req.getParameter("district");
        String address = req.getParameter("address");
        int price = Integer.parseInt(req.getParameter("price"));

        ApartmentList.getInstance().addApartment(rooms, area, district, address, price);

        req.getRequestDispatcher("/index.html").forward(req, resp);
    }
}

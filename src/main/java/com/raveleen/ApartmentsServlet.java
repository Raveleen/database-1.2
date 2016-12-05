package com.raveleen;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ApartmentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApartmentList apartmentList = ApartmentList.getInstance();
        List<Apartment> list;
        String smin_price = req.getParameter("min_price");
        String smax_price = req.getParameter("max_price");
        String s_rooms = req.getParameter("rooms");
        String s_district = req.getParameter("district");
        String smin_area = req.getParameter("min_area");
        String smax_area = req.getParameter("max_area");

        if ((smin_price != null) && (smax_price != null)) {
            int min_price = Integer.parseInt(smin_price);
            int max_price = Integer.parseInt(smax_price);
            list = apartmentList.getPriceList(min_price, max_price);
        } else if (s_rooms != null) {
            int rooms = Integer.parseInt(s_rooms);
            list = apartmentList.getRoomsList(rooms);
        } else if (s_district != null) {
            list = apartmentList.getDistrictList(s_district);
        } else if ((smin_area != null) && (smax_area != null)) {
            int min_area = Integer.parseInt(smin_area);
            int max_area = Integer.parseInt(smax_area);
            list = apartmentList.getAreaList(min_area, max_area);
        } else {
            list = apartmentList.getList();
        }

        System.out.println(list);

        req.setAttribute("list", list);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}

package org.moskito.demo.burgershop.burgershopejb.ui;

import org.moskito.demo.burgershop.burgershopejb.service.Category;
import org.moskito.demo.burgershop.burgershopejb.service.ShopService;
import org.moskito.demo.burgershop.burgershopejb.service.ShopableItem;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShopServlet extends HttpServlet {

    @EJB(name="ejb/shop")
    private ShopService shopService;

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        String customerId = ((String) ((HttpServletRequest) servletRequest).getSession(true)
                .getAttribute("customerId"));

        servletRequest.setAttribute("customerId", customerId);

        List<ShopableItem> items = shopService.getShopableItems();

        HashMap<Category, List<ShopItemBean>> beans = new HashMap<Category, List<ShopItemBean>>();
        for (ShopableItem item : items){
            ShopItemBean bean = new ShopItemBean();
            bean.setItem(item.getName());
            bean.setPrice(item.getPrice());

            String nicePrice = "";

            nicePrice = ""+(item.getPrice()/100);
            int centPrice = item.getPrice()-(item.getPrice()/100*100);
            nicePrice += ".";
            nicePrice += (centPrice<10) ? centPrice == 0 ? "00" : "0"+centPrice :""+centPrice;
            bean.setNicePrice(nicePrice);

            List<ShopItemBean> itemsForCategory = beans.get(item.getCategory());
            if (itemsForCategory==null){
                itemsForCategory = new ArrayList<ShopItemBean>();
                beans.put(item.getCategory(), itemsForCategory);
            }
            itemsForCategory.add(bean);
        }

        for (Category c : Category.values()){
            servletRequest.setAttribute(c.name(), beans.get(c));
        }

        servletRequest.getRequestDispatcher("/jsp/shop.jsp").forward(servletRequest, servletResponse);

    }

}

package org.moskito.demo.burgershop.burgershopejb.ui;

import org.moskito.demo.burgershop.burgershopejb.service.Category;
import org.moskito.demo.burgershop.burgershopejb.service.ShopService;
import org.moskito.demo.burgershop.burgershopejb.service.ShopableItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Collects available burger ingredients,
 * sorts it by category and passes it to shopping jsp
 */
public class ShopServlet extends HttpServlet {

    @EJB(name="ejb/shop")
    private ShopService shopService;

    private static Logger log = LoggerFactory.getLogger(ShopServlet.class);

    @Override
    protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
            throws ServletException, IOException {

        // Collecting available shopping items to this map
        // with category as key and list of ingredients as value
        HashMap<Category, List<ShopItemBean>> beans = new HashMap<>();

        List<ShopableItem> items = shopService.getShopableItems();

        log.debug("Items: "+items);

        for (ShopableItem item : items) {

            List<ShopItemBean> itemsForCategory = beans.get(item.getCategory());

            if (itemsForCategory==null){
                itemsForCategory = new ArrayList<>();
                beans.put(item.getCategory(), itemsForCategory);
            }

            itemsForCategory.add(new ShopItemBean(
                    item.getName(),
                    item.getPrice()
            ));

        }

        // Fill request attributes with shop items lists with category name as key
        for (Category c : Category.values()){
            servletRequest.setAttribute(c.name(), beans.get(c));
        }

        // Forward request to shopping page jsp
        servletRequest.getRequestDispatcher("/jsp/shop.jsp").forward(servletRequest, servletResponse);

    }

}
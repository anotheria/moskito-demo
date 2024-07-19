package org.moskito.demo.burgershop.burgershopstripped.ui;

import jakarta.servlet.http.HttpServletRequest;
import org.moskito.demo.burgershop.burgershopstripped.service.Category;
import org.moskito.demo.burgershop.burgershopstripped.service.ShopService;
import org.moskito.demo.burgershop.burgershopstripped.service.ShopableItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 16.11.13 22:22
 */
@Controller
public class ShopController {

	private static Logger log = LoggerFactory.getLogger(ShopController.class);

	@Autowired
	private ShopService service;

	@RequestMapping(value = "/shop.html")
	public String enterShop(HttpServletRequest request){

		List<ShopableItem> items = service.getShopableItems();
		log.debug("Items: "+items);

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
			request.setAttribute(c.name(), beans.get(c));
		}


		return "shop";
	}
}

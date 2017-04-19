package de.zaunberg.burgershop.ui;

import de.zaunberg.burgershop.service.Category;
import de.zaunberg.burgershop.service.ShopService;
import de.zaunberg.burgershop.service.ShopableItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 07.12.15 22:36
 */
@Controller
public class AutoBuyController {

	private static Logger log = LoggerFactory.getLogger(ShopController.class);

	@Autowired
	private ShopService service;

	private Random rnd = new Random(System.currentTimeMillis());


	@RequestMapping(value = "/auto.html")
	public String buy() {
		int numberOfBuys = rnd.nextInt(10);
		for (int i=0;i <numberOfBuys;i++) {
			String itemsToBuy[] = new String[Category.values().length];
			List<ShopableItem> items = service.getShopableItems();
			HashMap<Category, List<ShopableItem>> itemByCategoryMap = new HashMap<Category, List<ShopableItem>>();
			for (ShopableItem item : items) {

				List<ShopableItem> itemsForCategory = itemByCategoryMap.get(item.getCategory());
				if (itemsForCategory == null) {
					itemsForCategory = new ArrayList<ShopableItem>();
					itemByCategoryMap.put(item.getCategory(), itemsForCategory);
				}
				itemsForCategory.add(item);
			}

			for (Category c : Category.values()) {
				List<ShopableItem> itemsForCategory = itemByCategoryMap.get(c);
				itemsToBuy[c.ordinal()] = itemsForCategory.get(rnd.nextInt(itemsForCategory.size())).getName();

			}

			service.placeOrder(itemsToBuy);
		}

		return null;
	}

}

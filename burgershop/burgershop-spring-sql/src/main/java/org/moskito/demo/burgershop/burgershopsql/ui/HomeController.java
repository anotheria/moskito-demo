package org.moskito.demo.burgershop.burgershopsql.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 16.11.13 21:51
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/")
	public String home() {
		System.out.println("HomeController: Passing through...");
		return "index";
	}

	@RequestMapping(value = "/home.html")
	public String home2() {
		System.out.println("HomeController2: Passing through...");
		return "index";
	}

}

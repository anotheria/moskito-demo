package org.moskito.demo.recipes.restservice;

import net.anotheria.moskito.aop.annotation.Monitor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This simple resource calculates a fibonacci number.
 *
 * @author lrosenberg
 * @since 01.02.18 23:33
 */

@Monitor
@Produces(MediaType.APPLICATION_JSON)
@Path("fibonacci")
public class FibonacciResource {

	private FibonacciEngine engine = new FibonacciEngine();

	@GET
	@Path("/{order}")
	public Result calculateFibobacci(@PathParam("order") Integer order){
		int result = engine.calculate(order);
		Result ret = new Result();
		ret.setOrder(order);
		ret.setResult(result);
		return ret;
	}
}

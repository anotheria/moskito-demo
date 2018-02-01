package org.moskito.demo.recipes.restservice;

/**
 * TODO comment this class
 *
 * @author lrosenberg
 * @since 01.02.18 23:54
 */
public class Result {
	private int order;
	private int result;

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Result{" +
				"order=" + order +
				", result=" + result +
				'}';
	}
}

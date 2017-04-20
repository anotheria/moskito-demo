package org.moskito.demo.burgershop.burgershopcallexecution.ui;

import net.anotheria.moskito.core.dynamic.OnDemandStatsProducer;
import net.anotheria.moskito.core.dynamic.OnDemandStatsProducerException;
import net.anotheria.moskito.core.predefined.ServiceStats;
import net.anotheria.moskito.core.predefined.ServiceStatsFactory;
import net.anotheria.moskito.core.producers.CallExecution;
import net.anotheria.moskito.core.registry.ProducerRegistryFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Homepage controller.
 *
 * @author lrosenberg
 * @since 16.11.13 21:51
 */
@Controller
public class HomeController {

	private OnDemandStatsProducer<ServiceStats> producer;

	public HomeController(){
		producer = new OnDemandStatsProducer<ServiceStats>(HomeController.class.getSimpleName(), "controller", "web", ServiceStatsFactory.DEFAULT_INSTANCE);
		ProducerRegistryFactory.getProducerRegistryInstance().registerProducer(producer);

	}


	@RequestMapping(value = "/")
	public String home() throws OnDemandStatsProducerException{
		// For the sake of an example we show two different executions.
		CallExecution executionDefault = producer.getDefaultStats().createCallExecution();
		executionDefault.startExecution();
		CallExecution executionIndex = producer.getStats("index").createCallExecution();
		executionIndex.startExecution();
		try {
			return "index";
		}finally {
			executionDefault.finishExecution();
			executionIndex.finishExecution();
		}
	}

	@RequestMapping(value = "/home.html")
	public String home2() throws OnDemandStatsProducerException{
		// For the sake of an example we show two different executions.
		CallExecution executionDefault = producer.getDefaultStats().createCallExecution();
		executionDefault.startExecution();
		CallExecution executionHome = producer.getStats("home").createCallExecution();
		executionHome.startExecution();
		try {
			return "index";
		}finally {
			executionDefault.finishExecution();
			executionHome.finishExecution();
		}
	}

}

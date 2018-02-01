package org.moskito.demo.recipes.counter;

import net.anotheria.moskito.webui.embedded.StartMoSKitoInspectBackendForRemote;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This daemon emulates a java process which runs every minute and performs some jobs.
 *
 * @author lrosenberg
 * @since 01.02.18 13:45
 */
public class Daemon {
	public static void main(String a[]) throws Exception{

		//since we are running in now container, we need to enable moskito by hand. This is not needed in a webapp or another environment if you already have moskito running.
		StartMoSKitoInspectBackendForRemote.startMoSKitoInspectBackend(9401);

		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		//perform the task every 2 seconds.
		service.scheduleAtFixedRate(new Job(), 0, 2, TimeUnit.SECONDS);
	}
}

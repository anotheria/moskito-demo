/*
 * $Id: MonitorableAuthorizationServiceFactory.java 9840 2012-10-01 20:33:28Z another $
 * 
 * This file is part of the MoSKito software project
 * that is hosted at http://moskito.dev.java.net.
 * 
 * All MoSKito files are distributed under MIT License:
 * 
 * Copyright (c) 2006 The MoSKito Project Team.
 * 
 * Permission is hereby granted, free of charge,
 * to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), 
 * to deal in the Software without restriction, 
 * including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit 
 * persons to whom the Software is furnished to do so, 
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice
 * shall be included in all copies 
 * or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY
 * OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS 
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */	
package org.anotheria.moskitodemo.guestbook.business;

import net.anotheria.moskito.core.dynamic.MoskitoInvokationProxy;
import net.anotheria.moskito.core.predefined.ServiceStatsCallHandler;
import net.anotheria.moskito.core.predefined.ServiceStatsFactory;

public class MonitorableAuthorizationServiceFactory {
	private static IAuthorizationService instance;
	private static Object lock = new Object();
	
	public static IAuthorizationService getAuthorizationService(){
		if (instance==null){
			synchronized (lock) {
				if (instance==null)
					instance = createServiceInstance();
			}
		}
		return instance;
	}
	
	private static IAuthorizationService createServiceInstance(){
		MoskitoInvokationProxy proxy = new MoskitoInvokationProxy(
				AuthorizationServiceFactory.getAuthorizationService(),
				new ServiceStatsCallHandler(),
				new ServiceStatsFactory(),
				"service",
				"guestbook",
				IAuthorizationService.class
		);
		
		return (IAuthorizationService)proxy.createProxy();
	}
}

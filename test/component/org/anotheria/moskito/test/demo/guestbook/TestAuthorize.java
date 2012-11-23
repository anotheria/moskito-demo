/*
 * $Id: TestAuthorize.java 10145 2012-11-12 14:06:06Z another $
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
package org.anotheria.moskito.test.demo.guestbook;

import net.anotheria.moskitodemo.guestbook.business.AuthorizationServiceException;
import net.anotheria.moskitodemo.guestbook.business.AuthorizationServiceFactory;
import net.anotheria.moskitodemo.guestbook.business.BusinessConstants;
import net.anotheria.moskitodemo.guestbook.business.IAuthorizationService;
import net.anotheria.util.IOUtils;
import net.anotheria.util.IdCodeGenerator;
import net.anotheria.util.StringUtils;
import org.apache.log4j.BasicConfigurator;

public class TestAuthorize {
	
	public static void main(String a[]) throws Exception{
		BasicConfigurator.configure();
		IAuthorizationService service = AuthorizationServiceFactory.getAuthorizationService();
		
		test(service, null, false);
		test(service, "bla", false);
		test(service, IdCodeGenerator.generateCode(20), false);
		test(service, loadKey(), true);
		
	}
	
	private static void test(IAuthorizationService service, String key, boolean expected) throws AuthorizationServiceException {
		boolean result = service.keyMatches(key);
		System.out.println("Tested with key: "+key+", result: "+result+" -> "+(result==expected?"success":"FAILURE"));
	}
	
	private static String loadKey() throws Exception{
		String stored = IOUtils.readFileAtOnceAsString(BusinessConstants.getKeyFilePath());
		return StringUtils.removeChars(stored, new char[]{'\n','\r'});
	}
}

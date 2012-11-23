/*
 * $Id: TestComments.java 10145 2012-11-12 14:06:06Z another $
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

import net.anotheria.util.IdCodeGenerator;
import org.anotheria.moskitodemo.guestbook.business.ICommentService;
import org.apache.log4j.BasicConfigurator;

public class TestComments {
	public static void main(String a[]) throws CommentServiceException{
		BasicConfigurator.configure();
		ICommentService service = CommentServiceFactory.getCommentService();
		System.out.println("All comments: "+service.getComments());
		//create a comment
		Comment c = service.createComment();
		c.setEmail("foo@bar.com");
		c.setFirstName(IdCodeGenerator.generateCode(5));
		c.setLastName(IdCodeGenerator.generateCode(7));
		c.setText(IdCodeGenerator.generateCode(300));
		service.updateComment(c);
		System.out.println("added");
		System.out.println("All comments: "+service.getComments());
		
	}
}

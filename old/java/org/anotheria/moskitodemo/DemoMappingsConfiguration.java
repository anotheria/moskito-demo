package org.anotheria.moskitodemo;

import net.anotheria.maf.action.ActionForward;
import net.anotheria.maf.action.ActionMappings;
import net.anotheria.maf.action.ActionMappingsConfigurator;
import org.anotheria.moskitodemo.counter.action.PaymentAction;
import org.anotheria.moskitodemo.guestbook.presentation.action.AuthorizeUserAction;
import org.anotheria.moskitodemo.guestbook.presentation.action.CreateCommentAction;
import org.anotheria.moskitodemo.guestbook.presentation.action.DeleteCommentAction;
import org.anotheria.moskitodemo.guestbook.presentation.action.NewCommentAction;
import org.anotheria.moskitodemo.guestbook.presentation.action.ShowCommentAction;
import org.anotheria.moskitodemo.guestbook.presentation.action.ShowCommentsAction;
import org.anotheria.moskitodemo.threshold.presentation.action.EmulateAverageRequestsAction;
import org.anotheria.moskitodemo.threshold.presentation.action.EmulateRequestsAction;
import org.anotheria.moskitodemo.usecases.fibonacci.presentation.action.FibonacciCalculatorAction;
import org.anotheria.moskitodemo.usecases.qe.presentation.SolveQEAction;

public class DemoMappingsConfiguration implements ActionMappingsConfigurator{
	
	@Override public void configureActionMappings(ActionMappings mappings){

		mappings.addMapping("gbookShowComments", ShowCommentsAction.class,
				new ActionForward("success", "/org/anotheria/moskitodemo/guestbook/presentation/jsp/Comments.jsp")
		);
		
		mappings.addMapping("gbookShowComment", ShowCommentAction.class,
				new ActionForward("success", "/org/anotheria/moskitodemo/guestbook/presentation/jsp/Comment.jsp")
		);

		mappings.addMapping("gbookDeleteComment", DeleteCommentAction.class,
				new ActionForward("success", "/org/anotheria/moskitodemo/guestbook/presentation/jsp/Comments.jsp")
		);
		mappings.addMapping("gbookNewComment", NewCommentAction.class,
				new ActionForward("success", "/org/anotheria/moskitodemo/guestbook/presentation/jsp/NewComment.jsp")
		);
		mappings.addMapping("gbookCreateComment", CreateCommentAction.class,
				new ActionForward("success", "/org/anotheria/moskitodemo/guestbook/presentation/jsp/Message.jsp")
		);
		mappings.addMapping("gbookAuthorize", AuthorizeUserAction.class,
				new ActionForward("success", "/org/anotheria/moskitodemo/guestbook/presentation/jsp/Message.jsp")
		);
		
		mappings.addMapping("solveQE", SolveQEAction.class,
				new ActionForward("success", "/org/anotheria/moskitodemo/usecases/qe/presentation/jsp/QE.jsp")
		);
		mappings.addMapping("fibonacci", FibonacciCalculatorAction.class,
				new ActionForward("success", "/org/anotheria/moskitodemo/usecases/fibonacci/presentation/jsp/Success.jsp"),
				new ActionForward("dialog", "/org/anotheria/moskitodemo/usecases/fibonacci/presentation/jsp/Dialog.jsp")
		);
		mappings.addMapping("thresholdsTR", EmulateRequestsAction.class,
				new ActionForward("success", "/org/anotheria/moskitodemo/threshold/presentation/jsp/Success.jsp")
		);
		mappings.addMapping("thresholdsAVG", EmulateAverageRequestsAction.class,
				new ActionForward("success", "/org/anotheria/moskitodemo/threshold/presentation/jsp/Success.jsp")
		);

		mappings.addMapping("paymentTest", PaymentAction.class, (ActionForward[])null);

	}
}
 
package org.anotheria.moskitodemo.guestbook.business;

import org.anotheria.moskitodemo.guestbook.business.data.Comment;
import org.apache.log4j.BasicConfigurator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A utility class for comments clean-up (anti-spam) in offline mode.
 * @author another
 *
 */
public class CommentsCleaner {
	
	static{
		BasicConfigurator.configure();
	}
	private static ICommentService service = CommentServiceFactory.getCommentService();
	
	static final String WORDS[] = {
		"viagra",
		"levitra",
		"phentermine",
		"fluoxetine",
		"cialis",
		"tramadol",
		"adult",
		"loan",
		"sex",
		"videos",
		"diabete",
		"hydrocodone",
		"lesbian",
		"porn",
		"vicodin",
		"xenical",
		"penis",
		"erection",
		"ringtones",
		"breast",
		"sucking",
		"pussy",
		"blowjob",
		"teenies",
		"teens",
		"pharmacy",
		"fuck",
		"chat",
		"pizdayahena",
		"asphost4free",
		"lingerie",
		"vaginal",
		"topless",
		"fakes",
		"naked",
		"freewebtown.com",
		"depression",
		"cosmetic",
		"hentai",
		"bondage",
		"href=",
		"gonew@gmail.com",
	} 	;
	
	public static final Integer ZERO = 0;

	
	public static void main(String a[]) throws CommentServiceException{
		analyze();
		clean();
	}
	
	public static void clean() throws CommentServiceException{
		List<Comment> comments = new ArrayList<>(service.getComments());
        System.out.println(comments.size()+" comments to test.");
		long removed = 0;
		for (Comment c : comments){
            for (String WORD : WORDS) {
                if (doesFieldMatch(c.getFirstName(), WORD) ||
                        doesFieldMatch(c.getLastName(), WORD) ||
                        doesFieldMatch(c.getText(), WORD)) {
                    service.deleteComment(c.getId());
                    removed++;
                    break;

                }
            }
		}
		System.out.println("Removed: "+removed+" from "+comments.size());
		
	}

	private static void analyze() throws CommentServiceException{
		
		List<Comment> comments = new ArrayList<>(service.getComments());
        System.out.println(comments.size()+" comments loaded.");
		HashMap<String, Integer> statistics = new HashMap<>();

		for (Comment c : comments){
            for (String WORD : WORDS) {
                if (doesFieldMatch(c.getFirstName(), WORD) ||
                        doesFieldMatch(c.getLastName(), WORD) ||
                        doesFieldMatch(c.getText(), WORD)) {
                    Integer oldValue = statistics.get(WORD);
                    if (oldValue == null)
                        oldValue = ZERO;
                    statistics.put(WORD, oldValue + 1);
                    break;
                }
            }
		}
		//System.out.println("Statistics: "+statistics);
		int sum = 0;
        for (String word : statistics.keySet()) {
            int value = statistics.get(word);
            sum += value;
            System.out.println(word + ": " + value);
        }
		System.out.println("UNSPAMMED: "+(comments.size()-sum));
	}
	
	private static boolean doesFieldMatch(String fieldValue, CharSequence word){
		return fieldValue != null && fieldValue.toLowerCase().contains(word);
	}
}

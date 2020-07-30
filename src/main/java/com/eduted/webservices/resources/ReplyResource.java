package com.eduted.webservices.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduted.webservices.model.Reply;
import com.eduted.webservices.services.ReplyService;


@RestController
@RequestMapping("/eduted/reply")
public class ReplyResource
{
	@Autowired
	private ReplyService replyService = new ReplyService();
	
/****************************************************************/

	@GetMapping("comments/{commentId}")
	public ResponseEntity<List<Reply>> getAllRepliesForComment(@PathVariable("commentId") String commentId)
	{
		if(commentId != null)
		{
			List<Reply> list = replyService.searchReplyByComment(commentId);
			
			if(list != null)
				return new ResponseEntity<List<Reply>> (list, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Reply>> (new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
/*
	@PostMapping("profile/{profileId}/comments/{commentId}")
	public ResponseEntity<List<Reply>> makeReplyForComment(@PathVariable("profileId") String profileId, @PathVariable("commentId") String commentId, String reply)
	{
		if(reply != null)
		{
			Reply list = replyService.addReply(profileId, commentId, reply);
			
			if(list != null)
				return new ResponseEntity<List<Reply>> (list, HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Reply>> (new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
*/
}

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

import com.eduted.webservices.model.Comment;
import com.eduted.webservices.services.CommentService;

@RestController
@RequestMapping("/eduted/comment")
public class CommentResource
{
	@Autowired
	private CommentService commentService = new CommentService();
	
	
	@GetMapping("comments/{commentId}")
	public ResponseEntity<Comment> getAllCommetForPostByProfile(@PathVariable("commentId") String comment_id)
	{
		if(comment_id != null)
		{
			Comment comment = commentService.getComment(comment_id);
			
			if(comment != null)
				return new ResponseEntity<Comment>(comment, HttpStatus.OK);
			else
				return new ResponseEntity<Comment>(new Comment(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Comment>(new Comment(), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("comments/{postId}/{profileId}")
	public ResponseEntity<List<Comment>> getAllCommetForPostByProfile(@PathVariable("postId") String post_id, @PathVariable("profileId") String profile_id)
	{
		if(post_id != null && profile_id != null)
		{
			List<Comment> list = commentService.getAllComments(post_id, profile_id);
			
			if(list != null)
				return new ResponseEntity<List<Comment>>(list, HttpStatus.OK);
			else
				return new ResponseEntity<List<Comment>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Comment>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("comments/{postId}/{profileId}/{message}")
	public ResponseEntity<Comment> makeCommetOnPostByProfile(@PathVariable("postId") String post_id,
															@PathVariable("profileId") String profile_id,
															@PathVariable("message") String message)
	{
		if(post_id != null && profile_id != null)
		{
			Comment comment = commentService.saveComments(post_id, profile_id, message);
			
			if(comment != null)
				return new ResponseEntity<Comment>(comment, HttpStatus.OK);
			else
				return new ResponseEntity<Comment>(new Comment(), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Comment>(new Comment(), HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("comments/{commentId}/{status}")
	public ResponseEntity<Comment> likeCommentServie(@PathVariable("commentId") String commentId,
													@PathVariable("status") boolean status)
	{
		if(commentId != null)
		{
			Comment comment = commentService.commentLikeService(commentId, status);
			return new ResponseEntity<Comment>(comment, HttpStatus.OK);
		}
		
		return new ResponseEntity<Comment>(new Comment(), HttpStatus.NOT_FOUND);
	}
}

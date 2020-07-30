package com.eduted.webservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduted.webservices.model.Comment;
import com.eduted.webservices.model.Post;
import com.eduted.webservices.model.Profile;
import com.eduted.webservices.repositories.CommentRepository;
import com.eduted.webservices.repositories.PostRepository;
import com.eduted.webservices.repositories.ProfileRepository;

@Service
public class CommentService
{
	@Autowired
	private CommentRepository repo = null;
	
	@Autowired
	private PostRepository postRepo = null;
	
	@Autowired
	private ProfileRepository profileRepo = null;
	
	@Autowired
	private CommentRepository commentRepo = null;
	
/****************************************************************************************/
	
	public Comment getComment(String comment_id)
	{		
		if(repo.getOne(comment_id) != null)
		{
			Comment comment = repo.findByCommentId(comment_id);
			
			if(comment != null)
				return comment;
		}
		
		return new Comment();
	}

	public List<Comment> getAllComments(String post_id,String profile_id)
	{
		Post post = postRepo.getOne(post_id);
		Profile profile = profileRepo.getOne(profile_id);
		
		if(profileRepo.getOne(profile_id) != null && postRepo.getOne(post_id) != null)
		{
			List<Comment> list = repo.findByPostAndProfile(post, profile);
			
			if(list != null)
				return list;
			else
				return new ArrayList<>();
		}
		
		return new ArrayList<>();
	}	

	public Comment saveComments(String post_id, String profile_id, String message)
	{
		Post post = postRepo.getOne(post_id);
		Profile profile = profileRepo.getOne(profile_id);

		if(post != null && profile != null)
		{
			Comment comment = new Comment("cmt-" + repo.findAll().size() + 1, message, post, profile, 0, new Date());
			repo.save(comment);
						
			if(comment != null)
				return comment;
		}
		
		return new Comment();
	}
	
	public List<Comment> getAllCommentsOfPost(String post_id)
	{
		Post post = postRepo.getOne(post_id);

		if(post != null)
		{
			List<Comment> comment = repo.findByPost(post);
						
			if(comment != null)
				return comment;
		}
		
		return new ArrayList<>();
	}

	public Comment commentLikeService(String commentId, boolean status)
	{
		Comment cmt = commentRepo.getOne(commentId);
		
		if(cmt != null && status == true)
		{	
			cmt.setLikesCount(cmt.getLikesCount() + 1);
			commentRepo.save(cmt);
			
			return cmt;
		}

		return cmt;
	}
}

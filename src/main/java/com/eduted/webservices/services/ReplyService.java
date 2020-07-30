package com.eduted.webservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eduted.webservices.model.Comment;
import com.eduted.webservices.model.Profile;
import com.eduted.webservices.model.Reply;
import com.eduted.webservices.repositories.CommentRepository;
import com.eduted.webservices.repositories.ProfileRepository;
import com.eduted.webservices.repositories.ReplyRepository;

@Service
public class ReplyService
{
	private ReplyRepository replyRepo = null;
	private ProfileRepository profileRepo = null;
	private CommentRepository commentRepo = null;
	
/***********************************************************/
	
	public Reply addReply(String profile_id, String comment_id, String reply)
	{
		Profile profile = profileRepo.getOne(profile_id);
		Comment comment = commentRepo.getOne(comment_id);
		
		if(profile != null && comment != null)
		{
			Reply obj = new Reply("rpl-" + replyRepo.findAll().size() + 1, reply, comment, profile, 0, new Date());
			replyRepo.save(obj);
			
			return obj;
		}
		
		return new Reply();
	}
	
	public List<Reply> searchReplyByComment(String comment_id)
	{
		Comment comment = commentRepo.getOne(comment_id);
		
		if(comment != null)
		{
			List<Reply> list = replyRepo.findByComment(comment);
			if(list != null)
				return list;
		}
		
		return new ArrayList<>();
	}
	
	public List<Reply> searchReplyByProfile(String profile_id)
	{
		Profile profile = profileRepo.getOne(profile_id);
		
		if(profile != null)
		{
			List<Reply> list = replyRepo.findByProfile(profile);
			if(list != null)
				return list;
		}
		
		return new ArrayList<>();
	}
}

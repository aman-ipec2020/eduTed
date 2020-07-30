package com.eduted.webservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduted.webservices.model.Post;
import com.eduted.webservices.repositories.PostRepository;
import com.eduted.webservices.repositories.ProfileRepository;

@Service
public class PostService
{
	@Autowired
	private PostRepository repo = null;
	
	@Autowired
	private ProfileRepository profileRepo = null;

/*************************************************************************************************************/

	public String addNewPost(String profileId, Post post)
	{
		if(profileRepo.existsById(profileId))
		{
			System.out.println("Profile with ID : " + profileId + ", exists...[OK]");
			
			repo.save(post.setProfile(profileRepo.getOne(profileId)).setDate_time(new Date()));
			System.out.println("Post with ID : " + post.getPostId() + ", created and updated...[OK]");
			
			return "Post with ID : " + post.getPostId() + ", added successfully...[OK]";
		}
		else
			return "Profile with ID : " + profileId + ", doesn't exists...[FAILED]";
	}
	
	
	public List<Post> getAllPost()
	{
		if(repo.findAll() != null)
			return repo.findAll();
		else
			return new ArrayList<>();
	}
	
	public List<Post> getPostByProfileId(String profileId)
	{
		if(profileRepo.existsById(profileId))
		{
			List<Post> list = new ArrayList<>();
			
			for(Post obj : repo.findAll())
			{
				if(obj.getProfile().getProfileId().equals(profileId))
					list.add(obj);
			}
			
			if(list != null)
				return list;
		}
		
		return new ArrayList<>();
	}	

	public Post getPostById(String profileId, String postId)
	{
		if(repo.existsById(profileId))
		{
			if(repo.existsById(postId))
				return repo.getOne(postId);
			else
				return new Post();
		}
		
		return new Post();
	}
	
	public Post getPostById(String id)
	{
		if(repo.existsById(id))
			return repo.getOne(id);
		else
			return new Post();
	}
}

package com.eduted.webservices.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="comment_table")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Comment
{
	@Id
	private String commentId;
	
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
	@JsonIgnore
	private Post post;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
	@JsonIgnore
	private Profile profile;
	
	private int likesCount;
	
	@OneToMany(mappedBy="comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Reply> replyList;
	
	private Date dateTime;


	public Comment()	{	}
	
	public Comment(String commentId, String comment, Post post, Profile profile, int likesCount, Date dateTime)
	{
		this.commentId = commentId;
		this.comment = comment;
		this.post = post;
		this.profile = profile;
		this.likesCount = likesCount;
		this.dateTime = dateTime;
	}


	public Comment setCommentId(String commentId)		{	this.commentId = commentId;		return this;	}
	public Comment setComment(String comment)			{	this.comment = comment;			return this;	}
	public Comment setPost(Post post) 					{	this.post = post;				return this;	}
	public Comment setProfile(Profile profile) 			{	this.profile = profile;			return this;	}
	public Comment setReplyList(List<Reply> replyList)	{	this.replyList = replyList;		return this;	}
	public Comment setLikesCount(int likesCount) 		{	this.likesCount = likesCount;	return this;	}
	public Comment setdateTime(Date dateTime) 		{	this.dateTime = dateTime;		return this;	}
	

	public String getCommentId() 		{	return commentId;	}
	public String getComment() 			{	return comment;		}
	public Post getPost() 				{	return post;		}
	public Profile getProfile() 		{	return profile;		}
	public List<Reply> getReplyList()	{	return replyList;	}
	public int getLikesCount() 			{	return likesCount;	}
	public Date getdateTime() 			{	return dateTime;	}

	

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", post=" + post + ", profile=" + profile + ", likesCount="
				+ likesCount + ", dateTime=" + dateTime + "]";
	}
}
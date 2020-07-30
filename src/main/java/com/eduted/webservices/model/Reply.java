package com.eduted.webservices.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="replies_table")
//@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Reply
{
	@Id
	private String replyId;
	
	private String reply;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
	private Comment comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
	@JsonIgnore
	private Profile profile;
	
	private int likesCount;
	private Date dateTime;

	
	public Reply()	{	}

	public Reply(String replyId, String reply, Comment comment, Profile profile, int likesCount, Date dateTime)
	{
		this.replyId = replyId;
		this.reply = reply;
		this.comment = comment;
		this.profile = profile;
		this.likesCount = likesCount;
		this.dateTime = dateTime;
	}


	public void setReplyId(String replyId) 		{	this.replyId = replyId;			}
	public void setReply(String reply) 			{	this.reply = reply;				}
	public void setComment(Comment comment) 	{	this.comment = comment;			}
	public void setLikesCount(int likesCount) 	{	this.likesCount = likesCount;	}
	public void setdateTime(Date dateTime) 	{	this.dateTime = dateTime;		}
	
	public String getReplyId() 		{	return replyId;		}
	public String getReply() 		{	return reply;		}
	public Comment getComment() 	{	return comment;		}
	public int getLikesCount() 		{	return likesCount;	}
	public Date getdateTime()		{	return dateTime;	}


	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", reply=" + reply + ", comment=" + comment + ", likesCount=" + likesCount
				+ ", dateTime=" + dateTime + "]";
	}
}

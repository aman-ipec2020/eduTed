package com.eduted.webservices.model;

import java.io.Serializable;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="post_table")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Post implements Serializable
{
	private static final long serialVersionUID = -2948101947988900058L;

	@Id
	private String postId;					//	ID of Post
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
	@JsonIgnore
	private Profile profile;				//	Profile who created the Post
	
	private String video;					//	Content to be shared : Video
	
	private int likesCount;					//	No. of Likes in the Content(Video)
	private int commentCount;				//	No. of Comments in the Content(Video)
	private int shareCount;					//	No. of Shares in the Content(Video)
	private int viewCount;					//	No. of Views in the Content(Video)
	
	@Transient
	private List<Tags> tags;				//	List of Tags in the Content(Video)

	
	@OneToMany(mappedBy="post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Comment> commentList;		//	List of Comments in the Content(Video)
	
	private int reportCount;				//	No. of Reports in the Content(Video)
	
	private Date date_time;					//	Date & Time of Content(Video) Posted


	public Post()	{	}

	public Post(String postId, Profile profile, String video, int likesCount, int commentCount, int shareCount,
			int viewCount, List<Tags> tags, int reportCount, Date date_time) {
		this.postId = postId;
		this.profile = profile;
		this.video = video;
		this.likesCount = likesCount;
		this.commentCount = commentCount;
		this.shareCount = shareCount;
		this.viewCount = viewCount;
		this.tags = tags;
		this.reportCount = reportCount;
		this.date_time = date_time;
	}


	public Post setPostId(String postId) 					{	this.postId = postId;				return this;	}
	public Post setProfile(Profile profile) 				{	this.profile = profile;				return this;	}
	public Post setVideo(String video)						{	this.video = video;					return this;	}
	public Post setLikesCount(int likesCount) 				{	this.likesCount = likesCount;		return this;	}
	public Post setCommentCount(int commentCount)			{	this.commentCount = commentCount;	return this;	}
	public Post setShareCount(int shareCount) 				{	this.shareCount = shareCount;		return this;	}
	public Post setViewCount(int viewCount) 				{	this.viewCount = viewCount;			return this;	}
	public Post setTags(List<Tags> tags) 					{	this.tags = tags;					return this;	}
	public Post setCommentList(List<Comment> commentList)	{	this.commentList = commentList;		return this;	}
	public Post setReportCount(int reportCount) 			{	this.reportCount = reportCount;		return this;	}
	public Post setDate_time(Date date_time) 				{	this.date_time = date_time;			return this;	}
	
	public String getPostId() 				{	return postId;			}
	public Profile getProfile() 			{	return profile;			}
	public String getVideo() 				{	return video;			}
	public int getLikesCount() 				{	return likesCount;		}
	public int getCommentCount() 			{	return commentCount;	}
	public int getShareCount() 				{	return shareCount;		}
	public int getViewCount() 				{	return viewCount;		}
	public List<Tags> getTags() 			{	return tags;			}
	public List<Comment> getCommentList() 	{	return commentList;		}
	public int getReportCount() 			{	return reportCount;		}
	public Date getDate_time() 				{	return date_time;		}


	@Override
	public String toString() {
		return "Post [postId=" + postId + ", profile=" + profile + ", video=" + video + ", likesCount=" + likesCount
				+ ", commentCount=" + commentCount + ", shareCount=" + shareCount + ", viewCount=" + viewCount
				+ ", tags=" + tags + ", commentList=" + commentList + ", reportCount=" + reportCount + ", date_time="
				+ date_time + "]";
	}
}

package com.eduted.webservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eduted.webservices.model.Comment;
import com.eduted.webservices.model.Post;
import com.eduted.webservices.model.Profile;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String>
{
//	@Query(value="SELECT * FROM comment_table WHERE post_id=:post_id AND profile_id:profile_id", nativeQuery=true)
//	List<Comment> findCommentOnPostByProfile(@Param("post_id") Post post_id, @Param("profile_id") Profile profile_id);

	List<Comment> findByPostAndProfile(Post post, Profile profile);
	List<Comment> findByPost(Post post);
	Comment findByCommentId(String commentId);
}

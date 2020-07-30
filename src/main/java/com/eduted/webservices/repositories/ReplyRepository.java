package com.eduted.webservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.eduted.webservices.model.Comment;
import com.eduted.webservices.model.Profile;
import com.eduted.webservices.model.Reply;

@EnableJpaRepositories
public interface ReplyRepository extends JpaRepository<Reply, String>
{
	List<Reply> findByComment(Comment comment);
	List<Reply> findByProfile(Profile profile);
}

package com.example.chatdemo.repository;

import com.example.chatdemo.model.Message;
import com.example.chatdemo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface MessageRepository extends JpaRepository<Message,Long> {

    public Set<Message> findByUser(User user);


    @Query("from Message where user=?1 and id=?2")
    public Message findForUserAndMessage(User user, long messageId);

//    @Query("from Message where user=?1")
//    Page<Message> findByUserPageable(User user, Pageable pageRequest);

}

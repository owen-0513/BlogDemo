package com.owenblog.service;


import com.owenblog.entity.Comment;

import java.util.List;

/**
 * Created by owen on 2023/10/28.
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}

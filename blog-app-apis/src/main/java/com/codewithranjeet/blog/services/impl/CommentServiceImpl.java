package com.codewithranjeet.blog.services.impl;

import com.codewithranjeet.blog.entities.Comment;
import com.codewithranjeet.blog.entities.Post;
import com.codewithranjeet.blog.exceptions.ResourceNotFoundException;
import com.codewithranjeet.blog.payloads.CommentDto;
import com.codewithranjeet.blog.payloads.PostResponse;
import com.codewithranjeet.blog.repositories.CommentRepo;
import com.codewithranjeet.blog.repositories.PostRepo;
import com.codewithranjeet.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", " Post Id", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment com = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "Commmnet Id", commentId));
        this.commentRepo.delete(com);
    }
}

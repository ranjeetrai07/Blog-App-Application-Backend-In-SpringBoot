package com.codewithranjeet.blog.services;

import com.codewithranjeet.blog.payloads.PostDto;
import com.codewithranjeet.blog.payloads.PostResponse;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface PostService {

    //create post
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryIds);

    //update
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete post
    void deletePost(Integer postId);

    //get all post
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    //get single user
    PostDto getPostById(Integer postId);

    //get all post by category
    List<PostDto> getPostsByCategory(Integer category);

    //get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    //search post
    List<PostDto> searchPosts(String keywords);

}

package blog.services;

import blog.models.Post;

import java.util.List;

/**
 * Services hold the business logic. Often just call some repository method.
 * Example: create new post / show a post for deleting / delete post.
 * Services may have several implementations: DB based or stub based.
 * */

public interface IPostService { //this will provide the business logic for working with posts in the blog system

    List<Post> findAll();
    List<Post> findLatestFive();
    Post findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);

    // IPostService interface provides all the functionality about posts that is needed for the blog system
}

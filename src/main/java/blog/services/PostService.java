package blog.services;

import blog.model.Post;

import java.util.List;

public interface PostService {

    Post create(Post post);

    List<Post> findAll();

    List<Post> findFirstThreePosts();

    Post findById(Long id);

    Post editPost(Post post);

    void deleteById(Long id);
}

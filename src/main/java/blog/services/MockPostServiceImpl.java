package blog.services;

import blog.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockPostServiceImpl implements PostService {

    private final List<Post> posts = new ArrayList<Post>();

    public MockPostServiceImpl() {
        posts.add(new Post(1L, "This is test Blog 1", "Test blog can be used for real world problems 1"));
        posts.add(new Post(2L, "This is test Blog 2", "Test blog can be used for real world problems 2"));
        posts.add(new Post(3L, "This is test Blog 3", "Test blog can be used for real world problems 3"));
        posts.add(new Post(4L, "This is test Blog 4", "Test blog can be used for real world problems 4"));
        posts.add(new Post(5L, "This is test Blog 5", "Test blog can be used for real world problems 5"));
    }

    @Override
    public Post create(Post post) {
        return null;
    }

    @Override
    public List<Post> findAll() {
        return this.posts;
    }

    @Override
    public List<Post> findFirstThreePosts() {
        return this.posts.subList(0, 2);
    }

    @Override
    public Post findById(Long id) {
        return null;
    }

    @Override
    public Post editPost(Post post) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}

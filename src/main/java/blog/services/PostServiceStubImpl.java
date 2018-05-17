package blog.services;

import blog.models.Post;
import blog.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 *  stub (sample data, stored in the memory) for the PostService.
 *  PostServiceStubImpl will hold the posts in a List<Post> collection
 *  and the service methods will be easy to implement
 * */

@Service
public class PostServiceStubImpl implements IPostService{

    // some posts for testing... no H2 database though

    private List<Post> posts = new ArrayList<Post>(){{
        add(new Post(1L,"This is it, post zero","<p>make a post</p><p>then make some more</p>",
                new User(9L,"den",null)));
        add(new Post(2L,"First post... sort of",
                "Not much to say, or write:<p><li>line 1</li><li>line 2</li></p>",
                new User(10L,"fox","Deniss Ciganovs")));
        add(new Post(3L,"Second rule","<p>you do not talk about Fight club</p>",
                new User(11L,"Tyler","Tyler Durden")));
        add(new Post(4L,"Third Post","<p>Who wants to be King?!</p>",
                new User(12L,"king Ragnar","Ragnar Lodbrok")));
        add(new Post(5L,"Forth Post",
                "<p>As I always say, keep your friends rich, and your enemies rich, and then find out which is which</p>",
                new User(13L,"Ultron",null)));
        add(new Post(6L,"Fifth Post","<p>I have something to say...</p>",null));
    }};


    //--------------- implemented methods -------------------------------
    @Override
    public List<Post> findAll() {
        return this.posts;
    }

    @Override
    public List<Post> findLatestFive() {
        return this.posts.stream().sorted((a,b)->b.getDate().compareTo(a.getDate()))
                .limit(5).collect(Collectors.toList());
    }

    @Override
    public Post findById(Long id) {
        return this.posts.stream().filter(p-> Objects.equals(p.getId(),id)).findFirst().orElse(null);
    }

    @Override
    public Post create(Post post) {
        post.setId(this.posts.stream().mapToLong(p->p.getId()).max().getAsLong()+1);
        this.posts.add(post);
        return post;
    }

    @Override
    public Post edit(Post post) {
        for (int i=0; i<this.posts.size(); i++){
            if (Objects.equals(this.posts.get(i).getId(),post.getId())){
                this.posts.set(i,post);
                return post;
            }
        }
        throw new RuntimeException("There is no such post in existence: " + post.getId());
    }

    @Override
    public void deleteById(Long id) {
        for (int i=0; i<this.posts.size();i++){
            if (Objects.equals(this.posts.get(i).getId(),id)){
                this.posts.remove(i);
                return;
            }
        }
        throw new RuntimeException("No dice on that post: " + id);
    }
    //-------------------------------------------------------------------
}

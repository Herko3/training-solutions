package week15.d03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostFinder {

    private List<Post> posts;

    public PostFinder(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> findPosts(String user) {
        List<Post> before = posts.stream()
                .filter(p -> p.getPublishedAt().isBefore(LocalDate.now()))
                .filter(Post::isContentAndTitleExist)
                .filter(Post::isNotDeleted)
                .collect(Collectors.toList());

        List<Post> after = posts.stream()
                .filter(p -> p.getPublishedAt().isAfter(LocalDate.now()))
                .filter(p -> p.getOwner().equals(user))
                .filter(Post::isContentAndTitleExist)
                .filter(Post::isNotDeleted)
                .collect(Collectors.toList());
        before.addAll(after);
        return before;

    }

    public List<Post> getPosts() {
        return posts;
    }
}

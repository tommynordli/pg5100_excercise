import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Tommy on 08/09/2016.
 */

@NamedQueries({
        @NamedQuery(name = Post.GET_SUM_POSTS_NORWAY, query = "select sum(p.id) from Post p where p.author.address.country = 'Norway'")
})

@Entity
public class Post {

    public static final String GET_SUM_POSTS_NORWAY = "GET_SUM_POSTS_NORWAY";

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String text;

    private Date createdAt = new Date();

    private Date updatedAt = new Date();

    @OneToMany
    private List<Vote> votes;

    @OneToMany
    private List<Comment> comments;

    @ManyToOne
    private User author;

    public Post(){}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        updated();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        updated();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void updated(){
        updatedAt = new Date();
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void addVote(Vote vote){
        votes.add(vote);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
        updated();
    }
}

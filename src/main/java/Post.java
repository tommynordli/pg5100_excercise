import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Tommy on 08/09/2016.
 */

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long postId;

    private String title;
    private Long authorId;
    private String text;
    private Date createdAt;
    private Date updatedAt;

    // Lists with userIDs who up- or downvoted
    private List<Long> upVotes;
    private List<Long> downVotes;

    @Embedded
    private List<Comment> comments;

    public Post(){}

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Long> getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(List<Long> upVotes) {
        this.upVotes = upVotes;
    }

    public List<Long> getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(List<Long> downVotes) {
        this.downVotes = downVotes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

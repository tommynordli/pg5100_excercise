import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tommy on 12/09/2016.
 */

@Entity
public class Vote {

    public enum State{UP, DOWN}

    @Id
    @GeneratedValue
    private Long id;

    private State state;

    @ManyToOne
    private User user;

    private Date createdAt = new Date();

    private Date updatedAt = new Date();

    public Vote(){}

    public Long getId() {
        return id;
    }

    public State getState(){
        return state;
    }

    public User getUser() {
        return user;
    }

    public void setState(State state){
        this.state = state;
        updated();
    }

    public void setUser(User user) {
        this.user = user;
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

    public boolean isUp(){
        if (state == State.UP) return true;
        else return false;
    }

    public boolean isDown(){
        if (state == State.DOWN) return true;
        else return false;
    }
}

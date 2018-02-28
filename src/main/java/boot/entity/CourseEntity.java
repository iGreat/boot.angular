package boot.entity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "t_course")
public class CourseEntity {
    private Long id;
    private String name;
    private Set<ScoreEntity> scores;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "course")
    public Set<ScoreEntity> getScores() {
        return scores;
    }

    public void setScores(Set<ScoreEntity> scores) {
        this.scores = scores;
    }
}

package boot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "t_course")
public class CourseEntity {
    private UUID id;
    private String name;
    private Set<ScoreEntity> scores;

    @Id
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

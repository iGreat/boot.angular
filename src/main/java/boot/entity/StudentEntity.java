package boot.entity;

import boot.common.Gender;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "t_student")
public class StudentEntity {
    private UUID id;
    private String name;
    private Integer age;
    private Gender gender;
    private List<ScoreEntity> scores;

    @Id
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(nullable = false, length = 150)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Enumerated
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @OneToMany(mappedBy = "student")
    public List<ScoreEntity> getScores() {
        return scores;
    }

    public void setScores(List<ScoreEntity> scores) {
        this.scores = scores;
    }
}

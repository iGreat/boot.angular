package schoolApp.entity;

import schoolApp.common.enums.Gender;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "t_student")
public class Student {
    private UUID id;
    private int age;
    private String name;
    private Gender gender;

    @Id
    @Column(nullable = false, columnDefinition = "binary(16)")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(nullable = false, columnDefinition = "int(2)")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(nullable = false, length = 150)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

package schoolApp.domain;

import schoolApp.common.enums.Gender;

import java.io.Serializable;
import java.util.UUID;

public class StudentDto implements Serializable {
    private UUID id;
    private int age;
    private String name;
    private Gender gender;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

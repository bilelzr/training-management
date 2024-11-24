package tn.pi.trainermanagement.tools.dtos;

import lombok.Builder;
import tn.pi.trainermanagement.entities.Gender;
import tn.pi.trainermanagement.entities.Level;
import tn.pi.trainermanagement.entities.Status;

@Builder
public class TrainerDto {

    private long trainerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private long age;
    private String profession;
    private String department;
    private Level level;
    private Gender gender;
    private Status status;

    public TrainerDto() {
    }

    public TrainerDto(long trainerId, String firstName, String lastName, String email, String phone, long age, String profession, String department, Level level, Gender gender, Status status) {
        this.trainerId = trainerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.profession = profession;
        this.department = department;
        this.level = level;
        this.gender = gender;
        this.status = status;
    }

    public long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(long trainerId) {
        this.trainerId = trainerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

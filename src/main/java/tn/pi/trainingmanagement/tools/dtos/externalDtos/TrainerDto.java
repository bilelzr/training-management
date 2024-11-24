package tn.pi.trainingmanagement.tools.dtos.externalDtos;

import lombok.Builder;


public class TrainerDto {

    private long trainerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private long age;
    private String profession;
    private String department;
    private String level;
    private String gender;
    private String status;

    public TrainerDto() {
    }


    public TrainerDto(String status, String gender, String level, String department, String profession, long age, String phone, String email, String lastName, String firstName, long trainerId) {
        this.status = status;
        this.gender = gender;
        this.level = level;
        this.department = department;
        this.profession = profession;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.trainerId = trainerId;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

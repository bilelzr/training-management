package tn.pi.trainingmanagement.tools.dtos.externalDtos;

public class CandidateDto {

    private long idCandidate;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private long age;
    private String profession;
    private String gender;
    private String  status;


    public CandidateDto() {
    }

    public CandidateDto(long idCandidate, String firstName, String lastName, String email, String phone, long age, String profession, String gender, String status) {
        this.idCandidate = idCandidate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.profession = profession;
        this.gender = gender;
        this.status = status;
    }

    public long getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(long idCandidate) {
        this.idCandidate = idCandidate;
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

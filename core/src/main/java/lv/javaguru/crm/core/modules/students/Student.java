package lv.javaguru.crm.core.modules.students;

import java.util.Objects;

public class Student {

    private Long id;

    private String name;

    private  String surname;

    private String phoneNumber;

    private String email;

    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student tmp = (Student) o;
        return Objects.equals(id, tmp.id) && Objects.equals(name, tmp.name) && Objects.equals(surname, tmp.surname) && Objects.equals(phone, tmp.phone) && Objects.equals(email, tmp.email) && Objects.equals(comment, tmp.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, phone, email, comment);
    }

    @Override
    public String toString() {
        return "Tmp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}

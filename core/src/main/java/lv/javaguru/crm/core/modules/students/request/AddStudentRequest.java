package lv.javaguru.crm.core.modules.students.request;


import lv.javaguru.crm.core.modules.students.domain.Student;

public class AddStudentRequest {


    private Student student;

    public AddStudentRequest(Student student) {
        this.student = student;
    }
}

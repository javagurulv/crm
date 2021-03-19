package lv.javaguru.crm.core.modules.courses.requests;

import lombok.Data;
import lv.javaguru.crm.core.modules.courses.domain.DayOfWeek;
import lv.javaguru.crm.core.modules.teachers.domain.Teacher;

import java.util.Date;

@Data
public class AddCourseRequest {

    private String name;
    private String courseType;
    private Date startDate;
    private Date endDate;
    private String dayOfWeek;
    private Date startTime;
    private Date endTime;
    private Date openClassDate;
    private Date openClassStartTime;
    private Date openClassEndTime;
    private Teacher teacher;
}
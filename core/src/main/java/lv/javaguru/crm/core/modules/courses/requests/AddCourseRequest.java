package lv.javaguru.crm.core.modules.courses.requests;

import lombok.Data;
import lv.javaguru.crm.core.domain.Teacher;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddCourseRequest {

    private String name;
    private String courseType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate openClassDate;
    private LocalTime openClassStartTime;
    private LocalTime openClassEndTime;
    private String teacher;

}

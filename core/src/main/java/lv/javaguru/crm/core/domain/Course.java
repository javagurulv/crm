package lv.javaguru.crm.core.domain;

import lombok.Data;
import javax.persistence.*;
import java.time.*;

@Entity
@Data
@Table(name = "courses", schema = "javaguru_crm")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "course_type", nullable = false)
    private String courseType;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @Column(name = "day_of_week", nullable = false)
    private String dayOfWeek;
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;
    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;
    @Column(name = "open_class_date")
    private LocalDate openClassDate;
    @Column(name = "open_class_start_time")
    private LocalTime openClassStartTime;
    @Column(name = "open_class_end_time")
    private LocalTime openClassEndTime;
    @Column(name = "teacher")
    private Teacher teacher;

}

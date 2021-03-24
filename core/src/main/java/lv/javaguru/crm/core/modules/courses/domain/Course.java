package lv.javaguru.crm.core.modules.courses.domain;

import lombok.Data;
import lv.javaguru.crm.core.modules.teachers.domain.Teacher;

import javax.persistence.*;
import java.util.Date;

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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Column(name = "day_of_week", nullable = false)
    private String dayOfWeek;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time", nullable = false)
    private Date startTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time", nullable = false)
    private Date endTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "open_class_date")
    private Date openClassDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "open_class_start_time")
    private Date openClassStartTime;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "open_class_end_time")
    private Date openClassEndTime;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
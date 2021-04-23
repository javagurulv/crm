package lv.javaguru.crm.core.modules.courses.domain;

import lombok.Data;
import lv.javaguru.crm.core.modules.teachers.domain.Teacher;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "courses", schema = "javaguru_crm")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Field [Course title] may not be empty")
    @Column(name = "course_title", nullable = false)
    private String title;
    @NotBlank(message = "Field [Course type] may not be empty")
    @Column(name = "course_type", nullable = false)
    private String courseType;
    @NotBlank(message = "Field [Course start date] may not be empty")
    @Column(name = "course_start_date", nullable = false)
    private String startDate;
    @NotBlank(message = "Field [Course end date] may not be empty")
    @Column(name = "course_end_date", nullable = false)
    private String endDate;
    @NotNull(message = "Field [Course day week] may not be empty")
    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek dayOfWeek;
    @NotBlank(message = "Field [Course start time] may not be empty")
    @Column(name = "course_start_time", nullable = false)
    private String startTime;
    @NotBlank(message = "Field [Course end time] may not be empty")
    @Column(name = "course_end_time", nullable = false)
    private String endTime;
    @Column(name = "open_class_date")
    private String openClassDate;
    @Column(name = "open_class_start_time")
    private String openClassStartTime;
    @Column(name = "open_class_end_time")
    private String openClassEndTime;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
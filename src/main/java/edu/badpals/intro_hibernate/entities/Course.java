package edu.badpals.intro_hibernate.entities;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcourse")
    private Long id;

    @NotNull
    @Column(name = "description",length = 100)
    private String description;

    @NotNull
    @Column(name = "begindate",columnDefinition = "DATE DEFAULT (CURRENT_DATE) NOT NULL")
    private LocalDate beginDate;

    @Nullable
    @Column(name="enddate")
    private LocalDate endDate;

    public Course() {
        this.beginDate = LocalDate.now();
    }

    public Course(String description) {
        this.description = description;
        this.beginDate = LocalDate.now();
    }

    public Course(String description, LocalDate beginDate, LocalDate endDate) {
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

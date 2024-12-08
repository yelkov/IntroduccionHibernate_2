package edu.badpals.intro_hibernate.entities;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="students",schema = "school")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_STUDENT")
    @SequenceGenerator(name="SEQ_STUDENT",initialValue=1,allocationSize=1)
    @Column(name="IDSTUDENT",nullable=false)
    private Long id;

    @Column(name="name",nullable = false)
    @NotNull
    private String name;

    @Column(name="identification",nullable = false)
    @NotNull
    private String dni;

    @Column(name="phone",nullable = false)
    @NotNull
    private String phone;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name="students_courses",
                joinColumns = @JoinColumn(name="idstudent"),
                inverseJoinColumns = @JoinColumn(name="idcourse"))
    private List<Course> courses = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idcard")
    private Card card;

    public Student() {
    }

    public Student(String name, String dni, String phone) {
        this.name = name;
        this.dni = dni;
        this.phone = phone;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        if(!courses.contains(course)){
            courses.add(course);
            course.getStudents().add(this);
        }
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

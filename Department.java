#university-database-jpa
package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int deptId;
    
    @Column(name = "dept_name", length = 50)
    private String deptName;
    
    @Column(name = "location", length = 100)
    private String location;
    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Professor> professors;
    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses;
    
    // Default constructor
    public Department() {}
    
    // Constructor with all fields
    public Department(String deptName, String location) {
        this.deptName = deptName;
        this.location = location;
    }
    
    // Getters and Setters
    public int getDeptId() {
        return deptId;
    }
    
    public String getDeptName() {
        return deptName;
    }
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public List<Professor> getProfessors() {
        return professors;
    }
    
    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
    
    public List<Course> getCourses() {
        return courses;
    }
    
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

// Professor.java
package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professor")
public class Professor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private int professorId;
    
    @Column(name = "professor_name", length = 50)
    private String professorName;
    
    @Column(name = "email", length = 100)
    private String email;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;
    
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses;
    
    // Default constructor
    public Professor() {}
    
    // Constructor with all fields
    public Professor(String professorName, String email, Department department) {
        this.professorName = professorName;
        this.email = email;
        this.department = department;
    }
    
    // Getters and Setters
    public int getProfessorId() {
        return professorId;
    }
    
    public String getProfessorName() {
        return professorName;
    }
    
    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public List<Course> getCourses() {
        return courses;
    }
    
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

// Course.java
package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;
    
    @Column(name = "course_name", length = 50)
    private String courseName;
    
    @Column(name = "credits")
    private int credits;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollments;
    
    // Default constructor
    public Course() {}
    
    // Constructor with all fields
    public Course(String courseName, int credits, Department department, Professor professor) {
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.professor = professor;
    }
    
    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public Professor getProfessor() {
        return professor;
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
    
    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}

// Student.java
package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    
    @Column(name = "student_name", length = 50)
    private String studentName;
    
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
    @Column(name = "address", length = 200)
    private String address;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollments;
    
    // Default constructor
    public Student() {}
    
    // Constructor with all fields
    public Student(String studentName, LocalDate dateOfBirth, String address) {
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }
    
    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
    
    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}

// Enrollment.java
package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "enrollment")
public class Enrollment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private int enrollmentId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    
    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;
    
    @Column(name = "grade", length = 2)
    private String grade;
    
    // Default constructor
    public Enrollment() {}
    
    // Constructor with all fields
    public Enrollment(Student student, Course course, LocalDate enrollmentDate, String grade) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.grade = grade;
    }
    
    // Getters and Setters
    public int getEnrollmentId() {
        return enrollmentId;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
}

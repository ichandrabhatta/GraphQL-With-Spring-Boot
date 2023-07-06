package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "marks_obtained")
    private Integer marksObtained;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}

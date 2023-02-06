package edu.miu.cs.cs425.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequest {

    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private float cgpa;
    private LocalDate enrollmentDate;

    private Boolean isInternational;
}

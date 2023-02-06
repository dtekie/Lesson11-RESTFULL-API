package edu.miu.cs.cs425.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
@NotBlank(message = "Student Number is required")
    private String studentNumber;
    @NotBlank(message = "First Name is required")
    private String firstName;
    private String middleName;
    @NotBlank(message = "Last Name is required")
    private String lastName;
    private Float cgpa;
    //@NotBlank(message = "Enrollment Date is required")
    private LocalDate enrollmentDate;

    private Boolean isInternational;

}

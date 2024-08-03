package com.example.Student.Deto;

import lombok.*;

import java.util.List;

@Getter
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubjectDto {

    private String name;
    private String address;
    private List<SubjectDTO> subjects;

}




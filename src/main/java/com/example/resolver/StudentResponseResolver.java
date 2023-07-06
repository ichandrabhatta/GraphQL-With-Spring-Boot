package com.example.resolver;

import com.example.entity.Subject;
import com.example.enums.SubjectNameFilter;
import com.example.enums.SubjectNameFilterList;
import com.example.response.StudentResponse;
import com.example.response.SubjectResponse;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    // these are just for learning purpose not an efficient way to implement this functionality

     public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse, SubjectNameFilter subjectNameFilter){

         List<SubjectResponse> learningSubjects = new ArrayList<>();

          if (studentResponse.getStudent().getLearningSubjects() != null) {
			for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
                if(subjectNameFilter.name().equalsIgnoreCase("All")) {
                    learningSubjects.add(new SubjectResponse(subject));
                }
                if(subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
                    learningSubjects.add(new SubjectResponse(subject));
                }
			}
		}

          return learningSubjects;
     }

    public List<SubjectResponse> getLearningSubjectsByList(StudentResponse studentResponse, SubjectNameFilterList subjectNameFilterList){

        List<SubjectResponse> learningSubjects = new ArrayList<>();

        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
                for (String subjectListItem: subjectNameFilterList.getFilterList()) {
                    if (subjectListItem.equalsIgnoreCase(subject.getSubjectName())) {
                        learningSubjects.add(new SubjectResponse(subject));
                    }
                }
            }
        }

        return learningSubjects;
    }

     public String getFullName(StudentResponse studentResponse) {

         return studentResponse.getFirstName() + " " + studentResponse.getLastName();
     }

}

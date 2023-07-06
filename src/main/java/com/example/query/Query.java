package com.example.query;

import com.example.request.SampleRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private StudentService studentService;

    public String firstQuery() {
        return "First Query";
    }

    public String secondQuery() {
        return "Second Query";
    }

    public String fullName(SampleRequest sampleRequest){

        return sampleRequest.getFirstName()+ "     " + sampleRequest.getLastName();
    }

    public StudentResponse getStudent(Integer id) {
        System.out.println( "Student id :  " + id);
       return new StudentResponse( studentService.getStudentById(id));

    }

}

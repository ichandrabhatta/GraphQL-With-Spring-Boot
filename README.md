# GraphQL-With-Spring-Boot
Springboot Java GraphQL app using Lombok

To build the application
```
docker-compose  build  --no-cache 
```
To run the application

```
docker-compose up --build -d   
```


Run the following from Altair to test the API end points:

```
POST http://localhost:8080/graphql
```
with Body

```
query{
 
  student( id : 1) {
    firstName
    lastName
    email
    city
    fullName
    learningSubjects(subjectNameFilter: Math) {
      id
      subjectName
      marksObtained
    }
  
  }

}
```

Query for filterList:

```
query{

student( id : 1) {
firstName
lastName
email
city
fullName
learningSubjectsByList(subjectNameFilterList: {filterList : ["Math", "Physics" ]}) {
id
subjectName
marksObtained
}
learningSubjects(subjectNameFilter: All) {
id
subjectName
marksObtained
}
}

}
```

Query with variables:

```
query student($id: Int, $subjectName: SubjectNameFilter  ) {
  student(id: $id) {
    firstName
    lastName
    email
    city
    fullName
    learningSubjectsByList(subjectNameFilterList: {filterList: ["Math", "Physics"]}) {
      id
      subjectName
      marksObtained
    }
    learningSubjects(subjectNameFilter: $subjectName) {
      id
      subjectName
      marksObtained
    }
  }
}

```

variable definition for the above:

```
{"id" : 2,
 "subjectName": "All"}

```

Mutation:

```
mutation{
  createStudent(createStudentRequest: {
    firstName: "Taylor"
    lastName: "Swift"
    city: "San Diego"
    email: "tswift@test.com"
    street: "Elm"
    subjectsLearning: [
      {subjectName: "SQL"
      marksObtained: 80},
      {subjectName: "Java"
      marksObtained: 80},
    ]
  }) 
  {id
  firstName
  lastName
  learningSubjects(subjectNameFilter: All) {
    id
    subjectName
    marksObtained
  }}
}
```




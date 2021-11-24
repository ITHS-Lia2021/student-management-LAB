# student-management-LAB

How to run Project

Setup Payara correctly and make sure that the .war artifact builds.
Use Insomnia or Postman to try out both the different endpoints and the http responses!


END-POINTS-STUDENTS

      GET-ALL STUDENTS    - localhost:8080/student-management-system/api/v1/students

      GET-ONE-STUDENT-BY-ID    - localhost:8080/student-management-system/api/v1/students/{id}
      (Uses @PathParam("id") to find ID)

      GET-STUDENT-BY-LASTNAME    - localhost:8080/student-management-system/api/v1/students/lastname
      (Uses @QueryParam("lastName") to find
      students with the corresponding lastname)

      POST-CREATE-STUDENT    - localhost:8080/student-management-system/api/v1/students

      DELETE-STUDENT-BY-ID    - localhost:8080/student-management-system/api/v1/students/{id}
      (Uses @PathParam("id") to find ID)

      PATCH-UPDATE-STUDENT-BY-ID - localhost:8080/student-management-system/api/v1/students/updatelastname/{id}
      (Uses @PathParam("id) and @QueryParam("lastName") to
      find students with the corresponding id and lastname)
     
END-POINT-TEACHERS

      Get-ALL TEACHERS - localhost:8080/student-management-system/api/v1/teachers
      
      GET-TEACHER-BY-ID - localhost:8080/student-management-system/api/v1/teachers/{id}
      (Uses @PathParam("id") to find ID)
      
      CREATE-TEACHER - localhost:8080/student-management-system/api/v1/teachers
      
      ADD-TEACHER-TO-SUBJECT - localhost:8080/student-management-system/api/v1/teachers/{teacherId}/{subjectId}

END-POINT-SUBJECTS

      GET-ALL-SUBJECTS - localhost:8080/student-management-system/api/v1/subjects
      
      CREATE-SUBJECT - localhost:8080/student-management-system/api/v1/subjects
      
      ADD-STUDENT-TO-SUBJECT - localhost:8080/student-management-system/api/v1/subjects/{studentId}/{subjectId}

Both me and KabbeJ have done everything together, but we've made some commits from both ends.
The commits shows if it's me or Kabbe that has been sharing the screen in all the steps of the project!

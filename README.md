# student-management-LAB

How to run Project

Setup Payara correctly and make sure that the .war artifact builds.
Use Insomnia or Postman to try out both the different endpoints and the http responses!


END-POINTS 

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



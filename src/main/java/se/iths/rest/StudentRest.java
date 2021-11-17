package se.iths.rest;


import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.annotation.Repeatable;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("")
    @POST
    public Response createStudent(Student student) {
        Student studentResult = studentService.createStudent(student);
        return Response.ok(studentResult).build();
    }

    @Path("{lastName}")
    @GET
    public Response getStudentByLastName(@PathParam("lastName") String lastName) {
        List<Student> foundStudent = studentService.getStudentsByLastname(lastName);
        return Response.ok(foundStudent).build();
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        return Response.ok(foundStudent).build();
    }

    @Path("")
    @GET
    public Response getAllStudents() {
        List<Student> foundStudents = studentService.getAllStudents();
        return Response.ok(foundStudents).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        studentService.deleteStudent(id);
        return Response.ok().build();
    }

    @Path("update")
    @PUT
    public Response updateStudentById(Student student) {
        Student foundStudent = studentService.updateStudent(student);
        return Response.ok(foundStudent).build();
    }

    @Path("updatelastname/{id}")
    @PATCH
    public Response updateLastName(@PathParam("id") Long id, @QueryParam("lastName") String lastName) {
        Student updatedStudent = studentService.updateLastName(id, lastName);
        return Response.ok(updatedStudent).build();
    }

}

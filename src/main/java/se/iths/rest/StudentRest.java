package se.iths.rest;


import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        //201
        if (student.getFirstName().isEmpty() || (student.getLastName().isEmpty()) || (student.getEmail().isEmpty())) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity("message: No name/email Given").type(MediaType.APPLICATION_JSON_TYPE).build());
        }
        else {
            Student studentResult = studentService.createStudent(student);
            return Response.status(201).entity(studentResult).build();
        }
    }

    @Path("")
    @GET
    public Response getStudentByLastName(@QueryParam("lastName") String lastName) {
        //302
        List<Student> foundStudent = studentService.getStudentsByLastname(lastName);
        if (foundStudent == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else {
            return Response.status(Response.Status.FOUND).entity(foundStudent).build();
        }

    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {

        Student foundStudent = studentService.findStudentById(id);
        return Response.ok(foundStudent).build();
    }



    @Path("getall")
    @GET
    public Response getAllStudents() {
        //302
        List<Student> foundStudents = studentService.getAllStudents();
        return Response.ok(foundStudents).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        //200
        studentService.deleteStudent(id);
        return Response.status(Response.Status.FOUND).entity(id).build();
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

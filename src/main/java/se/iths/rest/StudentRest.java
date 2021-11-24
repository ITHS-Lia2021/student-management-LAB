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
        if (student.getFirstName().isEmpty() || (student.getLastName().isEmpty()) || (student.getEmail().isEmpty())) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity("message: No name/email Given").type(MediaType.APPLICATION_JSON_TYPE).build());
        }
        else {
            Student studentResult = studentService.createStudent(student);
            return Response.status(201).entity(studentResult).build();
        }
    }

    @Path("lastname")
    @GET
    public Response getStudentByLastName(@QueryParam("lastName") String lastName) {
        List <Student> allStudents = studentService.getStudentsByLastname(lastName);
        if(allStudents.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Students not found!").type(MediaType.APPLICATION_JSON_TYPE).build());
        } else {
            List<Student> foundStudent = studentService.getStudentsByLastname(lastName);
            return Response.status(302).entity(foundStudent).build();
        }

    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        if(studentService.findStudentById(id) == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("ID not found!").type(MediaType.APPLICATION_JSON_TYPE).build());
        } else {
            Student foundStudent = studentService.findStudentById(id);
            return Response.status(302).entity(foundStudent).build();
        }
    }

    @Path("")
    @GET
    public Response getAllStudents() {
        if(studentService.getAllStudents().isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("COULD NOT FIND STUDENTS").type(MediaType.APPLICATION_JSON_TYPE).build());
        }
        List<Student> foundStudents = studentService.getAllStudents();
        return Response.status(302).entity(foundStudents).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {

        if(studentService.findStudentById(id) == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("ID not found!").type(MediaType.APPLICATION_JSON_TYPE).build());
        } else {
            studentService.deleteStudent(id);
            return Response.status(Response.Status.ACCEPTED).entity(id+"Student removed succesfully").type(MediaType.APPLICATION_JSON_TYPE).build();
        }

    }

    @Path("updatelastname/{id}")
    @PATCH
    public Response updateLastName(@PathParam("id") Long id, @QueryParam("lastName") String lastName) {
        if(studentService.findStudentById(id) == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("ID not found!").type(MediaType.APPLICATION_JSON_TYPE).build());
        }
        Student updatedStudent = studentService.updateLastName(id, lastName);
        return Response.status(202).entity(updatedStudent).build();
    }

}

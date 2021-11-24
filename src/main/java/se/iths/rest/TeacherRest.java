
package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Teacher;
import se.iths.service.StudentService;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;
    @Inject
    SubjectService subjectService;

    @Path("")
    @POST
    public Response createTeacher(Teacher teacher){
        if(teacher.getFirstName().isEmpty() || (teacher.getLastName().isEmpty())) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity("Message: No name given").type(MediaType.APPLICATION_JSON_TYPE).build());
        } else {
            Teacher teacherResult = teacherService.createTeacher(teacher);
            return  Response.status(201).entity(teacherResult).build();
        }
    }

    @Path("{id}")
    @GET
    public Response findTeacherById(@PathParam("id")Long id){
        if(teacherService.findTeacherById(id) == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("ID not found!").type(MediaType.APPLICATION_JSON_TYPE).build());
        } else {
            Teacher foundTeacher = teacherService.findTeacherById(id);
            return Response.status(302).entity(foundTeacher).build();
        }

    }

    @Path("")
    @GET
    public Response getAllTeachers() {
        if(teacherService.findAllTeachers().isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("COULD NOT FIND TEACHERS").type(MediaType.APPLICATION_JSON_TYPE).build());
        }
        List<Teacher> foundTeachers = teacherService.findAllTeachers();
        return Response.status(302).entity(foundTeachers).build();
    }

    @Path("{teacherId}/{subjectId}")
    @PUT
    public Response addTeacherToSubject(@PathParam("teacherId") Long teacherId,@PathParam("subjectId") Long subjectId){
        if(teacherService.findTeacherById(teacherId) == null || (subjectService.findSubjectById(subjectId)) == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("ID not found!").type(MediaType.APPLICATION_JSON_TYPE).build());
        } else {
            teacherService.addTeacherToSubject(teacherId, subjectId);
            return Response.status(201).build();
        }
    }


}



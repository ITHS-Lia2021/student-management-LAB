package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.exception.EntityNotFoundException;
import se.iths.service.StudentService;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;
    @Inject
    StudentService studentService;

    @Path("")
    @GET
    public Response getAllSubjects(){
        if(subjectService.findAllSubjects().isEmpty()) {
            throw new EntityNotFoundException("No subjects found");
        }
        List<Subject> foundSubjects = subjectService.findAllSubjects();
        return Response.status(302).entity(foundSubjects).build();
    }

    @Path("")
    @POST
    public Response createSubject(Subject subject){
        if(subject.getName().isEmpty()) {
            throw new EntityNotFoundException("No name given");
                    //WebApplicationException(Response.status(Response.Status.NOT_ACCEPTABLE)
                    //.entity("Message: No name given").type(MediaType.APPLICATION_JSON_TYPE).build());
        } else {
            Subject subjectResult = subjectService.createSubject(subject);
            return Response.status(201).entity(subjectResult).build();
        }
    }

    @Path("{studentId}/{subjectId}")
    @PUT
    public Response addStudentToSubject(@PathParam("studentId") Long studentId,@PathParam("subjectId") Long subjectId){
        if(subjectService.findSubjectById(subjectId) == null || studentService.findStudentById(studentId) == null) {
            throw new EntityNotFoundException("student or subject not found");
        } else {
            subjectService.addSubjectToStudent(studentId, subjectId);
            return Response.status(201).build();
        }

    }

}

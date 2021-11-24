package se.iths.rest;

import se.iths.entity.Subject;
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

    @Path("")
    @GET
    public Response getAllSubjects(){
        if(subjectService.findAllSubjects().isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("COULD NOT FIND STUDENTS").type(MediaType.APPLICATION_JSON_TYPE).build());
        }
        List<Subject> foundSubjects = subjectService.findAllSubjects();
        return Response.status(302).entity(foundSubjects).build();
    }

    @Path("")
    @POST
    public Response createSubject(Subject subject){
        Subject createdSubject = subjectService.createSubject(subject);
        return Response.ok(createdSubject).build();
    }

}

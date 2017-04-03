package jettyjerseyrest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("home")
public class SimpleService {

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello, world!";
    }

    @GET
    @Path("param")
    @Produces(MediaType.TEXT_PLAIN)
    public String paramMethod(@QueryParam("name") String name) {
        return "Hello, " + name;
    }

    @GET
    @Path("path/{var}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pathMethod(@PathParam("var") String name) {
        return "Hello, " + name;
    }

    @POST
    @Path("post")
    @Produces(MediaType.TEXT_HTML)
    public String postMethod() {
        return "answer from POST method";
    }

    @PUT
    @Path("/{param}")
    public Response putMsg(@PathParam("param") String msg) {
        String output = "PUT: Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }

    @DELETE
    @Path("/{param}")
    public Response deleteMsg(@PathParam("param") String msg) {
        String output = "DELETE:Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }



}
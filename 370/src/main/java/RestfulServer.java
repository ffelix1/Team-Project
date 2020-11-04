import spark.Spark;
import spark.Request;
import spark.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*  TODO:
*   1) learn how to log in on lab computers
*   2) learn how to implement this local server on the CS computers
*   3)
*   4)
* */
public class RestfulServer {

    private final Logger log = LoggerFactory.getLogger(RestfulServer.class);

    public RestfulServer() {
        this.configureRestfulApiServer();
        this.processRestfulApiRequests();
    }

    private void configureRestfulApiServer(){
        Spark.port(8080);
        System.out.println("Server configured to listen on port 8080");
    }

    private void processRestfulApiRequests(){
        Spark.get("/", this::echoRequest);
    }

    private String echoRequest(Request request, Response response){
        response.type("application/json");
        response.header("Access-Control-Allow-Origin","*");
        response.status(200); // OK
        return HttpRequesttoJson(request);
    }

    private String HttpRequesttoJson(Request request){
        return "{\n"
                + "\"attributes\":\""       + request.attributes()      + "\",\n"
                + "\"body\":\""             + request.body()            + "\",\n"
                + "\"contentLength\":\""    + request.contentLength()   + "\",\n"
                + "\"contentType\":\""      + request.contentType()     + "\",\n"
                + "\"contextPath\":\""      + request.contextPath()     + "\",\n"
                + "\"cookies\":\""          + request.cookies()         + "\",\n"
                + "\"headers\":\""          + request.headers()         + "\",\n"
                + "\"host\":\""             + request.host()            + "\",\n"
                + "\"ip\":\""               + request.ip()              + "\",\n"
                + "\"params\":\""           + request.params()          + "\",\n"
                + "\"pathInfo\":\""         + request.pathInfo()        + "\",\n"
                + "\"port\":\""             + request.port()            + "\",\n"
                + "\"protocol\":\""         + request.protocol()        + "\",\n"
                + "\"queryParams\":\""      + request.queryParams()     + "\",\n"
                + "\"requestMethod\":\""    + request.requestMethod()   + "\",\n"
                + "\"scheme\":\""           + request.scheme()          + "\",\n"
                + "\"servletPath\":\""      + request.servletPath()     + "\",\n"
                + "\"session\":\""          + request.session()         + "\",\n"
                + "\"uri\":\""              + request.uri()             + "\",\n"
                + "\"url\":\""              + request.url()             + "\",\n"
                + "\"userAgent\":\""        + request.userAgent()       + "\",\n"
                + "}";
    }

    public static void main(String[] args) {
        RestfulServer restfulServer = new RestfulServer(); // never returns!
    }

}

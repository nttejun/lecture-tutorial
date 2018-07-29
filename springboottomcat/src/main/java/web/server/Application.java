package web.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Application {

    // 톰캣 JAVA로 직접 구형
   public static void main(String[] args) throws LifecycleException{

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("/", "/");

        //서블릿 구현
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                PrintWriter writer = resp.getWriter();
                writer.println("<html><head><title>");
                writer.println("Hello tmocat");
                writer.println("</title><head>");
                writer.println("<body><h1>tomcat start</h1></body>");
            }
        };

        // 서블릿 이름
        String servletName = "tomcatServlet";

        // 서블릿 추가
        tomcat.addServlet("/", servletName, servlet);

        // 요청과 서블릿 매핑
        context.addServletMappingDecoded("/hello",servletName);

        tomcat.start();
        tomcat.getServer().await();

    }
}

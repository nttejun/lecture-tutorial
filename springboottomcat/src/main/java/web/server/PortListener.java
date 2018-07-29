package web.server;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent>{

    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent servletWebServerInitializedEvent){
        ServletWebServerApplicationContext applicationContext = servletWebServerInitializedEvent.getApplicationContext();
        // properties 설정 port로 웹 서버 실행하며 실행된 port 번호를 출력
        // application.properties 파일에 server.port = 0 으로 설정된 상태
        System.out.println(applicationContext.getWebServer().getPort());
    }
}

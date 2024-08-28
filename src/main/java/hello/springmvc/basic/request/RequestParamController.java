package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}", username);
        log.info("age = {}", age);

        response.getWriter().write("ok");
    }

    @RequestMapping("/request-param-v2")
    @ResponseBody
    public String requestParamV2(@RequestParam("username") String username,
                               @RequestParam("age") int age) {
        log.info("username = {}", username);
        log.info("age = {}", age);

        return "ok";
    }

    @RequestMapping("/request-param-v3")
    @ResponseBody
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age) {
        log.info("username = {}", username);
        log.info("age = {}", age);

        return "ok";
    }

    @RequestMapping("/request-param-v4")
    @ResponseBody
    public String requestParamV4(String username,
                                 int age) {
        log.info("username = {}", username);
        log.info("age = {}", age);

        return "ok";
    }

    @RequestMapping("/request-param-required")
    @ResponseBody
    public String requestParamRequired(@RequestParam(required = true) String username,
                                 @RequestParam(required = false) Integer age) {
        log.info("username = {}", username);
        log.info("age = {}", age);

        return "ok";
    }

    @RequestMapping("/request-param-default")
    @ResponseBody
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username,
                                       @RequestParam(required = false, defaultValue = "-1") Integer age) {
        log.info("username = {}", username);
        log.info("age = {}", age);

        return "ok";
    }

    @RequestMapping("/request-param-map")
    @ResponseBody
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username = {}", paramMap.get("username"));
        log.info("age = {}", paramMap.get("age"));

        return "ok";
    }

    @RequestMapping("/model-attribute-v1")
    @ResponseBody
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

        //HelloData helloData = new HelloData();
        //helloData.setUsername(username);
        //helloData.setAge(age);

        //log.info("username = {}", username);
        //log.info("age = {}", age);
        log.info("helloData = {}", helloData);

        return "ok";
    }

    @RequestMapping("/model-attribute-v2")
    @ResponseBody
    public String modelAttributeV2(HelloData helloData) {
        log.info("helloData = {}", helloData);

        return "ok";
    }
}

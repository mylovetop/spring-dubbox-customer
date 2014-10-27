package com.springapp.mvc.dubbox.consumer;

import com.springapp.mvc.dubbox.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by zdsoft on 14-10-27.
 */
@Controller
public class ChatController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/")
    public String chat(ModelMap modelMap){
        modelMap.put("hello", "nothing");
        if (null != demoService){
            modelMap.put("hello", demoService.sayHello());
        }

        return "hello";
    }





    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"application.xml"});
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService"); //
        String hello = demoService.sayHello(); // ִ
        System.out.println("--我是消费者");
        System.out.println(hello);

        System.in.read();
    }
}

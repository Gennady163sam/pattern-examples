package com.genius.controllers;

import com.genius.controllers.adapter.Task;
import com.genius.controllers.adapter.TaskAdapter;
import com.genius.controllers.adapter.UserRequest;
import com.genius.domain.patterns.Singleton;
import com.genius.domain.patterns.builder.PatternBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PatternController {

    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello World";
    }

    @RequestMapping("/patterns/singleton")
    @ResponseBody
    Singleton getSingleton() {
        return Singleton.getInstance();
    }

    @RequestMapping("/adapter/tasks")
    @ResponseBody
    List<Task> getTasks(@RequestParam String purpose) {
        UserRequest request = new UserRequest();
        request.setSearchPurpose(purpose);
        return TaskAdapter.getTasks(request);
    }

    @RequestMapping("/patterns/builder")
    @ResponseBody
    PatternBuilder getBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Порождающий паттерн проектирования, который позволяет создавать сложные объекты пошагово.")
                .append(" Строитель даёт возможность использовать один и тот же код строительства для получения ")
                .append("разных представлений объектов");
        return new PatternBuilder()
                .setName("Builder")
                .setDescription(stringBuilder.toString());
    }
}

package com.nexign.controllers;

import com.nexign.controllers.adapter.Task;
import com.nexign.controllers.adapter.TaskAdapter;
import com.nexign.controllers.adapter.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FirstController {

    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello World";
    }

    @RequestMapping("/adapter/tasks")
    @ResponseBody
    List<Task> getTasks(@RequestParam String purpose) {
        UserRequest request = new UserRequest();
        request.setSearchPurpose(purpose);
        return TaskAdapter.getTasks(request);
    }
}

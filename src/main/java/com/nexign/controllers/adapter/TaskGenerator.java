package com.nexign.controllers.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskGenerator {
    private final static Map<String, List> tasksMap = new HashMap<>();

    static {
        List<Task> tempList = new ArrayList();
        tempList.add(new Task());
        tasksMap.put("MY_TASKS", tempList);
    }

    public static List<Task> getTasksByPurpose(Purpose purpose) {
        if (purpose.getPriority() == Priority.LOW) {
            // TODO: Not realize
            return null;
        } else {
            return tasksMap.get(purpose.getKeyName());
        }
    }
}

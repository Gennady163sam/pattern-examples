package com.nexign.controllers.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskGenerator {
    private static final Map<String, List> tasksMap = new HashMap<>();

    public TaskGenerator() {
        throw new IllegalStateException("Utility class");
    }

    static {
        List<Task> tempList = new ArrayList();
        tempList.add(new Task());
        tasksMap.put("MY_TASKS", tempList);
    }

    public static List<Task> getTasksByPurpose(Purpose purpose) {
        if (Priority.LOW.equals(purpose.getPriority())) {
            // TODO: Not realize
            return new ArrayList<>();
        } else {
            return tasksMap.get(purpose.getKeyName());
        }
    }
}

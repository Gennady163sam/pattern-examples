package com.nexign.controllers.adapter;

import java.util.List;

public class TaskAdapter {

    private TaskAdapter() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Task> getTasks(UserRequest request) {
        Purpose purpose = new Purpose();
        purpose.setKeyName(request.getSearchPurpose());
        purpose.setPriority(Priority.MIDDLE);
        return TaskGenerator.getTasksByPurpose(purpose);
    }
}

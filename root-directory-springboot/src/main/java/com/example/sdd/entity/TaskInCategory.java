package com.example.sdd.entity;

public class TaskInCategory {
    private Integer taskCategoryId;

    private Integer taskId;

    public Integer getTaskCategoryId() {
        return taskCategoryId;
    }

    public void setTaskCategoryId(Integer taskCategoryId) {
        this.taskCategoryId = taskCategoryId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskCategoryId=").append(taskCategoryId);
        sb.append(", taskId=").append(taskId);
        sb.append("]");
        return sb.toString();
    }
}
package com.example.sdd.entity;

public class Category {
    private Integer taskCategoryId;

    private Integer courseId;

    private String categoryName;

    private String description;

    public Integer getTaskCategoryId() {
        return taskCategoryId;
    }

    public void setTaskCategoryId(Integer taskCategoryId) {
        this.taskCategoryId = taskCategoryId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskCategoryId=").append(taskCategoryId);
        sb.append(", courseId=").append(courseId);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}
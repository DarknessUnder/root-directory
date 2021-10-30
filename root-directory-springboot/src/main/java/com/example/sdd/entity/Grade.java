package com.example.sdd.entity;

public class Grade {
    private Integer courseId;

    private String dropped;

    private Integer totalGrade;

    private Integer currentGrade;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getDropped() {
        return dropped;
    }

    public void setDropped(String dropped) {
        this.dropped = dropped == null ? null : dropped.trim();
    }

    public Integer getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(Integer totalGrade) {
        this.totalGrade = totalGrade;
    }

    public Integer getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(Integer currentGrade) {
        this.currentGrade = currentGrade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseId=").append(courseId);
        sb.append(", dropped=").append(dropped);
        sb.append(", totalGrade=").append(totalGrade);
        sb.append(", currentGrade=").append(currentGrade);
        sb.append("]");
        return sb.toString();
    }
}
package com.Lesson2.HW1;

import java.util.List;

public class Route {
    private String id;
    private List<Step> steps;

    public Route(String id, List<Step> steps) {
        this.id = id;
        this.steps = steps;
    }

    public Route() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", steps=" + steps +
                '}';
    }
}

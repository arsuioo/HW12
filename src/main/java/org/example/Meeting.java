package org.example;

public class Meeting extends Task {
    private String topic;
    private String project;
    private String start;

    public Meeting(int id, String topik, String project, String start) {
        super(id);
        this.topic = topik;
        this.project = project;
        this.start = start;
    }

    public String getTopik() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }
}

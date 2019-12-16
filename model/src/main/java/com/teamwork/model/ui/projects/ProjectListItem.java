package com.teamwork.model.ui.projects;

import com.teamwork.model.response.projects.Tag;

import java.util.List;

public class ProjectListItem {

    private String companyName;
    private String description;
    private String name;
    private List<Tag> tags;

    public ProjectListItem(String companyName, String description, String name, List<Tag> tags) {
        this.companyName = companyName;
        this.description = description;
        this.name = name;
        this.tags = tags;
    }

    public ProjectListItem() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}

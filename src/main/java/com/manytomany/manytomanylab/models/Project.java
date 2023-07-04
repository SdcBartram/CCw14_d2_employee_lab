package com.manytomany.manytomanylab.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "duration")
    private int duration;

    @OneToMany
    @JsonIgnoreProperties({"project"})
    private List<Assignment> assignments;


    public Project() {
    }

    public Project(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.assignments = new ArrayList<>();
    }

    public void addAssignment(Assignment assignment){
        this.assignments.add(assignment);
    }

    public void removeAssignment(Assignment assignment){
        this.assignments.remove(assignment);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}

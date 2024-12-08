package edu.badpals.intro_hibernate.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="devops")
@PrimaryKeyJoinColumn(name = "idstudent")
public class DevOps extends Student {

    @ElementCollection
    @CollectionTable(name = "devops_tools",
    joinColumns = @JoinColumn(name="idstudent"),foreignKey = @ForeignKey(name="devops_tools_fk_idstudent"))
    @Column(name = "tool",nullable = false)
    private List<String> tools = new ArrayList();

    public DevOps() {
    }

    public DevOps(String name, String dni, String phone) {
        super(name, dni, phone);
    }

    public DevOps(List<String> tools) {
        this.tools = tools;
    }

    public List<String> getTools() {
        return tools;
    }

    public void setTools(List<String> tools) {
        this.tools = tools;
    }

    public void addHerramienta(String tool) {
        if(!this.tools.contains(tool)){
            this.tools.add(tool);
        }
    }

    @Override
    public String toString() {
        return "DevOps{" +
                "herramientas=" + tools +
                '}';
    }


}

package edu.badpals.intro_hibernate.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="developers")
@PrimaryKeyJoinColumn(name ="idstudent")
public class Developer extends Student {

    @ElementCollection
    @CollectionTable(name = "developers_languages",
    joinColumns = @JoinColumn(name = "idstudent"),foreignKey = @ForeignKey(name = "developers_languages_fk_idstudent"))
    @Column(name = "programming_language",nullable = false)
    private List<String> programmingLanguages;

    public Developer() {
    }

    public Developer(String name, String dni, String phone) {
        super(name, dni, phone);
    }

    public List<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<String> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public void addLanguage(String language) {
        if(!programmingLanguages.contains(language)){
            programmingLanguages.add(language);
        }
    }

    @Override
    public String toString() {
        return "Developer{" +
                "programmingLanguages=" + programmingLanguages +
                '}';
    }
}

package com.allstate.entities;

import com.allstate.enumerations.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="teachers")
@Data

public class Teacher {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    @Min(value=1)
    private int age;

    @Column(columnDefinition = "ENUM('MALE','FEMALE')")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    // associations ****
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<Klass> klasses;

}

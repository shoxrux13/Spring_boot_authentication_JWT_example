package com.example.exam_spring_sec.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;

import java.util.List;
import java.util.UUID;


@Entity(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book  {
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(columnDefinition = "text")
    private String description;


    @ManyToMany
    private List<AuthorBook> authors;





}

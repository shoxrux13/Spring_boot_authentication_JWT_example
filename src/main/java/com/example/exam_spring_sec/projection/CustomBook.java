package com.example.exam_spring_sec.projection;

import java.time.LocalDate;
import java.util.UUID;

public interface CustomBook {

    UUID getId();

    String getTitle();

    UUID getCoverImgId();

    LocalDate getReleaseDate();


}

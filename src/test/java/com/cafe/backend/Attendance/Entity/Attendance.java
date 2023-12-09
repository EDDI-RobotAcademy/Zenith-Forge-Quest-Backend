package com.cafe.backend.Attendance.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "members")
    private List<Object> member = new ArrayList<>();

}

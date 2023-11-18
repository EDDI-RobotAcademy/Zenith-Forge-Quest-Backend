package com.cafe.backend.Attendance.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

public class AttendanceMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;

    //참가 시간
    @Column(nullable = false, length = 50)
    private String entryTime;

    //나간 시간
    @Column(nullable = false, length = 50)
    private String exitTime;

    //누적 시간
    @Column(nullable = false, length = 50)
    private String totalTime;

    @Builder
    public AttendanceMember(Long id, String name, String email, String entryTime, String exitTime, String totalTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.totalTime = totalTime;
    }
}

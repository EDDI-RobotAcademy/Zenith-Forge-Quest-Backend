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
    private String zoomName;

    @Column(nullable = false, length = 50)
    private String zoomEmail;

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
    public AttendanceMember(Long id, String zoomName, String zoomEmail, String entryTime, String exitTime, String totalTime) {
        this.id = id;
        this.zoomName = zoomName;
        this.zoomEmail = zoomEmail;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.totalTime = totalTime;
    }
}

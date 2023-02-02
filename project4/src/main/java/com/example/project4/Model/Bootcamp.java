package com.example.project4.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bootcamps")
@Repository
public class Bootcamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Name can not be null!")
    @Size(min = 8, max = 255, message = "Name must be between 8 and 255 characters")
    @Column(columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @NotNull(message = "Start date can not be null!")
    @Temporal(TemporalType.DATE)
    @FutureOrPresent
    @Column(columnDefinition = "date", nullable = false)
    private Date startDate;

    @NotNull(message = "End date can not be null!")
    @Temporal(TemporalType.DATE)
    @FutureOrPresent
    @Column(columnDefinition = "date", nullable = false)
    private Date endDate;

    @NotNull(message = "Start time can not be null!")
    @Temporal(TemporalType.TIME)
    @Column(columnDefinition = "time", nullable = false)
    private String start_time;

    @NotNull(message = "End time can not be null!")
    @Temporal(TemporalType.TIME)
    @Column(columnDefinition = "time", nullable = false)
    private String end_time;

    @NotNull(message = "Room can not be null!")
    @Size(max = 10, message = "Room must be between 1 and 10 characters!")
    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String room;

    @NotNull(message = "Capacity can not be null!")
    @Min(value = 5, message = "Minimum capacity is 5!")
    @Column(columnDefinition = "int")
    private Integer capacity;










}



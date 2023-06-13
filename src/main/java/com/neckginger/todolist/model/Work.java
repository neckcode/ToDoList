package com.neckginger.todolist.model;

import com.neckginger.todolist.model.statuses.WorkStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Work {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private WorkStatus status;
    private String title;
    private String description;

    public Work(WorkStatus status, String title, String description){
        this.status = status;
        this.title = title;
        this.description = description;
    }
}

package com.neckginger.todolist.model;

import com.neckginger.todolist.model.statuses.WorkStatus;
import com.neckginger.todolist.security.model.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "works")
public class Work {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private WorkStatus status;
    private String title;
    private String description;

    @Singular
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "works_users", joinColumns = {
            @JoinColumn(name = "works_id", referencedColumnName = "ID") }, inverseJoinColumns = {
            @JoinColumn(name = "USERS_ID", referencedColumnName = "ID") })
    private User user;

    public Work(WorkStatus status, String title, String description){
        this.status = status;
        this.title = title;
        this.description = description;
    }
}

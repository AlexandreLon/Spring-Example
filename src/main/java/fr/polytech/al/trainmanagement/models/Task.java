package fr.polytech.al.trainmanagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Task")
public class Task {
    
    @Id
    private Long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "type", length = 128, nullable = false)
    private String type;

    @Column(name = "status", length = 128, nullable = false)
    private String status;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

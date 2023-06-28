package lk.ijse.dep10.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "module")
public class Module {
    @Id
    private String id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int duration;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinTable(name = "madule_teacher",
        joinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id", nullable = false))
    private Teacher teacher;


    public Module(String id, String description, int duration) {
        this.id = id;
        this.description = description;
        this.duration = duration;
    }
}

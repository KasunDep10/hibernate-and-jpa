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
@Table(name = "spouse")
public class Spouse {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;
    @OneToOne
    @JoinColumn(nullable = false, name = "employee_id", referencedColumnName = "id", unique = true)
    private Employee employee;
}

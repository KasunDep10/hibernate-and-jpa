package lk.ijse.deo10.nh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(columnDefinition = "VARCHAR(10)")
    private String id;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;
    @Column(nullable = false, columnDefinition = "VARCHAR(250)")
    private String address;
}

package lk.ijse.dep10.query.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
@NamedQuery(name = "query1", query = "FROM Car c WHERE c.model = :model")
public class Car {
    @Id
    @Column(name = "reg_no")
    private String regNumber;
    @Column(nullable = false)
    private String model;
}

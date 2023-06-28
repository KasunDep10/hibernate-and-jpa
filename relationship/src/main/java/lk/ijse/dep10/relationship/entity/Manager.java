package lk.ijse.dep10.relationship.entity;

import jakarta.persistence.*;
import lk.ijse.dep10.relationship.entity.util.Gender;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    private int id;
    @Column(nullable = false)
    private String name;


}

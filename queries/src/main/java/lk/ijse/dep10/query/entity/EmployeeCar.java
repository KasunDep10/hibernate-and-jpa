package lk.ijse.dep10.query.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_car")
public class EmployeeCar {

    @OneToOne
    @Id
    @JoinColumn(name = "reg_no", referencedColumnName = "reg_no")
    private Car car;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false, unique = true)
    private Employee employee;


    @Column(name = "handed_date", nullable = false)
    private Date handedDate;
}

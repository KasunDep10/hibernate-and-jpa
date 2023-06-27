package lk.ijse.deo10.nh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customer")
@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;
    @Column(nullable = false, columnDefinition = "VARCHAR(250)")
    private String address;
    @Column(name = "contact_number", columnDefinition = "VARCHAR(20)", unique = true)
    private String contactNumber;

    public Customer(String name, String address, String contactNumber) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }
}

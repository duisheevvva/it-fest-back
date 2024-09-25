package itFest.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mobilography")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mobilography {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "mobilography_gen")
    @SequenceGenerator(name = "mobilography_gen",sequenceName = "mobilography_seq",allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String linkVideo;
}

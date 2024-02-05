package med.voll.api.model.address.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable // setting this class as an object without needing to create an entity form this class
@Getter // setting the getters methods
@NoArgsConstructor // creating a constructor without args
@AllArgsConstructor // creating a constructor with all args
public class Address {
    private String street;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String uf;
    private String number;
    private String compliment;
}

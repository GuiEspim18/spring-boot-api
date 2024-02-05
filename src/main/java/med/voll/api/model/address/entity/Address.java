package med.voll.api.model.address.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.model.address.AddressData;

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

    public Address(AddressData address) {
        this.street = address.street();
        this.neighborhood = address.neighborhood();
        this.zipCode = address.zipCode();
        this.city = address.city();
        this.uf = address.uf();
        this.number = address.number();
        this.compliment = address.compliment();
    }
}

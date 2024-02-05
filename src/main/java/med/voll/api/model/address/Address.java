package med.voll.api.model.address;

public record Address(
        String street,
        String neighborhood,
        String zipCode,
        String city,
        String uf,
        String number,
        String compliment
) {
}

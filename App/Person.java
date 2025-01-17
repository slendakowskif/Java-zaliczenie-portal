package App;

public class Person {
    private String name;
    private String surname;
    private Address address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(String city, String street) {
        this.address = new Address(city, street);
    }

    @Override
    public String toString() {
        return name + " " + surname + (address != null ? ", Address: " + address : "");
    }
}
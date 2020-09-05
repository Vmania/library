package pl.umk.mat.library.publisher;

public class PublisherAddRequest {
    private String name;
    private String phoneNumber;
    private String country;


    public PublisherAddRequest(String name, String phoneNumber, String country) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }

    public PublisherAddRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

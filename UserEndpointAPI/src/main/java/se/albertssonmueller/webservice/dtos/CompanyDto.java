package se.albertssonmueller.webservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDto {

    private long id;

    private String name;
    private String website;
    private String city;

    public CompanyDto(long id, String name, String website, String city) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.city = city;
    }

    public CompanyDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

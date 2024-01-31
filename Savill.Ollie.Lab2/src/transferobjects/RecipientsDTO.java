/**
 * File name: RecipientsDTO.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package transferobjects;

/**
 * This class represents a data transfer object for recipients of awards. It
 * contains fields for the recipient's award ID, name, year of award, city of
 * residence, and category of award.
 *
 * @author savil
 */
public class RecipientsDTO {

    private Integer awardID;
    private String name;
    private Integer year;
    private String city;
    private String category;

    /**
     * Returns the ID of the award received by the recipient.
     *
     * @return the award ID
     */
    public Integer getAwardID() {
        return awardID;
    }

    /**
     * Returns the name of the recipient.
     *
     * @return the recipient name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the year the award was received by the recipient.
     *
     * @return the year of the award
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Returns the city of residence of the recipient.
     *
     * @return the recipient's city of residence
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the category of the award received by the recipient.
     *
     * @return the award category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the ID of the award received by the recipient.
     *
     * @param awardID the award ID to set
     */
    public void setAwardID(Integer awardID) {
        this.awardID = awardID;
    }

    /**
     * Sets the name of the recipient.
     *
     * @param name the recipient name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the year the award was received by the recipient.
     *
     * @param year the year of the award to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Sets the city of residence of the recipient.
     *
     * @param city the recipient's city of residence to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the category of the award received by the recipient.
     *
     * @param category the award category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

}
/*
The design pattern used in this code is the Data Transfer Object (DTO) pattern.

The RecipientsDTO class represents a simple data structure that is used to transfer 
data between layers of an application, for example, between a business logic layer 
and a presentation layer. It encapsulates the fields that describe the recipients 
of awards and provides getter and setter methods for accessing and modifying the 
data.

The use of DTOs helps to separate the data transfer from the business logic, 
improving modularity and scalability in large applications. It also reduces the 
amount of network traffic between the layers and provides a layer of abstraction 
between the layers, making it easier to modify the data model without affecting the 
application logic.
*/
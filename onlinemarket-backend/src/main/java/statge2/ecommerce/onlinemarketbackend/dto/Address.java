package statge2.ecommerce.onlinemarketbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
@NotEmpty
private String houseNo;

private String street;

private String city;

private String state;

private String Country;

private String pin;
@ManyToOne(cascade=CascadeType.ALL)
private Users user;

/**
 * @return the id
 */
public Integer getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(Integer id) {
	this.id = id;
}
/**
 * @return the houseNo
 */
public String getHouseNo() {
	return houseNo;
}
/**
 * @param houseNo the houseNo to set
 */
public void setHouseNo(String houseNo) {
	this.houseNo = houseNo;
}
/**
 * @return the street
 */
public String getStreet() {
	return street;
}
/**
 * @param street the street to set
 */
public void setStreet(String street) {
	this.street = street;
}
/**
 * @return the city
 */
public String getCity() {
	return city;
}
/**
 * @param city the city to set
 */
public void setCity(String city) {
	this.city = city;
}
/**
 * @return the state
 */
public String getState() {
	return state;
}
/**
 * @param state the state to set
 */
public void setState(String state) {
	this.state = state;
}
/**
 * @return the country
 */
public String getCountry() {
	return Country;
}
/**
 * @param country the country to set
 */
public void setCountry(String country) {
	Country = country;
}
/**
 * @return the pin
 */
public String getPin() {
	return pin;
}
/**
 * @param pin the pin to set
 */
public void setPin(String pin) {
	this.pin = pin;
}
/**
 * @return the user
 */
public Users getUser() {
	return user;
}
/**
 * @param user the user to set
 */
public void setUser(Users user) {
	this.user = user;
}


}
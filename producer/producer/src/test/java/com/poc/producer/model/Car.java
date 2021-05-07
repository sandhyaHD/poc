/**
 * 
 */
package com.poc.producer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author sandhya.devendrappa
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {

	Boolean lidOpen;
	String location;
	public Car(Boolean lidOpen, String location) {
		super();
		this.lidOpen = lidOpen;
		this.location = location;
	}
}

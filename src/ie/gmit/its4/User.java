package ie.gmit.its4;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	long userId;
	
	String firstName;
	String lastName;
	String type;
	
	@ManyToOne
	@JoinColumn(name = "membership_id")
	Membership membership;
	
//	Boolean isMember;
	
//	Date created;
//	Date updated;
//	Date deleted;
	
	public User() {
		super();
	}

	public User(long userId, String firstName, String lastName, String type,
			Membership membership) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.membership = membership;
	}

	////////// getters & setters //////////
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	////////// overrides //////////
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", type=" + type + ", membership="
				+ membership + "]";
	}
	
}

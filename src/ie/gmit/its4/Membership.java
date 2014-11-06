package ie.gmit.its4;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="membership")
public class Membership {
	
	@Id
	@GeneratedValue
	long membershipId;
	
	long price;
	String type;
	String description;
	
	@OneToMany (mappedBy="membership")
	List<User> users;
	
//	Date created;
//	Date updated;
//	Date deleted;
	
	public Membership() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Membership(long membershipId, long price, String type,
			String description, List<User> users) {
		super();
		this.membershipId = membershipId;
		this.price = price;
		this.type = type;
		this.description = description;
		this.users = users;
	}

	////////// getters & setters //////////
	
	public long getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(long membershipId) {
		this.membershipId = membershipId;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	////////// get users //////////
	//
	public List<User> getUsers() {
		if (users == null) {
			users = new ArrayList<User>();
		}
		return users;
	}
	
	////////// add user //////////
	//
	public void addUser(User u) {
		u.setMembership(this);
		this.getUsers().add(u);
	}

	////////// overrides //////////
	
	@Override
	public String toString() {
		return "Membership [membershipId=" + membershipId + ", price=" + price
				+ ", type=" + type + ", description=" + description
				+ ", users=" + users + "]";
	}	
	
}
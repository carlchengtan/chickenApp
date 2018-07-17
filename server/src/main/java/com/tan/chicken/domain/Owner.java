package com.tan.chicken.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Owner {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id //@Setter(AccessLevel.NONE)
	private Long id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "owner")
	@JsonManagedReference
	private Set<Chicken> chickens = new HashSet<>();
	
	private OwnerType ownerType;

	public Owner() {
		super();
	}
	
	public Owner(String name, OwnerType ownerType) {
		super();
		this.name = name;
		this.ownerType = ownerType;
	}

	public Owner(String name, Set<Chicken> chickens, OwnerType ownerType) {
		super();
		this.name = name;
		this.chickens = chickens;
		this.ownerType = ownerType;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addChicken(Chicken chicken) {
		this.chickens.add(chicken);
	}

	public Set<Chicken> getChickens() {
		return chickens;
	}

	public void setChickens(Set<Chicken> chickens) {
		this.chickens = chickens;
	}

	public OwnerType getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(OwnerType ownerType) {
		this.ownerType = ownerType;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + "chickens=" + chickens + ", ownerType=" + ownerType + "]";
	}
	
}

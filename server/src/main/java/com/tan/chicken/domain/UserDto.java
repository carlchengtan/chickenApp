package com.tan.chicken.domain;

public class UserDto {

    private String username;
    private String password;
    private Long role;
    
    public UserDto() {
		super();
	}

	public UserDto(String username, String password, Long role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

    

}

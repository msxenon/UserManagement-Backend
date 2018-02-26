package com.example.msa.demo;

public class UserResponseDTO {
    private String name;
    private String fullName;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private boolean success = false;
    private int id ;
    public UserResponseDTO(UserDTO userDTO ){
        if (userDTO==null)
            return;
        setFullName(userDTO.getFullName());
        setId(userDTO.getId());
        setName(userDTO.getName());
        setSuccess(id!=-1);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

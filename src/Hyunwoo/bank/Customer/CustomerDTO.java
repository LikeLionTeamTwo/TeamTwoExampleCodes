package org.example.bank.Customer;

public class CustomerDTO {
    private int user_id;
    private int password;
    private String name;
    private String birthDate;

    public CustomerDTO(int user_id, int password, String name, String birthDate) {
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.birthDate = birthDate;
    }

    public CustomerDTO() {

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "user_id=" + user_id +
                ", password=" + password +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}

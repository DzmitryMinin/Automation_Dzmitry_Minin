package entities.saucedemo;

public class UserBuilder {
    private String username;
    private String password;
    private String address;
    private Integer age;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        private final UserBuilder userBuilder;

        public Builder withUsername(String username) {
            userBuilder.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            userBuilder.password = password;
            return this;
        }

        public Builder withUAge(Integer age) {
            userBuilder.age = age;
            return this;
        }

        public Builder withAddress(String address) {
            userBuilder.address = address;
            return this;
        }

        public Builder() {
            this.userBuilder = new UserBuilder();
        }

        public UserBuilder build() {
            return userBuilder;
        }
    }

    @Override
    public String toString() {
        return "UserBuilder{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

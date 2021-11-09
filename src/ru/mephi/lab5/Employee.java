package ru.mephi.lab5;
import java.util.List;

public class Employee {

    private String givenName;
    private String surName;
    private int age;
    private GENDER gender;
    private ROLE role;
    private String dept;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String code;


    private Employee(EmployeeBuilder builder) {
        givenName = builder.givenName;
        surName = builder.surName;
        age = builder.age;
        gender = builder.gender;
        role = builder.role;
        dept = builder.dept;
        email = builder.email;
        phone = builder.phone;
        address = builder.address;
        city = builder.city;
        state = builder.state;
        code = builder.code;
    }

    // all getters and setters are in the bottom of the file
    // function createShortList is after the EmployeeBuilder class

    @Override
    public String toString() {
        // it could be done just by concatenating strings, but this is the example of using Builder pattern in StringBuilder class
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [name=").append(givenName).append(", surname=").append(surName).append(", age=").append(age)
                .append(", gender=").append(gender.getGender()).append(", role=").append(role.getRole())
                .append(", dept=").append(dept).append(", email").append(email).append(", phone=").append(phone)
                .append(", address=").append(address).append(", city=").append(city).append(", state=").append(state)
                .append(", code=").append(code).append("]");
        return builder.toString();
    }


    // ******* BUILDER CLASS *******


    public class EmployeeBuilder {

        private String givenName;
        private String surName;
        private int age;
        private GENDER gender;
        private ROLE role;
        private String dept;
        private String email;
        private String phone;
        private String address;
        private String city;
        private String state;
        private String code;

        public EmployeeBuilder() {
            super();
        }

        public Employee build() {
            Employee employee = null;
            if(checkIsCorrect()) {
                employee = new Employee(this);
            }
            else {
                System.out.println("Employee profile is wrong. Not created.");
            }
            return employee;
        }

        public boolean checkIsCorrect() {
            return (givenName != null && !givenName.trim().isEmpty() && surName != null && !surName.trim().isEmpty() &&
                    age > 0 && dept != null && !dept.trim().isEmpty() && email != null && email.matches("^(.+)@( S+)") &&
                    phone != null && !phone.matches("^[0-9\\-+]{9,15}") && address != null && !address.trim().isEmpty() &&
                    city != null && !city.trim().isEmpty() && state != null && !state.trim().isEmpty() && code != null && !code.trim().isEmpty()
            );
        }

        public EmployeeBuilder givenName(String _givenName) {
            givenName = _givenName;
            return this;
        }

        public EmployeeBuilder surName(String _surName) {
            surName = _surName;
            return this;
        }

        public EmployeeBuilder age(int _age) {
            age = _age;
            return this;
        }

        public EmployeeBuilder gender(GENDER _gender) {
            gender = _gender;
            return this;
        }

        public EmployeeBuilder role(ROLE _role) {
            role = _role;
            return this;
        }

        public EmployeeBuilder dept(String _dept) {
            dept = _dept;
            return this;
        }

        public EmployeeBuilder email(String _email) {
            email = _email;
            return this;
        }

        public EmployeeBuilder phone(String _phone) {
            phone = _phone;
            return this;
        }

        public EmployeeBuilder address(String _address) {
            address = _address;
            return this;
        }

        public EmployeeBuilder city(String _city) {
            city = _city;
            return this;
        }

        public EmployeeBuilder state(String _state) {
            state = _state;
            return this;
        }

        public EmployeeBuilder code(String _code) {
            code = _code;
            return this;
        }

    }

    public static List<Employee> createShortList() {
        return null;
        // TODO: create 7 different employees for future testing
    }




    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return givenName + " " + surName;
    }

}

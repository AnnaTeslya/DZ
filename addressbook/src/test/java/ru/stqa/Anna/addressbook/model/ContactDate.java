package ru.stqa.Anna.addressbook.model;

public class ContactDate {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String mobile;
  private final String email;

  public ContactDate(String firstname, String lastname, String address, String mobile, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.mobile = mobile;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactDate that = (ContactDate) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    return mobile != null ? mobile.equals(that.mobile) : that.mobile == null;
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactDate{" +
            "firstname='" + firstname + '\'' +
            '}';
  }
}

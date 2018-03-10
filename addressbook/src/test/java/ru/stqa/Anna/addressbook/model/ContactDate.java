package ru.stqa.Anna.addressbook.model;

import java.io.File;

public class ContactDate {
  private  int id = Integer.MAX_VALUE;
  private  String firstname;
  private  String lastname;
  private  String address;
  private  String mobile;
  private  String email;
  private  String email2;
  private  String email3;
  private  String work;
  private  String home;
  private  String allPhones;
  private  String allEmails;
  private File photo;

  public ContactDate withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public File getPhoto() {

    return photo;
  }

  public ContactDate withAllPhones(String allPhones) {
    this.allPhones = allPhones;
  return this;
  }

  public ContactDate withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }
  public String getAllEmails() {
    return allEmails;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactDate that = (ContactDate) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }
  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  public ContactDate withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactDate withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactDate withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactDate withMobilePhone(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactDate withEmail(String email) {
    this.email = email;
    return this;
  }
  public ContactDate withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactDate withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }
  public ContactDate withId(int id) {
    this.id = id;
    return this;
  }
  public ContactDate withHomePhone(String home) {
    this.home = home;
    return this;
  }
  public ContactDate withWorkPhone(String work) {
    this.work = work;
    return this;
  }

  public int getId() { return id;  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getMobilePhone() {
    return mobile;
  }
  public String getHomePhone() {
    return home;
  }
  public String getWorkPhone() {
    return work;
  }



  @Override
  public String toString() {
    return "ContactDate{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }


  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }
}

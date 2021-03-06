package com.example.photographone.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

public class Photograph  extends UserDepended{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    private  String avatar;
    private int age ;
    private Sex sex ;
    @OneToOne(optional = false)
    private Contact contact;
    private int price;
    @OneToMany
    private List<Gallery> galleries = new ArrayList<>();
    @OneToOne(optional = false)
    private  Rating rating;
    private String description = "Дані не внесені";


    //GettersAndSetters

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public Contact getContact() {
        return contact;
    }

    @Override
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int sale) {
        this.price = sale;
    }

    public List<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<Gallery> galleries) {
        this.galleries = galleries;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    //EqualsAndHashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photograph that = (Photograph) o;
        return age == that.age &&
                price == that.price &&

                Objects.equals(avatar, that.avatar) &&
                sex == that.sex &&
                Objects.equals(contact, that.contact) &&
                Objects.equals(galleries, that.galleries) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash( avatar, age, sex, contact, price, galleries, rating, description);
    }


    //Constructors
    public Photograph() {
    }

    public Photograph( String avatar, int age, Sex sex, Contact contact, int sale, List<Gallery> galleries, Rating rating, String description) {
        this.avatar = avatar;
        this.age = age;
        this.sex = sex;
        this.contact = contact;
        this.price = sale;
        this.galleries = galleries;
        this.rating = rating;
        this.description = description;
    }


    //ToString
    @Override
    public String toString() {
        return "Photograph{" +
                ", avatar='" + avatar + '\'' +
                ", Age=" + age +
                ", sex=" + sex +
                ", contact=" + contact +
                ", price=" + price +
                ", galleries=" + galleries +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
package com.VKR.library.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, description, binding, subject;// name, surname, patronymic;
    //private boolean RentSale;
    //private int Price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public boolean isRentSale() {
        return RentSale;
    }

    public void setRentSale(boolean rentSale) {
        RentSale = rentSale;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
*/
    public Book(String title, String description, String binding, String subject) {
        this.title = title;
        this.description = description;
        this.binding = binding;
        this.subject = subject;
    }

    public Book(){}
/*
    public Book(String title, String description, String binding, String subject, String name, String surname, String patronymic, boolean rentSale, int price) {
        this.title = title;
        this.description = description;
        this.binding = binding;
        this.subject = subject;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        RentSale = rentSale;
        Price = price;
    }





    private enum binding {
        SOFT,
        SOLID
    }

    private enum subject {
        forchildren,
        forschoolchildren,
        forstudents,
        fiction,
        scientific
    }
*/

}

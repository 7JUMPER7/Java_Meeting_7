package com.arseniisemenov.springapp.models;

public class User {
    private int Id;
    private String Name;
    private String Phone;
    private String Email;
    private String Blog;
    private String Note;

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    public String getBlog() {
        return Blog;
    }
    public void setBlog(String blog) {
        Blog = blog;
    }

    public String getNote() {
        return Note;
    }
    public void setNote(String note) {
        Note = note;
    }
}

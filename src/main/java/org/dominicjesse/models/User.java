package org.dominicjesse.models;

public class User {
    private String name;
    private int age;

    public User(String n) {
        name = n;
    }
    public User(String n, int a) {
        name = n; age = a;
    }

    public String getName() { return name; }
    public void setName(String n) { name = n; }
    public int getAge() { return age; }
    public void setAge(int a) { age = a; };

    @Override
    public String toString() { return getName() + "," + getAge(); }

}

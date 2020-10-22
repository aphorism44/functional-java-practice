package org.dominicjesse.models;

public class User {
    private String name;
    private int age;
    private double netWorth;

    public User(String n) {
        name = n;
    }
    public User(String n, int a) {
        name = n; age = a;
    }
    public User(String n, int a, double w) {
        name = n; age = a; netWorth = w;
    }

    public String getName() { return name; }
    public void setName(String n) { name = n; }
    public int getAge() { return age; }
    public void setAge(int a) { age = a; };
    public double getNetWorth() { return netWorth; }
    public void setNetWorth(double w) { netWorth = w; }

    @Override
    public String toString() { return getName() + ", age: " + getAge() + ", netWorth: " + getNetWorth(); }

}

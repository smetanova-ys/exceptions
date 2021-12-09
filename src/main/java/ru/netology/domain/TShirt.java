package ru.netology.domain;

import java.util.Objects;

public class TShirt extends Product{
    private String color;
    private String size;

    public TShirt() {
        super();
    }

    public TShirt(int id, String name, int price, String color, String size) {
        super(id, name, price);
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt tShirt = (TShirt) o;
        return Objects.equals(color, tShirt.color) && Objects.equals(size, tShirt.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, size);
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}

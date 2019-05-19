package denisenko.hw13.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "goods")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;

    public Good() {
    }

    public Good(double price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public Good(Long id, double price, String name, String description) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Good)) return false;
        Good good = (Good) o;
        return getId() == good.getId() &&
                Double.compare(good.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), good.getName()) &&
                Objects.equals(getDescription(), good.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice(), getName(), getDescription());
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

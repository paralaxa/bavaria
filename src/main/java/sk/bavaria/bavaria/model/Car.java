package sk.bavaria.bavaria.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CarPhoto> photos;

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<CarPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<CarPhoto> photos) {
        this.photos = photos;
    }
}

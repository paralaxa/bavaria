package sk.bavaria.bavaria.model;

import javax.persistence.*;

@Entity(name="photo")
public class CarPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    private byte[] data;

    public Long getId() {
        return id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}

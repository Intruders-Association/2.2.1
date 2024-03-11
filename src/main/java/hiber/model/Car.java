package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name ="cars")
public class Car implements Serializable {
    @Id
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    public Car() {
    }

    public Car(User user, String model, int series) {
        this.user = user;
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public User setUser(User user) {
        this.user = user;
        return user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "user=" + user +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}

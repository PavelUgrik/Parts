package testTask.parts.entities;

import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Part {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    @Column(name = "title")
    private String title;

    @Column(name = "needed")
    private boolean needed;

    @Column(name = "amount")
    private int amount;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isNeeded() {
        return needed;
    }

    public void setNeeded(boolean needed) {
        this.needed = needed;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

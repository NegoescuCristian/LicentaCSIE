package licenta.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import ro.licenta.customer.models.Category;

import java.util.Date;

@Entity
@Table(name="announce")
public class AnnounceEntity {
    
    @Id()
    @GeneratedValue
    private long id;
    private long id_user;
    private String title;
    private String description;
    private Category category;
    private Date startDate;
    private long startSum;
    private String imagePath;

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public long getStartSum() {
        return startSum;
    }
    public void setStartSum(long startSum) {
        this.startSum = startSum;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId_user() {
        return id_user;
    }
    public void setId_user(long id_user) {
        this.id_user = id_user;
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
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    
    

}

package licenta.persistence.entities;

import javax.persistence.*;

import ro.licenta.customer.models.Category;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "announce")
public class AnnounceEntity {

    @Id
    @GeneratedValue()
    private long id;
    private String title;
    private String description;
    private Category category;
    private Date startDate;
    private long startSum;
    private String imagePath;


    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity userEntity;

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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}

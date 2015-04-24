package licenta.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import ro.licenta.customer.models.Category;

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

package ro.licenta.customer.models;

public class AnnounceModel {
    
    private long userId;
    private String title;
    private String description;
    private Category category;
    private long startSum;
    private String imagePath;

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

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
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

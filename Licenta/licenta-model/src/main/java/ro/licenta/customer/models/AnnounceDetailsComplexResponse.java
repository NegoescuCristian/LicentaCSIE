package ro.licenta.customer.models;

import java.util.Date;
import java.util.List;

/**
 * Created by churmuzache on 6/25/15.
 */
public class AnnounceDetailsComplexResponse {

    private long announceId;
    private Category category;
    private String description;
    private String title;
    private Date endDate;
    private Date startDate;

    @Override
    public String toString() {
        return "AnnounceDetailsComplexResponse{" +
                "announceId=" + announceId +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", endDate=" + endDate +
                ", startDate=" + startDate +
                ", bidderDetailComplexes=" + bidderDetailComplexes +
                '}';
    }

    private List<BidderDetailComplex> bidderDetailComplexes;

    public List<BidderDetailComplex> getBidderDetailComplexes() {
        return bidderDetailComplexes;
    }

    public void setBidderDetailComplexes(List<BidderDetailComplex> bidderDetailComplexes) {
        this.bidderDetailComplexes = bidderDetailComplexes;
    }

    public long getAnnounceId() {
        return announceId;
    }

    public void setAnnounceId(long announceId) {
        this.announceId = announceId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

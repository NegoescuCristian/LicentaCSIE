package ro.licenta.customer.models;

import java.util.Date;
import java.util.List;

/**
 * Created by churmuzache on 6/11/15.
 */
public class AnnounceDetailsResponse {

    private String title;
    private String description;
    private Category category;
    private long startSum;
    private Date startDate;
    private Date endDate;
    private long announceId;

    public AnnounceDetailsResponse() {
        super();
    }

    public long getAnnounceId() {
        return announceId;
    }

    public void setAnnounceId(long announceId) {
        this.announceId = announceId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private List<BidderDetail> bidderEntityList;

    public List<BidderDetail> getBidderEntityList() {
        return bidderEntityList;
    }

    public void setBidderEntityList(List<BidderDetail> bidderEntityList) {
        this.bidderEntityList = bidderEntityList;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getStartSum() {
        return startSum;
    }

    public void setStartSum(long startSum) {
        this.startSum = startSum;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package ro.licenta.customer.models;

import java.util.List;

/**
 * Created by churmuzache on 6/11/15.
 */
public class UserAnnounceResponse {

    private String userName;

    public List<AnnounceDetailsResponse> getAnnounceDetailsResponseList() {
        return announceDetailsResponseList;
    }

    public void setAnnounceDetailsResponseList(List<AnnounceDetailsResponse> announceDetailsResponseList) {
        this.announceDetailsResponseList = announceDetailsResponseList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private List<AnnounceDetailsResponse> announceDetailsResponseList;

}

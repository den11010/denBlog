package blog.services;

/**
 * INotificationService encapsulates the logic
 * related to adding and storing the "all is good" / "error" messages
 * */

public interface INotificationService {
    void addAllGoodMessage(String message);
    void addErrorMessage(String message);
}

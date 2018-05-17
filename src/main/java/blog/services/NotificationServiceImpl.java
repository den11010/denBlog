package blog.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 *  NotificationServiceImpl stores the "all is good" and "error" messages
 *  in a List<NotificationMessage> in the HTTP session.
 *  The HTTP session is a special place where you can store objects (key -> value)
 *  and they persist for long time. HTTP session objects survive request redirection
 *  and may be accessed later, after they are created.
 * */
@Service
public class NotificationServiceImpl implements INotificationService {

    public static final String NOTIFY_MESSAGE_SESSION_KEY = "siteNotificationMessages";

    @Autowired
    private HttpSession httpSession;

    //--------------- implemented methods -------------------------------
    @Override
    public void addAllGoodMessage(String message) {
        addNotificationMessage(NotificationMessageType.ALLGOOD, message);
    }

    @Override
    public void addErrorMessage(String message) {
        addNotificationMessage(NotificationMessageType.ERROR, message);
    }
    //-------------------------------------------------------------------

    private void addNotificationMessage(NotificationMessageType type, String message){
        List<NotificationMessage> notifyMessages = (List<NotificationMessage>)
                httpSession.getAttribute(NOTIFY_MESSAGE_SESSION_KEY);
        if (notifyMessages == null){
            notifyMessages = new ArrayList<NotificationMessage>();
        }
        notifyMessages.add(new NotificationMessage(type, message));
        httpSession.setAttribute(NOTIFY_MESSAGE_SESSION_KEY, notifyMessages);
    }

    public enum NotificationMessageType{
        ALLGOOD,
        ERROR
    }

    //------------ heads up... inner class------------------------
    public class NotificationMessage{
        NotificationMessageType type;
        String text;

        public NotificationMessage(NotificationMessageType type, String text){
            this.type = type;
            this.text = text;
        }

        public NotificationMessageType getType(){
            return type;
        }

        public String getText(){
            return text;
        }

    }
    //--------------------------------------------------------------
}

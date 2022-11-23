package UI;

import logger.Logger;
import logger.LoggerFactory;
import model.User;

public class Session {

    private User user;
    private static Session instance;
    private static final Logger log = LoggerFactory.getInstance(Session.class);

    private Session() {
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }
        public void  createSession (final User user){
        log.info("Сщздана сессия с %s"+String.format(user.getUserName()));
        this.user = user;
        }

        public User getUser(){
        return this.user;
        }
}

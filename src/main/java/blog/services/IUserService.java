package blog.services;


/**
 * IUserService - an interface that implements the login authentication functionality
 * */
public interface IUserService {
    boolean authenticate(String username, String password);
}

package security;

import entity.PU;
import facades.UserFacade;

/**
 *
 * @author lam
 */
public class UserFacadeFactory {
private static final IUserFacade instance = new UserFacade(PU.getPersistenceUnitName());
    public static IUserFacade getInstance(){
        return instance;
    }
}
package facades;

import entity.Airline;
import entity.FlightReservation;
import security.IUserFacade;
import entity.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import security.IUser;
import security.PasswordStorage;

public class UserFacade implements IUserFacade {

    EntityManagerFactory emf;

    public UserFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public IUser getUserByUserId(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    /*
  Return the Roles if users could be authenticated, otherwise null
     */
    @Override
    public List<String> authenticateUser(String userName, String password) {
        IUser user = getUserByUserId(userName);
        if (user == null) {
            return null;
        }
        boolean passwordOK = false;
        try {
            passwordOK = PasswordStorage.verifyPassword(password, user.getPassword());
        } catch (PasswordStorage.CannotPerformOperationException | PasswordStorage.InvalidHashException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user != null && passwordOK ? user.getRolesAsStrings() : null;
    }

    @Override
    public IUser addUser(String userName, String password) {
        EntityManager em = getEntityManager();
        try {
            User user = new User(userName, password);
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;

        } catch (PasswordStorage.CannotPerformOperationException ex) {
            Logger.getLogger(UserFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            em.close();
        }
    }

    public User addReservation(FlightReservation reservation) {
        
        EntityManager em = getEntityManager();
        try {
           
            User u = em.find(User.class, reservation.getUserName());
            System.out.println(u);
            u.addReservations(reservation);
            
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
            return u;
        } catch (RollbackException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

}

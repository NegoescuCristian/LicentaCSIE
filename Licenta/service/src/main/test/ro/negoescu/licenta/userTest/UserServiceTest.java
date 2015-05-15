package ro.negoescu.licenta.userTest;

import licenta.persistence.dao.UserDao;
import licenta.persistence.entities.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import ro.licenta.customer.models.UserEntityResponse;
import ro.licenta.customer.models.UserRole;
import ro.negoescu.licenta.user.UserService;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    
    @Mock
    private UserDao userDaoMock;
    
    private UserService userServiceMock;
    
    @Before
    public void init(){
        userServiceMock = new UserService(userDaoMock);
    }
    
    @Test
    public void getUserByIdOk(){  
        UserEntity userMock = mockUserEntity();       
        Mockito.doReturn(userMock).when(userDaoMock).findById(Mockito.anyLong());
       
        UserEntityResponse response = userServiceMock.getUserById(Mockito.anyLong());
        assertEquals(userMock.getUserName(),response.getUserName());
        verify(userDaoMock, times(1)).findById(Mockito.anyLong());
        
    }
    
    @Test
    public void getUserByIdNull(){
        Mockito.doReturn(null).when(userDaoMock).findById(anyLong());
        UserEntityResponse response = userServiceMock.getUserById(anyLong());
        assertEquals(null, response);
        verify(userDaoMock, times(1)).findById(Mockito.anyLong());
    }
    
    @Test
    public void getUserByUsernameOk(){
       UserEntity userMock = mockUserEntity();
       Mockito.doReturn(userMock).when(userDaoMock).findByUsername(anyString());
       
       UserEntityResponse response  = userServiceMock.getUserByUserName(anyString());
       assertEquals(userMock.getUserName(), response.getUserName());
       assertEquals(userMock.getUserRole(), response.getUserRole());
       verify(userDaoMock, times(1)).findByUsername(anyString());
    }

    @Test
    public void getUserByUsernameNull(){
        Mockito.doReturn(null).when(userDaoMock).findByUsername(anyString());
        UserEntityResponse response = userServiceMock.getUserByUserName(anyString());
        assertEquals(null, response);
        verify(userDaoMock, times(1)).findByUsername(anyString());
    }
    private UserEntity mockUserEntity(){
        UserEntity userMock = new UserEntity();
        userMock.setPassword("fakePassword");
        userMock.setUserName("fakeUsername");
        userMock.setUserRole(UserRole.BUYER);
        
        return userMock;
    }
}

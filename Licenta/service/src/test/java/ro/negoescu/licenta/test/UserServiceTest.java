package ro.negoescu.licenta.test;

import licenta.persistence.dao.UserDao;
import licenta.persistence.dao.UserDetailsDao;
import licenta.persistence.entities.UserEntity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import ro.licenta.customer.models.UserEntityResponse;
import ro.licenta.customer.models.UserRole;
import ro.licenta.models.UserModel;
import ro.negoescu.licenta.user.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    
    @Mock
    private UserDao userDaoMock;
    @Mock
    private UserDetailsDao userDetailsDaoMock;
    
    private UserService userServiceMock;
    
    @Before
    public void init(){
        userServiceMock = new UserService(userDaoMock,userDetailsDaoMock);
    }
    
    @Test
    public void testGetUserByIdOk(){  
        UserEntity userMock = mockUserEntity();       
        Mockito.doReturn(userMock).when(userDaoMock).findById(Mockito.anyLong());
       
        UserEntityResponse response = userServiceMock.getUserById(Mockito.anyLong());
        assertEquals(userMock.getUserName(),response.getUserName());
        verify(userDaoMock, times(1)).findById(Mockito.anyLong());
        
    }
    
    @Test
    public void testGetUserByIdNull(){
        Mockito.doReturn(null).when(userDaoMock).findById(anyLong());
        UserEntityResponse response = userServiceMock.getUserById(anyLong());
        assertEquals(null, response);
        verify(userDaoMock, times(1)).findById(Mockito.anyLong());
    }
    
    @Test
    public void testGetUserByUsernameOk(){
       UserEntity userMock = mockUserEntity();
       Mockito.doReturn(userMock).when(userDaoMock).findByUsername(anyString());
       
       UserEntityResponse response  = userServiceMock.getUserByUserName(anyString());
       assertEquals(userMock.getUserName(), response.getUserName());
       assertEquals(userMock.getUserRole(), response.getUserRole());
       verify(userDaoMock, times(1)).findByUsername(anyString());
    }

    @Test
    public void testGetUserByUsernameNull(){
        Mockito.doReturn(null).when(userDaoMock).findByUsername(anyString());
        UserEntityResponse response = userServiceMock.getUserByUserName(anyString());
        assertEquals(null, response);
        verify(userDaoMock, times(1)).findByUsername(anyString());
    }
    
    @Test
    public void testRegisterUserTrue(){
        UserModel userMock = new UserModel();
        userMock.setAddress("fakeAddress");
        userMock.setFirstName("fakeFirstName");
        userMock.setLastName("fakeLastName");
        userMock.setPassword("fakePassword");
        userMock.setUserName("fakeUsername");
        userMock.setUserRole(UserRole.BUYER);
        
        boolean registered = userServiceMock.registerCustomer(userMock);
        assertEquals(true, registered);
        verify(userDaoMock, times(1)).persist(any(UserEntity.class));
    }
    
    private UserEntity mockUserEntity(){
        UserEntity userMock = new UserEntity();
        userMock.setPassword("fakePassword");
        userMock.setUserName("fakeUsername");
        userMock.setUserRole(UserRole.BUYER);
        
        return userMock;
    }
    
}


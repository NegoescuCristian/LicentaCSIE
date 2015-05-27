package licenta.rest.controller;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.hibernate.service.spi.InjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.*;
import ro.licenta.customer.models.AccountDetailsResponse;
import ro.licenta.customer.models.UserEntityResponse;
import ro.licenta.customer.models.UserRole;
import ro.licenta.models.UserModel;
import ro.negoescu.licenta.user.UserService;

/**
    Test class for User Controller
**/
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    
    @Mock
    private UserService userServiceMock;
    
    @InjectMocks
    private UserController userController;
    
    @Test
    public void testGetUserByIdOk(){
        UserEntityResponse userResponse = new UserEntityResponse();
        doReturn(userResponse).when(userServiceMock).getUserById(anyLong());
        
        Response response = userController.getUser(anyLong());
        
        verify(userServiceMock, times(1)).getUserById(anyLong());
        assertEquals(HttpStatus.OK.value() , response.getStatus());
    }
    
    @Test
    public void testGetUserByIdNotFound(){
        doReturn(null).when(userServiceMock).getUserById(anyLong());
        
        Response response = userController.getUser(anyLong());
        verify(userServiceMock, times(1)).getUserById(anyLong());
        assertEquals(HttpStatus.NOT_FOUND.value() , response.getStatus());
    }

    @Test
    public void testRegisterUserOk(){
        UserModel userMock = mockUserModel();
    
        doReturn(true).when(userServiceMock).registerCustomer(userMock);
        
        Response response = userController.registerCustomer(userMock);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        verify(userServiceMock, times(1)).registerCustomer(userMock);
    }
    
    @Test
    public void testRegisterUserForbidden(){
        UserModel userMock = mockUserModel();
    
        doReturn(false).when(userServiceMock).registerCustomer(userMock);
        
        Response response = userController.registerCustomer(userMock);
        assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatus());
        verify(userServiceMock, times(1)).registerCustomer(userMock); 
    }
    
    @Test
    public void testGetCustomerByUsernameOk(){
        UserEntityResponse userResponse = new UserEntityResponse();
        doReturn(userResponse).when(userServiceMock).getUserByUserName(anyString());
        
        Response response = userController.getCustomerByUsername(anyString());
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        verify(userServiceMock, times(1)).getUserByUserName(anyString());
    }
    
    @Test
    public void testGetCustomerByUsernameNotFound(){
        doReturn(null).when(userServiceMock).getUserByUserName(anyString());
        
        Response response = userController.getCustomerByUsername(anyString());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
        verify(userServiceMock, times(1)).getUserByUserName(anyString());
    }
    
    @Test
    public void testLoginOk(){
        UserModel userMock = mockUserModel();
        doReturn(true).when(userServiceMock).isValidUser(anyString(), anyString());
        
        Response response = userController.validateCustomer(userMock);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        verify(userServiceMock, times(1)).isValidUser(anyString(), anyString());
    }
    
    @Test
    public void testLoginNotFound(){
        UserModel userMock = mockUserModel();
        doReturn(false).when(userServiceMock).isValidUser(anyString(), anyString());
        
        Response response = userController.validateCustomer(userMock);
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
        verify(userServiceMock, times(1)).isValidUser(anyString(), anyString());
    }
    
    @Test
    public void testAccountDetailsOk(){
        AccountDetailsResponse accountMock = new AccountDetailsResponse();
        doReturn(accountMock).when(userServiceMock).getAccountDetails(anyString());
        
        Response response = userController.getAccountDetails(anyString());
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        verify(userServiceMock, times(1)).getAccountDetails(anyString());
    }
    
    @Test
    public void testAccountDetailsNotFound(){
        doReturn(null).when(userServiceMock).getAccountDetails(anyString());
        
        Response response = userController.getAccountDetails(anyString());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
        verify(userServiceMock, times(1)).getAccountDetails(anyString());
    }
    
    private UserModel mockUserModel(){
        UserModel userMock = new UserModel();
        userMock.setAddress("fakeAddress");
        userMock.setFirstName("fakeFirstName");
        userMock.setLastName("fakeLastName");
        userMock.setPassword("fakePassword");
        userMock.setUserName("fakeUsername");
        userMock.setUserRole(UserRole.BUYER);
        
        return userMock;
    }
}

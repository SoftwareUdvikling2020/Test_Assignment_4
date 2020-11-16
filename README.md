# Test_Assignment_4

### [Assignment](https://datsoftlyngby.github.io/soft2020fall/resources/672dd591-assignment-04.pdf)  
 


## Mockito powerups  

#### • How do you verify that a mock was called?  
``` java 
@Test
    public void mustCallStorageWhenCreatingCustomer() throws SQLException {
        // Arrange
        // Act
        var firstName = "a";
        var lastName = "b";
        employeeService.createEmployee(firstName, lastName);

        // Assert
        // Can be read like: verify that storageMock was called 1 time on the method
        //   'createCustomer' with an argument whose 'firstname' == firstName and
        //   whose 'lastname' == lastName
        verify(storageMock, times(1))
                .createEmployee(
                        argThat(x -> x.firstname.equals(firstName) &&
                                x.lastname.equals(lastName)));
    }
```
#### • How do you verify that a mock was NOT called?  
#### • How do you specify how many times a mock should have been called?  
#### • How do you verify that a mock was called with specific arguments?  
#### • How do you use a predicate to verify the properties of the arguments given to a call to the mock?  


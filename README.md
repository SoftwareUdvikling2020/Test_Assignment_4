# Test_Assignment_4

### [Assignment](https://datsoftlyngby.github.io/soft2020fall/resources/672dd591-assignment-04.pdf)  
Mathias  
Magnus  
Rasmus  
  
## Running TDD project (TicTacToe)  
  
#### Coverage report with JaCoCo  
**Run:** We used JaCoCo included in intellij --> edit configurations --> Code coverage --> picked jacJaCoCo as coverage runner  
JaCoCo result can be found in source of this project

#### Mutation testing with PITest  
**Run:** `mvn org.pitest:pitest-maven:mutationCoverage` or run through intellij Maven.   
PITest result can be found at Assigment_4/target/pit-reports/  

#### Static analysis with SonarCube  
**Run:** docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest

Gå til: Localhost:9000

Login med username: admin password: admin

Click på plusset i højre hjørne for at oprette nyt projekt til static analysis, og udfyld information for tilføjelse af projekt

Derefter kør commanden man får givet efter at havde oprettet et projekt, i roden af projektet - dermed kommer projektet op på sonarqube

Refresh siden og gå ind på projekter, hvor projektet er kommet op


Ref til guide: https://docs.sonarqube.org/latest/setup/get-started-2-minutes/

## Mockito powerups answers:  
Vi har i mange tilfælde brugt [Mockito Verify Cookbook](https://www.baeldung.com/mockito-verify) fra baeldung


#### • How do you verify that a mock was called?  
``` java 
verify(mockObject).someMethodOfMockObject(someArgument); 
```

#### • How do you verify that a mock was NOT called?  

``` java
// verify no interaction with the whole mock occurred
List<String> mockedList = mock(MyList.class);
verifyZeroInteractions(mockedList);

// verify no interaction with a specific method occurred
List<String> mockedList = mock(MyList.class);
verify(mockedList, times(0)).size();
```  

#### • How do you specify how many times a mock should have been called?  
``` java 

List<String> mockedList = mock(MyList.class);
mockedList.size();
verify(mockedList, times(1)).size();
```
  
#### • How do you verify that a mock was called with specific arguments? 
``` java 

// Eksempel lånt fra Martin
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

#### • How do you use a predicate to verify the properties of the arguments given to a call to the mock?  

``` java 
import static org.mockito.Mockito.*;


// Eksempel fra Booking opgaven

SmsMessage sms = new SmsMessage(recipient,message);
        when(smsService.sendSms(sms)).thenReturn(true);
```


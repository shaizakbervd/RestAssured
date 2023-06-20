package Testing;

import API.CreateEmployee;
import API.DeleteEmployee;
import API.FetchUserList;
import API.UpdateEmployee;
import Loggers.Log;
import Property.PropertyReader;
import Utils.TestContextSetup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class Test {

    Log log=new Log();
    PropertyReader pr = new PropertyReader();

    TestContextSetup tcs;
    public FetchUserList fetch;
    public CreateEmployee create;
    public UpdateEmployee update;
    public DeleteEmployee delete;

    private String base;
    private String randomstring;

    @BeforeClass
    public void LoadFile() throws IOException {
        this.tcs = new TestContextSetup();
        pr.Load(System.getProperty("user.dir")+"//src//test//java//Resources//config.properties");
        fetch=tcs.apimanager.FetchingUsers();
        create=tcs.apimanager.Creating_emp();
        update=tcs.apimanager.Updating_emp();
        delete=tcs.apimanager.Deleting_emp();
        base=pr.GetValue("url");
        randomstring=tcs.generate.generateRandomString(5);
    }

    @org.testng.annotations.Test(description = "fetching user data", priority = 1)
    public void FetchUserData() throws IOException {
        try{
            fetch.Fetch(base);
            log.info("fetching user data");
        } catch (Exception e){
            Assert.fail("Unable to fetch user data");
            log.error("unable to fetch user data");
        }
    }

    @org.testng.annotations.Test(description = "creating employee", priority = 2)
    public void Create_Employee() throws IOException {
        try{
            tcs.id=create.Create(pr.GetValue("name"), pr.GetValue("job"), base);
            log.info("creating new emp");
        } catch (Exception e){
            Assert.fail("Unable to create employee");
            log.error("Unable to create employee");
        }
    }

    @org.testng.annotations.Test(description = "updating employee", priority = 3, dependsOnMethods = {"Create_Employee"})
    public void Updating_Employee(){
        try{
            update.Update(tcs.id, randomstring, pr.GetValue("ujob"), base);
            log.info("updating employee");
        } catch (Exception e){
            Assert.fail("Unable to update employee");
            log.error("Unable to update employee");
        }
    }

    @org.testng.annotations.Test(description = "deleting employee", priority = 4, dependsOnMethods = {"Updating_Employee","Create_Employee"})
    public void Deleting_employee(){
        try{
            delete.Delete(tcs.id, base);
            log.info("deleting employee");
        } catch (Exception e){
            Assert.fail("Unable to delete employee");
            log.error("unable to delete employee");
        }
    }
}

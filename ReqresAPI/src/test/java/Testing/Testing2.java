package Testing;

import API.*;
import Loggers.Log;
import Property.PropertyReader;
import Utils.TestContextSetup;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Testing2 {

    Log log=new Log();
    PropertyReader pr = new PropertyReader();

    TestContextSetup tcs;
    public DeleteEmployee delete;
    public GetEmployeeDetails detail;

    private String base;

    @BeforeClass
    public void LoadFile() throws IOException {
        this.tcs = new TestContextSetup();
        pr.Load(System.getProperty("user.dir")+"//src//test//java//Resources//config.properties");
        delete=tcs.apimanager.Deleting_emp();
        detail=tcs.apimanager.Getting_details();
        base=pr.GetValue("url");
    }

    @Test(description = "getting user data", dataProvider = "getData")
    public void GetUserData(int id){
        try{
            if(id==3){
                delete.Delete(id, base);
                log.info("deleting emp id");
            }else{
                detail.GetDetails(base, id);
                log.info("getting emp details");
            }
        }catch (Exception e){
            Assert.fail("Unable to get user data");
            log.error("Unable to get user data");
        }
    }

    @DataProvider(name = "getData")
    public Object[][] getData(){
        Object[][] data = new Object[5][1];
        data[0][0] = 2;
        data[1][0] = 7;
        data[2][0] = 8;
        data[3][0] = 9;
        data[4][0] = 3;
        return data;
    }

}

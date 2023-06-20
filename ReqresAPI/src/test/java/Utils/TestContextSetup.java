package Utils;

import API.APiManager;

public class TestContextSetup {

    public APiManager apimanager;
    public RandomStringGenerator generate;

    public int id;

    public TestContextSetup(){
        apimanager=new APiManager();
        generate=new RandomStringGenerator();
    }
}

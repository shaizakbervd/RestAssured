package PayLoads;

public class PayLoad {

    public static String AddUser(String name, String job){
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}";
    }
}

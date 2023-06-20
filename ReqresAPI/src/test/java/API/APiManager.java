package API;

public class APiManager {

    public FetchUserList fetch_users;
    public CreateEmployee create_emp;
    public UpdateEmployee update_emp;
    public DeleteEmployee delete_emp;
    public GetEmployeeDetails emp_details;

    public FetchUserList FetchingUsers(){
        fetch_users=new FetchUserList();
        return fetch_users;
    }

    public CreateEmployee Creating_emp(){
        create_emp=new CreateEmployee();
        return create_emp;
    }

    public UpdateEmployee Updating_emp(){
        update_emp=new UpdateEmployee();
        return update_emp;
    }

    public DeleteEmployee Deleting_emp(){
        delete_emp=new DeleteEmployee();
        return delete_emp;
    }

    public GetEmployeeDetails Getting_details(){
        emp_details=new GetEmployeeDetails();
        return emp_details;
    }

}

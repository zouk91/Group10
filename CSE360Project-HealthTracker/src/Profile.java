
public class Profile {
	String name;
	String password;
	//profileRecords; linked list
	
	public Profile(){
		name = null;
		password = null;
	}
	public Profile(String newname, String newpassword){
		name = newname;
		password = newpassword;
	}
	public String getInfo(){
		return name + password;
	}
}

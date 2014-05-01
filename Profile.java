
public class Profile {
	String name;
	String password;
	ProfileRecords allRecords;
	//profileRecords; linked list
	
	public Profile(){
		name = null;
		password = null;
		allRecords = new ProfileRecords();
	}
	public Profile(String newname, String newpassword){
		name = newname;
		password = newpassword;
		allRecords = new ProfileRecords();
	}
	public String getInfo(){
		return this.name + this.password;
	}
	public ProfileRecords getAllRecords(){
		return allRecords;
	}
}

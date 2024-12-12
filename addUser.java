import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User{
    private int uid;
    private String uname;
    private String upassword;
    public User(int uid, String uname, String upassword){
        this.uid=uid;
        this.uname=uname;
        this.upassword=upassword;
    }
    public int getuid(){
        return uid;
    }
    public String getuname(){
        return uname;
    }
    public String getupassword(){
        return upassword;
    }
    public String toCsvRow(){
        return uid+","+uname+","+upassword;
    }
   
}
public class addUser{
    public static void main(String[] args){ //後須刪除
        String path="user.csv";
        List<User> allUsers=new ArrayList<>();
        allUsers.add(new User(1,"test","test"));
        try (BufferedWriter bw=new BufferedWriter(new FileWriter(path))){
            //標題
            bw.write("ID,name,password");
            bw.newLine();

            //寫資料
            for(User user:allUsers){
                bw.write(user.toCsvRow());
                bw.newLine();
            }
            System.out.println("寫入成功");
        

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    

}
package klrahul.studentManagement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class studentRepository {
    Map<Integer,Student> map=new HashMap<>();
    public String addstudent(Student student){
        int admno=student.getAdmNo();
        map.put(admno,student);
        return "student added";
    }
    public Student getstudent(int admno){
        return map.get(admno);
    }
    public String delstudent(int admno){
        if(!map.containsKey(admno)){
            return "Invalid admno";
        }
        map.remove(admno);
        return "student is removed";
    }
    public String update(int admno,int age){
        if(!map.containsKey(admno)){
            return null;
        }
        map.get(admno).setAge(age);
        return "updated successfully";
    }
}

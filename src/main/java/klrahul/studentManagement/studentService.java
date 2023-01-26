package klrahul.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentService {
    @Autowired
    studentRepository studentrepository;
    public String addstudent(Student student){
        return studentrepository.addstudent(student);
    }
    public Student getstudent(int admno){
        return studentrepository.getstudent(admno);
    }
    public String delstudent(int admno){
        return studentrepository.delstudent(admno);
    }
    public String update(int admno,int age){
        return studentrepository.update(admno,age);
    }


}

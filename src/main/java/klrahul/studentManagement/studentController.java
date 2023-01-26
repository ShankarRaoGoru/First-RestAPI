package klrahul.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@RestController
public class studentController {
    @Autowired
   studentService studentservice;
    //adding information
    @PostMapping("/add_student")
    public ResponseEntity addstudent(@RequestBody Student student) {
        String response=studentservice.addstudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    //getting information
    @GetMapping("/get_student")
    public ResponseEntity getstudent(@RequestParam("q") int admno){
        Student response=studentservice.getstudent(admno);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    //updating
    @PutMapping("/update_student")
    public ResponseEntity updatestudent(@RequestParam int admno,@RequestParam int age){
        String response=studentservice.update(admno,age);
        if(response==null){
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    //deleting
    @DeleteMapping("/delstudent/{admno}")
    public ResponseEntity delstudent(@PathVariable("admno") int admno){
        String response=studentservice.delstudent(admno);
        if(response=="Invalid admno"){
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

}

package services;

import com.example.EPBMapplication.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	 
		public ResponseEntity<Object> listAllUser(){                           // List of all user 
		      List<User> userList= userRepository.findAll();    
		      if (userList.isEmpty()) {
	              return new ResponseEntity<>("No User exists in the database", HttpStatus.NOT_FOUND);
	          } 
		      else 
		      {
	              return new ResponseEntity<>(userList, HttpStatus.OK);        
	          }
		}
		
		public ResponseEntity<Object> saveUser(User user){                     //Save user 
			 userRepository.save(user);
			 return new ResponseEntity<>("User Added /n Thank you for adding   ",HttpStatus.OK);
				}
		
		public ResponseEntity<Object> updateUser(User user)                    // Update user 
		{ 
			Long id= user.getId();
			DateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			   if(userRepository.existsById(id)) {
				    userRepository.save(user);
				 return new ResponseEntity<>("user Updated thank you",HttpStatus.OK);
			   } 
			   else 
			   { 
				   return new ResponseEntity<>("",HttpStatus.NOT_FOUND);
			   }
		}
		
		
		public ResponseEntity<Object> deleteUser(User user){                   //Delete user
			Long id = user.getId();
			if(userRepository.existsById(id)) {
				userRepository.delete(user);
				return new ResponseEntity<>(" User has been Deleted",HttpStatus.OK);
			}
			else 
				{return new ResponseEntity<>("user Not exists Please enter Valid ID",HttpStatus.NOT_FOUND);}
				
			}
		
		
		
		public ResponseEntity<Object> getUser(Long id){
			Optional<User> user = userRepository.findById(id);
			if(user.isPresent())
			{
				return new ResponseEntity<>(user,HttpStatus.FOUND);
			}
			else
			{
				return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
			}
		}
		
		
		

}

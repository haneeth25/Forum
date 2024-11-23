import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrl: './user-login.component.css'
})
export class UserLoginComponent {
  userName:string = ''
  password:string = ''
  userdetails:any
  currentUser:any
  email:string = ''
  newuserName:string = ''
  newpassword:string = ''

  constructor(private http:HttpClient, private userService: UserService,private route:Router){

  }

  onLogin(){
    let body = {
      "userName" : this.userName,
      "password" : this.password
    }
    // ?userName=userNameValue&password=passwordValue}
    this.http.get(`http://localhost:8080/user/check?userName=${this.userName}&password=${this.password}`).subscribe((data) =>{
      if (data){
      this.userdetails = data;
      this.userService.setUserName(this.userdetails.userName)
      this.currentUser = this.userService.getCurrentUserName()
      this.route.navigate([""])
      }
      else{
        alert("In valid user name or password");
      }
    })
  }

  // onSignUp(){
  //   let body = {
  //     "userName" : this.newuserName,
  //     "password" : this.newpassword,
  //     "email":this.email
  //   }
  //   // ?userName=userNameValue&password=passwordValue}
  //   this.http.post("http://localhost:8080/create-user",body).subscribe((data) =>{
  //     if (data == "Created"){
  //     this.userdetails = data;
  //     this.userService.setUserName(this.userdetails.userName)
  //     this.currentUser = this.userService.getCurrentUserName()
  //     this.route.navigate([""])
  //     }
  //     else{
  //       alert("In valid user name or password");
  //     }
  //   })
  // }

  temp(){
    this.route.navigate([""])
  }


  onSignUp() {
    let body = {
        "userName": this.newuserName,
        "password": this.newpassword,
        "userEmail": this.email // Make sure to use the correct property name
    };
    
    this.http.post("http://localhost:8080/create-user", body, { responseType: 'text' }).subscribe((response) => {
        // Check if the response indicates success
        const jsonResponse = JSON.parse(response);
        if (jsonResponse.message === "User Created") {
            this.userdetails = jsonResponse;
            this.userService.setUserName(this.userdetails.userName);
            this.currentUser = this.userService.getCurrentUserName();
            alert("User Created please login")
          //   this.temp()// Navigate to the desired page on success
          //   setTimeout(() => {
          //     window.location.reload(); // This will refresh the entire page
          // }, 100);
        } else {
            alert("User already exists"); // Alert with the message returned from the server
        }
}, (error) => {
        alert("User already exists"); // Handle error cases
    });
}

}


import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { RouterModule, Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-create-questions',
  templateUrl: './create-questions.component.html',
  styleUrl: './create-questions.component.css'
})
export class CreateQuestionsComponent implements OnInit{
  description:string = ''
  headline:string = ''
  topics:string = ''
  currentUser:any;
  userAvailable:any;
  user:any[]=[]
  constructor(private http:HttpClient, private router:Router,private userService:UserService){
    if (this.userService.getCurrentUserName()){
      this.userAvailable = true
    }
    else{
      this.userAvailable = false
    }
    this.user.push(this.userAvailable,this.currentUser)
    console.log(this.userAvailable)
    console.log(this.userAvailable)
  }

  ngOnInit(): void {
    this.currentUser = this.userService.getCurrentUserName()
    console.log(this.currentUser)
  }

  onSubmit(){
  this.postMethod()
  this.router.navigate(["/home"])
  }
  
  public postMethod(){
    let body = {
      'question':this.description,
      'heading':this.headline,
      'topics':this.topics,
      'userName':this.currentUser
    }
    console.log(body)
    this.http.post("http://localhost:8080/create-question",body).subscribe(()=>window.location.reload())
  }
}

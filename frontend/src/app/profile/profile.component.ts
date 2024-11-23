import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{
  currentUser:any;
  userAvailable:boolean
  final_question:any;
  value:any;
  total:any;
  details:any;
  question:any;
  answers:any;
  user:any[]=[];
  questionId:any;
  canDelete:boolean=false
  constructor(private route:ActivatedRoute,private http:HttpClient,private router:Router,private userService:UserService){
    this.currentUser = this.userService.getCurrentUserName();
    console.log(this.currentUser)
    if (this.userService.getCurrentUserName()){
      this.userAvailable = true
    }
    else{
      this.userAvailable = false
    }
    this.user.push(this.userAvailable,this.currentUser)
    console.log(this.userAvailable)
    route.paramMap.subscribe((params) => {this.value = params.get("userName");console.log(params);this.getDetails()});
  }

  ngOnInit(): void {
      
  }

  getDetails(){
    console.log(this.value)
    this.http.get(`http://localhost:8080/profile/${this.value}`).subscribe((data)=>{this.total = data;this.question = this.total.questionResponseForProfiles
      ;this.answers=this.total.answerResponseForProfiles;this.details = this.total.userEntities;
      if(this.details.userName == this.currentUser){
      this.canDelete = true;
    }
  })
  }

  delete(questionId:any){
    this.questionId = questionId;
    this.http.get(`http://localhost:8080/delete/${questionId}`).subscribe(()=>{window.location.reload()})
    console.log(questionId)
    this.router.navigate(["/profile",this.currentUser])
  }

}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';


interface Question {
  questionId: number;
  question: string;
  heading: string;
  topics: string;
  timestamp: string | null;
  userName:string;
  canDelete:boolean;
}
interface Topics{
  topicId: number;
  topicName:string;
  questionCount:number
}

interface ApiResponse {
  questions: Question[];
  topics: Topics[];
}

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent implements OnInit{

  userAvailable:boolean = false;
  user:any[]=[];
  public question_topic_data:any;
  questions:any[] = [];
  topics:any[] = [];
  need_reload:boolean = true;
  currentUser:any;
  constructor(private http:HttpClient,private router:Router,private userService:UserService){
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
  }
  ngOnInit(): void {
    this.getMethod()
  }
  public getMethod(){
    this.questions = [];
    this.topics = [];
    // this.http.get("http://localhost:8080/question-topic").subscribe((data) => {this.question_topic_data = data;this.questions = this.question_topic_data.questions})
    //this.http.get("http://localhost:8080/question-topic").subscribe((data) => {console.log(data)})
    this.http.get<ApiResponse>(`http://localhost:8080/question-topic/${this.currentUser}`).subscribe({next:(data) => {this.questions = data.questions;this.topics=data.topics;console.log(data)},})
    console.log(this.questions)
  }
  // logout(){
  //   this.userService.logout(); // Call the logout method
  //   console.log('Logged out successfully');
  //   this.router.navigate([""])
  // }
}

import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';
@Component({
  selector: 'app-topic-filter-page',
  templateUrl: './topic-filter-page.component.html',
  styleUrl: './topic-filter-page.component.css'
})
export class TopicFilterPageComponent implements OnInit {
  topic_id : string | null=null;
  topic_name :any;
  topic_data:any;
  topic_questions: any;
  final_question:any[] = [];
  currentUser:any;
  userAvailable:boolean;
  user:any[]=[]
  constructor(private route:ActivatedRoute,private http:HttpClient,private userService:UserService){
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
    this.route.paramMap.subscribe((params) => {this.topic_id = params.get("topic_id")})
    this.getQuestions()
  }

  getQuestions(){
    console.log("entering")
    this.http.get(`http://localhost:8080/topic-filter/${this.topic_id}`).subscribe((data) => {this.topic_data = data;console.log(data);this.topic_questions = this.topic_data.questions;
      this.topic_name = this.topic_data.topicName;
      this.final_question = [];
      for (let question of this.topic_questions) {
      question["canDelete"] = (question.userName === this.userService.getCurrentUserName());
      this.final_question.push(question);
    }
      })
    console.log(this.topic_questions)

  }


}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrl: './search-bar.component.css'
})
export class SearchBarComponent implements OnInit {
  
  value:String|null = '';
  all_data:any;
  fortopics:any;
  questions:any;
  no_topics:boolean=true;
  no_questions:boolean=true;
  final_question:any[] = [];
  currentUser:any;
  userAvailable:boolean;
  user:any[] = []
  constructor(private http:HttpClient,route:ActivatedRoute,private userService:UserService){
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
    this.fortopics = [];
    this.questions = [];
    route.paramMap.subscribe((params) => {this.value = params.get("value");this.getDetails()});
    this.getDetails()
  }
  ngOnInit(): void {
    
  }

  getDetails(){
    this.http.get(`http://localhost:8080/search/${this.value}`).subscribe((data)=>{this.all_data = data;this.fortopics = this.all_data.topicsEntities;
    this.questions = this.all_data.questionsEntity;
    if (this.fortopics.length>0){
      this.no_topics = false
    }; 
    if (this.questions.length>0){
      this.no_questions = false
    };
    this.final_question = [];
    for (let question of this.questions) {
      question["canDelete"] = (question.userName === this.userService.getCurrentUserName());
      this.final_question.push(question);
    }  
    
    })
    this.no_topics= true;
    this.no_questions= true;
  }
  
}

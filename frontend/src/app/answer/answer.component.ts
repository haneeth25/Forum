import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';

interface QuestionAndAnswer{
  questionId: number;
  question: string;
  heading: string;
  topics: string;
  timestamp: string | null;
}
interface ApiResponseQuestionAndAnswer{
  questions:QuestionAndAnswer[]
}

@Component({
  selector: 'app-answer',
  templateUrl: './answer.component.html',
  styleUrl: './answer.component.css'
})
export class AnswerComponent implements OnInit{

  questionId:String|null = null
  questionDetails:any;
  questionAnswerData:any;
  question:any;
  answer_id :any
  answer:any;
  id:any;
  headline:any;
  existing_answers:boolean = false;
  new_answer : any;
  currentUser:any;
  userAvailable:boolean
  final_question:any;
  user:any[]=[]
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
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((parms) => {this.questionId = parms.get("questionId");if(this.questionId){this.getQuestionAnswer()}})
  }

  getQuestionAnswer(){
    this.http.get<ApiResponseQuestionAndAnswer>(`http://localhost:8080/answer/${this.questionId}`).subscribe({next:(data) => {this.questionDetails = data;console.log(data);
      if(this.questionDetails.answers.length > 0){
      this.existing_answers = true;
      this.final_question = [];
      for (let question of this.questionDetails.answers) {
        question["canDelete"] = (question.userName === this.userService.getCurrentUserName());
        this.final_question.push(question);
    } 
    }
    }})
    console.log(this.questionAnswerData)
  }
  onSubmit(){
    let body ={
      'answer':this.new_answer,
      'questionId':this.questionId,
      'userName':this.currentUser
    }
    console.log(body);
    this.http.post(`http://localhost:8080/answer/${this.questionId}`,body).subscribe(()=>{window.location.reload();});
  }

  delete(temp:any){
    this.http.get( `http://localhost:8080/delete/answer/${temp}`).subscribe(()=>{window.location.reload();})
    this.router.navigate(["http://localhost:8080/answer/",this.questionId])
  }

}

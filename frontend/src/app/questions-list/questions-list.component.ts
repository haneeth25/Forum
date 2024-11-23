import { HttpClient } from '@angular/common/http';
import { Component, Input,EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-questions-list',
  templateUrl: './questions-list.component.html',
  styleUrl: './questions-list.component.css'
})
export class QuestionsListComponent {
  @Input() questions:any;
  @Output() refresh: EventEmitter<void> = new EventEmitter<void>(); // Event emitter for refresh

  
  questionId : any;

  constructor(private http:HttpClient,private route:Router){

  }

  delete(questionId:any){
    this.questionId = questionId;
    this.http.get(`http://localhost:8080/delete/${questionId}`).subscribe(()=>{window.location.reload()})
    console.log(questionId)
    this.route.navigate(["/home"])
  }
}

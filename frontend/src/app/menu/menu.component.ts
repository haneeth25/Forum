import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent implements OnInit{

  value:string=""
  @Input() userAvailable:any;
  @Input() user:any[] = [];
  constructor(private route:Router,private userService:UserService){

  }
  ngOnInit(): void {
      // if (!this.userService.getCurrentUserName()){
      //   this.userAvailable = true
      // }
      // else{
      //   this.userAvailable = false
      // }
      // console.log(this.userAvailable)
  }
  onSubmit(){
    this.route.navigate(["/search",this.value])
  }
  logout(){
    this.userService.logout(); // Call the logout method
    console.log('Logged out successfully');
    this.route.navigate([""])
    window.location.reload()
  }
}

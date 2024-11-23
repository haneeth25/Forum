import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { CreateQuestionsComponent } from './create-questions/create-questions.component';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { TopicFilterPageComponent } from './topic-filter-page/topic-filter-page.component';
import { AnswerComponent } from './answer/answer.component';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { ProfileComponent } from './profile/profile.component';

const routes: Routes = [
  {
    path: "create-question",
    component:CreateQuestionsComponent
  },
  {
    path:'',
    component:HomePageComponent
  },
  {
    path:'topic-filter/:topic_id',
    component:TopicFilterPageComponent
  },
  {
    path:'answer/:questionId',
    component:AnswerComponent
  },
  {
    path:"home", redirectTo:"",pathMatch:'full'
  },
  {
  path:'search/:value',
  component:SearchBarComponent
  },
  {
    path:'login',
    component:UserLoginComponent
  },
  {
    path:"profile/:userName",
    component:ProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

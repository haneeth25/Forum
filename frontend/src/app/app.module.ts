import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; 

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { CreateQuestionsComponent } from './create-questions/create-questions.component';
import { HttpClientModule } from '@angular/common/http';  // Import HttpClientModule here
import { RouterModule } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { TopicFilterPageComponent } from './topic-filter-page/topic-filter-page.component';
import { QuestionsListComponent } from './questions-list/questions-list.component';
import { AnswerComponent } from './answer/answer.component';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { ProfileComponent } from './profile/profile.component';


@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    CreateQuestionsComponent,
    HomePageComponent,
    TopicFilterPageComponent,
    QuestionsListComponent,
    AnswerComponent,
    SearchBarComponent,
    UserLoginComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userNameSubject = new BehaviorSubject<string | null>(this.getUserNameFromStorage());
  userName$ = this.userNameSubject.asObservable();

  setUserName(userName: string) {
    this.userNameSubject.next(userName);
    localStorage.setItem('currentUserName', userName); 
  }

  logout() {
    this.userNameSubject.next(null);
    localStorage.removeItem('currentUserName');
  }
  getCurrentUserName(): string | null {
    return this.userNameSubject.getValue();
  }

  private getUserNameFromStorage(): string | null {
    return localStorage.getItem('currentUserName');
  }
}

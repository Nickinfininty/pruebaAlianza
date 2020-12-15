import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})

export class UserListComponent implements OnInit {

  users: User[];
  search: string = 'sharedKey';

  constructor(private userService: UserService, private datePipe: DatePipe) {

  }

  ngOnInit() {
      this.userService.todos().subscribe(data => {
      this.users = data;
    });
  }

  formatdate(date)
  {
    return this.datePipe.transform(date, "dd/MM/yyyy")
  }


  buscar(term){
    this.users = [];
    this.userService.todos().subscribe(data => {
      data.forEach(user => {
        if(user.sharedKey.includes(term.value))
          this.users.push(user)
      });
    });
  }

}

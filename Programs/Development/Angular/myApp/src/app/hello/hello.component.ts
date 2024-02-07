import { Component } from '@angular/core';
@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent {
  courseName: string = "Angular";
  changeName() {
        this.courseName = "TypeScript";
    }
changeNameWithThis(course:string) { 
    this.courseName = course; 
    }
}

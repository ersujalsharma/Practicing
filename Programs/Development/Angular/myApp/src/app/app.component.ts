import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  myChoice: number = 0;
  nextChoice() {
    this.myChoice++;
  }
  firstImage = false;
  first(){
    this.firstImage = true;
  }
  second(){

  }
  third()
}



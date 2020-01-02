import { Component, OnInit } from '@angular/core';
import { EmailService } from './email.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css'],
  providers: [EmailService]
})
export class EmailComponent implements OnInit {

  emailData: any = [];
  folder: string = 'INBOX';

  constructor(private service: EmailService) { }

  ngOnInit() {
    this.service.loadInbox("", this.folder)
      .subscribe(resp => {

        console.log(resp);

        if (resp.statusCode == 200) {
          this.emailData = resp.model;
        } else {
          alert(resp.erroMessage);
        }
      });
  }


  changeFolder(folderName: string) {
    console.log(folderName);
    this.folder = folderName;

    this.service.loadInbox("", this.folder)
    .subscribe(resp => {

      console.log(resp);
      let tempMails = [];

      if (resp.statusCode == 200) {
        //this.emailData = resp.model;
        this.emailData.forEach(ele => {
          if(this.folder != ele.folder) {
            tempMails.push(ele);
          }
      });
      console.log(this.emailData + 'temp mails : ' + tempMails);
      this.emailData = [...tempMails];
      } else {
        alert(resp.erroMessage);
      }
    });
  }

  moveToFolder(folderName, id) {
    this.service.moveToFolder(folderName, id).subscribe(resp => {

      console.log(resp);

      if (resp.statusCode == 200) {
        this.emailData = resp.model;
      } else {
        alert(resp.erroMessage);
      }
    });
  }

}

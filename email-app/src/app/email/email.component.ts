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
  compose = false;
  composeMailData: any = {};
  editable = true;

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
    this.compose = false;
    this.composeMailData = {};
    

    this.service.loadInbox("", this.folder)
    .subscribe(resp => {

      console.log(resp);
      //let tempMails = [];

      if (resp.statusCode == 200) {
        this.emailData = resp.model;
      //   this.emailData.forEach(ele => {
      //     if(this.folder != ele.folder) {
      //       tempMails.push(ele);
      //     }
      // }
      //);
      //console.log(this.emailData + 'temp mails : ' + tempMails);
      //this.emailData = [...tempMails];
      } else {
        alert(resp.erroMessage);
      }
    });
  }

  moveToFolder(folderName, id) {
    this.compose = false;

    this.service.moveToFolder(folderName, id).subscribe(resp => {

      console.log(resp);

      if (resp.statusCode == 200) {
        this.emailData = resp.model;
      } else {
        alert(resp.erroMessage);
      }
    });
  }

  
  composeMail() {
    this.compose = true;
    this.editable = true;
    this.composeMailData = {};
  }

  viewEmail(emailData: any) {
    this.editable = false;
    this.composeMailData = {...emailData};
    this.compose = true;
  }

  sendEmail() {

    this.composeMailData.folder = "SEND";
    this.composeMailData.isSpam = false;

    let tempArr = [];
    if(this.composeMailData.receipt.indexOf(";") != -1) {     
      this.composeMailData.receipt.split(";").forEach(element => {
        tempArr.push(element);
      });     
    } else {
      tempArr.push(this.composeMailData.receipt);
    }
    this.composeMailData.receipt = tempArr;
    
   
    if(this.composeMailData.ccReceipt) {
      tempArr = [];
      if(this.composeMailData.ccReceipt.indexOf(";") != -1) {     
        this.composeMailData.ccReceipt.split(";").forEach(element => {
          tempArr.push(element);
        });        
      } else {
        tempArr.push(this.composeMailData.receipt);
      }

      this.composeMailData.ccReceipt = tempArr;
    }


    if(!this.composeMailData.sender)
        this.composeMailData.sender = "defaultsender@test.com"
    
    console.log("Email sender : " + this.composeMailData.sender);
    console.log("Email receipt : " + this.composeMailData.receipt);
    console.log("Email ccReceipt : " + this.composeMailData.ccReceipt);
    console.log("Email subject : " + this.composeMailData.subject);
    console.log("Email folder : " + this.composeMailData.folder);

    this.service.sendEmail(this.composeMailData).subscribe(resp => {

      console.log(resp);

      if (resp.statusCode == 200) {
        this.changeFolder(this.composeMailData.folder);
      } else {
        alert(resp.erroMessage);
      }
    });
  }

}

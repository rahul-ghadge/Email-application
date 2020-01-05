import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};


@Injectable({
  providedIn: 'root'
})
export class EmailService {

  HOST = 'http://localhost:8080';
  //HOST = "http://192.168.0.104:8080"
  API_ENDPOINT = this.HOST + '/email';

  constructor(private http : HttpClient) { }

 


  loadInbox(sender, folder):any {
    return this.http.get<any>(this.API_ENDPOINT + "/get?folder=" + folder + '&sender=' + sender);
  }

  moveToFolder(folder, id):any {
    return this.http.get<any>(this.API_ENDPOINT + "/move?folder=" + folder + '&id=' + id);
  }

  sendEmail(emailData) {

    //httpOptions.headers.append('Access-Control-Allow-Origin', this.HOST);
    httpOptions.headers.append('Access-Control-Allow-Methods', 'POST, GET, PUT, OPTIONS, DELETE, PATCH');
    httpOptions.headers.append('Access-Control-Allow-Headers', 'X-Requested-With, content-type Origin, Accept');
    httpOptions.headers.append('Access-Control-Allow-Credentials', 'true');
    httpOptions.headers.append("Access-Control-Allow-Origin", "*");


    return this.http.post<any>(this.API_ENDPOINT + "/send-email", emailData, httpOptions);
  }

}

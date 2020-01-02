import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  API_ENDPOINT = 'http://localhost:8080/email';

  constructor(private http : HttpClient) { }


  loadInbox(sender, folder):any {
    return this.http.get<any>(this.API_ENDPOINT + "?folder=" + folder + '&sender=' + sender);
  }

  moveToFolder(folder, id):any {
    return this.http.get<any>(this.API_ENDPOINT + "/move" + "?folder=" + folder + '&id=' + id);
  }

}

import { Component } from '@angular/core';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { HttpService } from 'src/app/auth/auth.service';
import { Book } from 'src/app/models';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent {
  title: string | null = null;
  public books: Array<Book> = [];
  private bookId!: number;

  constructor(
    public modalRef: MdbModalRef<ModalComponent>,
    private httpService: HttpService
    ) {}
  
  }

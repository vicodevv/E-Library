import { Component, OnInit } from '@angular/core';
import { APIResponse, Book } from 'src/app/models';
import { HttpService } from 'src/app/auth/auth.service';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { ModalComponent } from '../modal/modal.component';
import {PageEvent} from '@angular/material/paginator';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {
  public books: Array<Book> = [];
  modalRef: MdbModalRef<ModalComponent> | null = null;

  length = 50;
  pageSize = 10;
  pageIndex = 0;
  pageSizeOptions = [5, 10, 25];

  hidePageSize = false;
  showPageSizeOptions = true;
  showFirstLastButtons = true;
  disabled = false;

  pageEvent!: PageEvent;

  handlePageEvent(e: PageEvent) {
    this.pageEvent = e;
    this.length = e.length;
    this.pageSize = e.pageSize;
    this.pageIndex = e.pageIndex;
  }

  constructor(
    private httpService: HttpService,
    private modalService: MdbModalService
  ) { }

  ngOnInit(): void {
    this.getBooks();
  }

  getBooks() {
    this.httpService.getAllBooks().subscribe((response: any) => {
      this.books = response;
      console.log(response);
    });
  }
  openModal() {
    this.modalRef = this.modalService.open(ModalComponent, {
      modalClass: 'modal-dialog-centered modal-dialog-scrollable',
    })
  }
  borrowBook(bookId: number){
    this.httpService.borrowBook(bookId).subscribe(
      (response: any) => {
        console.log(response);
        this.getBooks();
      }
    );
  }

}

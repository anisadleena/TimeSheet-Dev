import { Component, OnInit } from '@angular/core';
import { ModalService } from '../services/modal.service';

@Component({
  selector: 'app-nav',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class NavComponent implements OnInit {

  constructor(public modal: ModalService) { }

  ngOnInit(): void {
    
  }

  openModal($event: Event) {
    $event.preventDefault();
    this.modal.toggleModal('auth');
    // console.log('Modal is open:', this.modal.isModalOpen());
  }

}

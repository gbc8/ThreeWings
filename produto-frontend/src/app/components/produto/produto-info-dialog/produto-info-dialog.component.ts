import { Component, Inject } from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Produto } from '../model/produto.model'

@Component({
  selector: 'app-produto-info-dialog',
  templateUrl: './produto-info-dialog.component.html',
  styleUrls: ['./produto-info-dialog.component.css'],
  standalone: true,
})
export class ProdutoInfoDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: Produto) {}

}

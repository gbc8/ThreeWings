import { Component, Inject } from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Produto } from '../model-produto/produto.model'

@Component({
  selector: 'app-detalhes-produto',
  templateUrl: './detalhes-produto.component.html',
  styleUrls: ['./detalhes-produto.component.css'],
  standalone: true,
})
export class DetalhesProdutoComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: Produto) {}

}

import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Produto } from '../model/produto.model';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-editar-produto',
  templateUrl: './editar-produto.component.html',
  styleUrls: ['./editar-produto.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatSelectModule, MatButtonModule, FormsModule],
})
export class EditarProdutoComponent {
  novoProduto: Produto;

  constructor(@Inject(MAT_DIALOG_DATA) public data: Produto, public dialogRef: MatDialogRef<EditarProdutoComponent>,) {
    this.novoProduto = {
      id: data.id,
      nome: data.nome,
      categoria: data.categoria,
      descricao: data.descricao,
      quantidade: data.quantidade 
    }
  }
  
  atualizarProduto(){
    this.dialogRef.close(this.novoProduto);
  }
}

import { Component } from '@angular/core';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {ProdutoService} from '../../../service/produto.service';
import {ProdutoDTO} from '../model-produto/produtoDTO.model';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { catchError } from 'rxjs';

@Component({
  selector: 'app-cadastro-produto',
  templateUrl: './cadastro-produto.component.html',
  styleUrls: ['./cadastro-produto.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatSelectModule, MatButtonModule, FormsModule],
})
export class CadastroProdutoComponent {
  produto: ProdutoDTO;

  constructor(public produtoService: ProdutoService, private router: Router) {
    this.produto = {
      nome: '',
      categoria: '',
      descricao: '',
      quantidade: 0,
    }
  }

  adicionarProduto(){
    this.produtoService.inserirProduto(this.produto)
    .subscribe((result) => {
      console.log(result);
      this.router.navigate(['/']);
      },
      (error) => {
        alert(error.error);
      }
    );
  }

  cancelarOperacao(){
    this.router.navigate(['/']);
  }
}

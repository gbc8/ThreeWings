import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroProdutoComponent } from './components/produto/cadastro-produto/cadastro-produto.component';
import { TabelaProdutoComponent } from './components/produto/tabela-produto/tabela-produto.component';

const routes: Routes = [
  {
    path: '',
    component: TabelaProdutoComponent
  },
  {
    path: 'cadastro',
    component: CadastroProdutoComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

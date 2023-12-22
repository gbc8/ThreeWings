import {Component, ViewChild} from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule, MatTable} from '@angular/material/table';
import {Produto} from '../model-produto/produto.model';
import {ProdutoService} from 'src/app/service/produto.service';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {DetalhesProdutoComponent} from '../detalhes-produto/detalhes-produto.component';
import {EditarProdutoComponent} from '../editar-produto/editar-produto.component';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-tabela-produto',
  templateUrl: './tabela-produto.component.html',
  styleUrls: ['./tabela-produto.component.css'],
  standalone: true,
  providers: [ProdutoService],
  imports: [MatTableModule, MatPaginatorModule, MatButtonModule, MatIconModule]
})
export class TabelaProdutoComponent {
  dataSource = new MatTableDataSource<Produto>([]);
  displayedColumns: string[] = ['id', 'nome', 'categoria', 'quantidade', 'action'];
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  constructor(public produtoService: ProdutoService, public dialog: MatDialog){
    this.produtoService.getProdutos()
      .subscribe((data: Produto[]) => {
        this.dataSource = new MatTableDataSource<Produto>(data.sort((a,b) => a.id-b.id));
        this.dataSource.paginator = this.paginator;
      });
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  viewProduto(produto: Produto): void {
    this.dialog.open(DetalhesProdutoComponent, {
      data: produto,
    });
  }

  editarProduto(produto: Produto): void{
    const dialogRef = this.dialog.open(EditarProdutoComponent, {
      data: produto,
    });

    dialogRef.afterClosed().subscribe(result => {
      this.produtoService.editarProduto(result)
      .subscribe(() => {
        this.produtoService.getProdutos()
          .subscribe(
          (data) => {
            this.dataSource = new MatTableDataSource<Produto>(data.sort((a,b) => a.id-b.id));
            this.dataSource.paginator = this.paginator;
          },
          (error) => {
            alert(error.error);
          });
      });
    })
  }

  removerProduto(id: number): void {
    this.produtoService.removerProduto(id)
      .subscribe(() => {
        this.dataSource = new MatTableDataSource<Produto>(this.dataSource.data.filter(p => p.id !== id));
        this.dataSource.paginator = this.paginator;
      });
  }  
}
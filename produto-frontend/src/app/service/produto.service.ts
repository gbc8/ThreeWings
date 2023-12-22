import { Injectable } from '@angular/core';
import {Produto} from '../components/produto/model/produto.model'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  produtoApiUrl = 'http://localhost:8081/api/produto';
  
  constructor(private http: HttpClient) { }

  getProdutos(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.produtoApiUrl);
  }

  getProduto(element: Produto): Observable<Produto[]> {
    return this.http.get<Produto[]>(`${this.produtoApiUrl}/${element.id}`);
  }

  inserirProduto(element: Produto): Observable<Produto> {
    return this.http.post<Produto>(this.produtoApiUrl, element);
  }

  editarProduto(element: Produto): Observable<Produto> {
    return this.http.put<Produto>(`${this.produtoApiUrl}/${element.id}`, element);
  }

  removerProduto(id: number): Observable<Produto> {
    return this.http.delete<Produto>(`${this.produtoApiUrl}/${id}`);
  }

}

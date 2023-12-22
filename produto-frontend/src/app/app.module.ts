import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatDialogModule} from '@angular/material/dialog';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MainNavComponent } from './components/main-nav/main-nav.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { TabelaProdutoComponent } from './components/produto/tabela-produto/tabela-produto.component';
import { MatTableModule } from '@angular/material/table';
import { CadastroProdutoComponent } from './components/produto/cadastro-produto/cadastro-produto.component';
import { HttpClientModule } from '@angular/common/http';
import { ProdutoInfoDialogComponent } from './components/produto/produto-info-dialog/produto-info-dialog.component';
import { EditarProdutoComponent } from './components/produto/editar-produto/editar-produto.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    MainNavComponent,
    CadastroProdutoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    TabelaProdutoComponent,
    MatTableModule,
    HttpClientModule,
    ProdutoInfoDialogComponent,
    MatDialogModule,
    EditarProdutoComponent,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

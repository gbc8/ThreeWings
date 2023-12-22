import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutoInfoDialogComponent } from './produto-info-dialog.component';

describe('ProdutoInfoDialogComponent', () => {
  let component: ProdutoInfoDialogComponent;
  let fixture: ComponentFixture<ProdutoInfoDialogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProdutoInfoDialogComponent]
    });
    fixture = TestBed.createComponent(ProdutoInfoDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

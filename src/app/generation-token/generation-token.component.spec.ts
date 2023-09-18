import { ComponentFixture, TestBed } from '@angular/core/testing';
import { GenerationTokenComponent } from './generation-token.component';

describe('GenerationTokenComponent', () => {
  let component: GenerationTokenComponent;
  let fixture: ComponentFixture<GenerationTokenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenerationTokenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GenerationTokenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

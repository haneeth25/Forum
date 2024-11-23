import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopicFilterPageComponent } from './topic-filter-page.component';

describe('TopicFilterPageComponent', () => {
  let component: TopicFilterPageComponent;
  let fixture: ComponentFixture<TopicFilterPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TopicFilterPageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TopicFilterPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
